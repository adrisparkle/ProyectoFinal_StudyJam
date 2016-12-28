package com.sparklesfactory.appnavidad;

import java.io.Serializable;


public class Lista implements Serializable{
    private String Nombre;
    private String Materiales;
    private String Procedimiento;
    private int Imagen;

    public Lista() {
    }

    public Lista(String nombre)
    {
        Nombre = nombre;
    }
    public Lista(String nombre, String cosas) {
        Nombre = nombre;
        Materiales = cosas;
    }
    public Lista(String nombre, int imagen) {
        Nombre = nombre;
        Imagen = imagen;
    }
    public Lista(String nombre, String cosas, String proce) {
        Nombre = nombre;
        Materiales = cosas;
        Procedimiento = proce;
    }

    public Lista(String nombre, String cosas, String proce, int imagen) {
        Nombre = nombre;
        Materiales = cosas;
        Procedimiento = proce;
        Imagen = imagen;
    }



    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getMateriales() {
        return Materiales;
    }

    public void setMateriales(String materiales) {
        Materiales = materiales;
    }

    public String getProcedimiento() {
        return Procedimiento;
    }

    public void setProcedimiento(String procedimiento) {
        Procedimiento = procedimiento;
    }

    public int getImagen() {
        return Imagen;
    }

    public void setImagen(int imagen) {
        Imagen = imagen;
    }
}
