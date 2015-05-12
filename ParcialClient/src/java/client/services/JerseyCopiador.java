/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client.services;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

/**
 * Jersey REST client generated for REST resource:CopiadorArchivos
 * [copiador]<br>
 * USAGE:
 * <pre>
 *        JerseyCopiador client = new JerseyCopiador();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Anibal
 */
public class JerseyCopiador {
    private WebResource webResource;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/ParcialServer/webresources";

    public JerseyCopiador() {
        com.sun.jersey.api.client.config.ClientConfig config = new com.sun.jersey.api.client.config.DefaultClientConfig();
        client = Client.create(config);
        webResource = client.resource(BASE_URI).path("copiador");
    }

    public String getHtml(String destino, String origen) throws UniformInterfaceException {
        WebResource resource = webResource;
        if (destino != null) {
            resource = resource.queryParam("destino", destino);
        }
        if (origen != null) {
            resource = resource.queryParam("origen", origen);
        }
        return resource.accept(javax.ws.rs.core.MediaType.TEXT_HTML).get(String.class);
    }

    public void putHtml(Object requestEntity) throws UniformInterfaceException {
        webResource.type(javax.ws.rs.core.MediaType.TEXT_HTML).put(requestEntity);
    }

    public void close() {
        client.destroy();
    }
    
}
