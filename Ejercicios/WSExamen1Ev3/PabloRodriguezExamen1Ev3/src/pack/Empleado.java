package pack;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Empleado implements Comparable{

	String nombre;
	LocalDate fecha;
	String departamento;
	double salario;
	DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
	public Empleado(String nombre, String fecha,String departamento, double salario) {
		super();
		this.nombre = nombre;
		this.fecha = LocalDate.parse(fecha,formatter);
		this.departamento=departamento;
		this.salario = salario;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public int edad() {
		return (int) fecha.until(LocalDate.now(),ChronoUnit.YEARS);
	}

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", fecha=" + fecha + ", departamento=" + departamento + ", salario="
				+ salario + "]\n";
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Empleado empleado=(Empleado) o;
		return nombre.compareTo(empleado.getNombre());
	}
	
	
}
