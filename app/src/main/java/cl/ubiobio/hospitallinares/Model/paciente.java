package cl.ubiobio.hospitallinares.Model;

import java.util.Date;

public class paciente {

    private String uid;
    private String nombre;
    private int folio;
    private String rut;
    private String nacimiento;

    public paciente() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFolio() {
        return folio;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
