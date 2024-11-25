package pe.idat.PreviaExamenSOAP.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import pe.idat.PreviaExamenSOAP.controller.PersonaController;

@Configuration
public class ServerConfig extends ResourceConfig {
    public ServerConfig() {
        register(PersonaController.class);
    }
}
