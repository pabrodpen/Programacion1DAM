package clase3;

import java.io.Serializable;

public class Estudiante implements Serializable,Comparable<Estudiante> {
    String nombre;
    int edad;
    double media;

    public Estudiante(String nombre, int edad, double media) {
        this.nombre = nombre;
        this.edad = edad;
        this.media = media;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", media=" + media +
                '}';
    }

    @Override
    public int compareTo(Estudiante o) {
        return nombre.compareTo(o.nombre);
    }
}
