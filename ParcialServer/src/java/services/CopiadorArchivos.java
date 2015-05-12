/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 * REST Web Service
 *
 * @author Anibal
 */
@Path("copiador")
public class CopiadorArchivos {

    @Context
    private UriInfo context;

    public CopiadorArchivos() {}

    @GET
    @Produces("text/html")
    public String getHtml(@QueryParam("origen") String origen, @QueryParam("destino") String destino, @QueryParam("ref") String ref) {
        try{
            File archivoOrigen = new File(origen);
            if(archivoOrigen.exists()){
                FileInputStream reader = new FileInputStream(archivoOrigen);
                String urlDestino = "";
                if(System.getProperty("os.name").contains("Windows"))
                    urlDestino = destino+"\\"+archivoOrigen.getName();
                FileOutputStream writer = new FileOutputStream(new File(urlDestino));
                int indice;
                byte[] array = new byte[1000];
                do{
                    indice = reader.read(array);
                    if(indice > 0)
                        writer.write(array, 0, indice);
                }while(indice > 0);
                reader.close();
                writer.close();
            }
        }catch(IOException e){
            return e.toString();
        }
        return "<script>alert('Copiado realizado con exito');location.href='"+ref+"';</script>";
    }

    /**
     * PUT method for updating or creating an instance of CopiadorArchivos
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void putHtml(String content) {
    }
}
