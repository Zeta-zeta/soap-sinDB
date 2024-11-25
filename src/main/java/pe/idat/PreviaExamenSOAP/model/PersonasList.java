package pe.idat.PreviaExamenSOAP.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name="personas")
public class PersonasList {

    private List<Persona> personas;

    public PersonasList() {
    }

    public PersonasList(List<Persona> personas) {
        this.personas = personas;
    }

    @XmlElement(name ="persona")
    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }
}
