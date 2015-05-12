package services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import javax.ejb.Stateless;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Stateless
@Path("descargador")
public class DescargadorImagenes {

    @Context
    private UriInfo context;

    public DescargadorImagenes() {}

    @GET
    @Produces("text/html")
    public String getHtml(@QueryParam("url") String url, @QueryParam("destino") String destino, @QueryParam("ref") String ref) {
        try{
            URL imageUrl = new URL(url);
            URLConnection conn = imageUrl.openConnection();
            if(conn.getContentType().contains("image")){
                InputStream reader = conn.getInputStream();
                if(System.getProperty("os.name").contains("Windows"))
                    destino += "\\";
                String nombre = "";
                for(int i=imageUrl.getPath().length() - 1; imageUrl.getPath().charAt(i)!='/';i--)
                    nombre = imageUrl.getPath().charAt(i) + nombre;
                destino += nombre;
                FileOutputStream writer = new FileOutputStream(new File(destino));
                byte[] array = new byte[1000];
                int leido;
                do{
                    leido = reader.read(array);
                    if(leido > 0)
                        writer.write(array,0,leido);
                }while (leido > 0);
                reader.close();
                writer.close();
            }
        }catch(MalformedURLException e){
            return e.toString();
        }catch(IOException e){
            return e.toString();
        }
                return "<script>alert('Descarga realizada con exito');location.href='"+ref+"';</script>";
    }

    @PUT
    @Consumes("text/html")
    public void putHtml(String content){}
}
