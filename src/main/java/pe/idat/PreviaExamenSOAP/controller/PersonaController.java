package pe.idat.PreviaExamenSOAP.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jvnet.hk2.annotations.Service;
import pe.idat.PreviaExamenSOAP.model.Persona;
import pe.idat.PreviaExamenSOAP.model.PersonasList;

import java.util.ArrayList;
import java.util.List;

@Service
@Path("/persona")
public class PersonaController {

    private static List<Persona> personas = new ArrayList<>();

    static {
        personas.add(new Persona(75368889L,"Cristian","Medina",26,"Masculino","Soltero"));
        personas.add(new Persona(66666666L,"Patrick","Rivera",25,"Femenino","Divorciado"));
        personas.add(new Persona(22222222L,null,"Rivera",25,null,"Divorciado"));
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response listarPersonas() {

        return Response
                .status(Response.Status.OK)
                .entity(new PersonasList(personas)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response insertarPersona(Persona persona){
        personas.add(persona);
        return Response.status(Response.Status.CREATED)
                .entity(persona).build();
    }

    @PUT
    @Path("/{dni}")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response modificarPersona(@PathParam("dni") Long dni, Persona persona) {
        for (Persona p : personas){
            if (p.getDni().equals(dni)){
                p.setNombre(persona.getNombre());
                p.setApellidos(persona.getApellidos());
                p.setEdad(persona.getEdad());
                p.setSexo(persona.getSexo());
                p.setEstado(persona.getEstado());
                System.out.println(p);
                return  Response.status(Response.Status.OK)
                        .entity(p).build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND)
                .entity("Persona no encontrada").build();
    }

    @DELETE
    @Path("/{dni}")
    @Produces(MediaType.APPLICATION_XML)
    public Response borrarPersona(@PathParam("dni") Long dni){
        for (Persona persona: personas){
            if (persona.getDni().equals(dni)){
                personas.remove(persona);
                return Response.ok("Persona ha sido borrada").build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Persona no ha sido encontrado").build();
    }

    @GET
    @Path("/{dni}")
    @Produces(MediaType.APPLICATION_XML)
    public Response consultarPersona(@PathParam("dni") Long dni){
        for (Persona p: personas){
            if(p.getDni().equals(dni)){
                return Response.status(Response.Status.OK).entity(p).build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Persona no encontrada").build();
    }
}
