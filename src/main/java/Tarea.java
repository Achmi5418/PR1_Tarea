package org.example;

public class Tarea {
    String nombre;
    boolean completada;

    public Tarea(String descripcion) {
        this.nombre = descripcion;
        this.completada = false;
    }

    public void marcarCompletada() {
        this.completada = true;
    }

    @Override
    public String toString() {
        String estado = completada ? "[X]" : "[ ]";
        return estado + " " + nombre;
    }
}

