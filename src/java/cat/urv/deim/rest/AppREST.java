
package cat.urv.deim.rest;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author dyno
 */
@javax.ws.rs.ApplicationPath("rest/api") //ruta base donde estara mi api rest
public class AppREST extends Application{
    
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        // following code can be used to customize Jersey 2.0 JSON provider:
        try {
            Class jsonProvider = Class.forName("org.glassfish.jersey.jackson.JacksonFeature");
            // Class jsonProvider = Class.forName("org.glassfish.jersey.moxy.json.MoxyJsonFeature");
            // Class jsonProvider = Class.forName("org.glassfish.jersey.jettison.JettisonFeature");
            resources.add(jsonProvider);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        addRestResourceClasses(resources);
        return resources;
    }
        private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(cat.urv.deim.rest.ApiService.class);
        //resources.add(API.APIcontacts.class);
    }
}
