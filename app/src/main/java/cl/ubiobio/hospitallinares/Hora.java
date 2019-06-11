package cl.ubiobio.hospitallinares;

//utilizacion de getters and setters para la clase Hora, que muestra la hora de visita de un paciente
public class Hora {
    //Incio de variables
    private String paciente;
    private String fecha;
    private String doc;
    private String area;
    private String ubicacion;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //Iniciamos constructor
    public Hora(String paciente, String fecha, String doc, String area, String ubicacion, String id) {
        this.paciente = paciente;
        this.fecha = fecha;
        this.doc = doc;
        this.area = area;
        this.ubicacion = ubicacion;
        this.id = id;
    }
    public Hora() {
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
