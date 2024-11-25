package pe.idat.PreviaExamenSOAP.model;


import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="persona")
public class Persona {
    private Long dni;
    private String nombre;
    private String apellidos;
    private int edad;
    private String sexo;
    private String estado;

    public Persona() {
    }

    public Persona(Long dni, String nombre, String apellidos, int edad, String sexo, String estado) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.sexo = sexo;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "DNI=" + dni +
                ", Nombre='" + nombre + '\'' +
                ", Apellidos='" + apellidos + '\'' +
                ", Edad=" + edad +
                ", Sexo='" + sexo + '\'' +
                ", Estado Civil='" + estado + '\'' +
                '}';
    }


    @XmlElement
    public Long getDni() { return dni;}
    public void setDni(Long dni) {this.dni = dni;}

    @XmlElement
    public String getNombre() { return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    @XmlElement
    public String getApellidos() { return apellidos;}
    public void setApellidos(String apellidos) {this.apellidos = apellidos;}

    @XmlElement
    public int getEdad() { return edad;}
    public void setEdad(int edad) {this.edad= edad;}

    @XmlElement
    public String getSexo() { return sexo;}
    public void setSexo(String sexo) {this.sexo = sexo;}

    @XmlElement
    public String getEstado() { return estado;}
    public void setEstado(String estado) {this.estado = estado;}

}
