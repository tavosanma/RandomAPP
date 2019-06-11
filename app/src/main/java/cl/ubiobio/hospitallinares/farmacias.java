package cl.ubiobio.hospitallinares;

//clase que trabajando en en conjunto con otras, muestran las farmacias de turno de los Angeles
public class farmacias {
    //Iniciación de variables
    private String id;
    private String nombrefarmacia;
    private String ciudadfarmacia;
    private String direccionfarmacia;
    private String horariofarmacia;

    //Constructor
    public  farmacias(String id, String nombrefarmacia, String ciudadfarmacia, String direccionfarmacia, String horariofarmacia){
        this.id=id;
        this.nombrefarmacia=nombrefarmacia;
        this.ciudadfarmacia=ciudadfarmacia;
        this.direccionfarmacia=direccionfarmacia;
        this.horariofarmacia=horariofarmacia;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNombrefarmacia() {
        return nombrefarmacia;
    }
    public void setNombrefarmacia(String nombrefarmacia) {
        this.nombrefarmacia = nombrefarmacia;
    }
    public String getCiudadfarmacia() {
        return ciudadfarmacia;
    }
    public void setCiudadfarmacia(String ciudadfarmacia) {
        this.ciudadfarmacia = ciudadfarmacia;
    }
    public String getDireccionfarmacia() {
        return direccionfarmacia;
    }
    public void setDireccionfarmacia(String direccionfarmacia) { this.direccionfarmacia = direccionfarmacia; }
    public String getHorariofarmacia() {
        return horariofarmacia;
    }
    public void setHorariofarmacia(String horariofarmacia) { this.horariofarmacia = horariofarmacia;
    }
}
