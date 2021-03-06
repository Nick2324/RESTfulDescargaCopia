package client.services;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

/**
 * Jersey REST client generated for REST resource:ObtenerURI [obtenerURI]<br>
 * USAGE:
 * <pre>
 *        JerseyObtenerURI client = new JerseyObtenerURI();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Anibal
 */
public class JerseyObtenerURI {
    private WebResource webResource;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/ParcialServer/webresources";

    public JerseyObtenerURI() {
        com.sun.jersey.api.client.config.ClientConfig config = new com.sun.jersey.api.client.config.DefaultClientConfig();
        client = Client.create(config);
        webResource = client.resource(BASE_URI).path("obtenerURI");
    }

    public String getText() throws UniformInterfaceException {
        WebResource resource = webResource;
        return resource.accept(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
    }

    public void putText(Object requestEntity) throws UniformInterfaceException {
        webResource.type(javax.ws.rs.core.MediaType.TEXT_PLAIN).put(requestEntity);
    }

    public void close() {
        client.destroy();
    }
    
}
