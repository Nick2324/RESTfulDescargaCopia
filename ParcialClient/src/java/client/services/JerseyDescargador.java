/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client.services;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

/**
 * Jersey REST client generated for REST resource:DescargadorImagenes
 * [descargador]<br>
 * USAGE:
 * <pre>
 *        JerseyDescargador client = new JerseyDescargador();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Anibal
 */
public class JerseyDescargador {
    private WebResource webResource;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/ParcialServer/webresources";

    public JerseyDescargador() {
        com.sun.jersey.api.client.config.ClientConfig config = new com.sun.jersey.api.client.config.DefaultClientConfig();
        client = Client.create(config);
        webResource = client.resource(BASE_URI).path("descargador");
    }

    public String getHtml(String url) throws UniformInterfaceException {
        WebResource resource = webResource;
        if (url != null) {
            resource = resource.queryParam("url", url);
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
