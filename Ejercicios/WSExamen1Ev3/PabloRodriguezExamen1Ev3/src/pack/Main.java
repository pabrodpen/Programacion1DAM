package pack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Empleado empleado;
		ConjEmpleados conjEmpleados=new ConjEmpleados();
		String nombre="",fechaString="",departamento="";
		double salario;
		double sumaSalario=0,mediaSalario;
		
		try {
			BufferedReader in=new BufferedReader(new FileReader("src/pack/inicialNombreAlumnoent.txt"));
			//trim
			String linea;
			int contLineas=0;
			while((linea=in.readLine())!=null) {
				String[]aux=linea.split(":");
				aux[1]=aux[1].trim();//espacios por delante
				if(contLineas==0) {
					nombre=aux[1];
					contLineas++;
				}else if(contLineas==1) {
					fechaString=aux[1];
					contLineas++;
				}else if(contLineas==2){
					departamento=aux[1];
					contLineas++;
				}else {
					salario=Double.parseDouble(aux[1]);
					sumaSalario+=salario;
					empleado=new Empleado(nombre, fechaString,departamento, salario);
					conjEmpleados.addEmpleado(empleado);
					contLineas=0;
					//nos saltamos el ---
					in.readLine();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("EMPLEADO CON MAYOR SALARIO");
		double max=0;
		for(int i=0;i<conjEmpleados.cjtoEmpleados.length;i++) {
			if(conjEmpleados.cjtoEmpleados[i].getSalario()>max) {
				max=conjEmpleados.cjtoEmpleados[i].getSalario();
			}
		}
		//buscamos empleado con salario max
		for(int i=0;i<conjEmpleados.cjtoEmpleados.length;i++) {
			if(conjEmpleados.cjtoEmpleados[i].getSalario()==max) {
				System.out.println("Empleado con mas money:"+conjEmpleados.cjtoEmpleados[i]);
			}
		}
		System.out.println();
		System.out.println("EMPLEADO MAS JOVEN");
		int minEdad=1000;
		for(int i=0;i<conjEmpleados.cjtoEmpleados.length;i++) {
			if(conjEmpleados.cjtoEmpleados[i].edad()<minEdad) {
				minEdad=conjEmpleados.cjtoEmpleados[i].edad();
			}
		}
		//buscamos empleado mas joven
		for(int i=0;i<conjEmpleados.cjtoEmpleados.length;i++) {
			if(conjEmpleados.cjtoEmpleados[i].edad()==minEdad) {
				System.out.println("Empleado mas joven:"+conjEmpleados.cjtoEmpleados[i]);
			}
		}
		
		mediaSalario=(double)sumaSalario/conjEmpleados.cjtoEmpleados.length;
		System.out.println("SALARIO PROMEDIO:"+mediaSalario);
		System.out.println();
		
		System.out.println("EMPLEADOS ORDENADOS POR NOMBRE");
		Arrays.sort(conjEmpleados.cjtoEmpleados);
		System.out.println(Arrays.toString(conjEmpleados.cjtoEmpleados));
		
		System.out.println();
		System.out.println("EMPLEADOS ORDENADOS POR EDAD");
		Arrays.sort(conjEmpleados.cjtoEmpleados, new ComparaEdad());
		System.out.println(Arrays.toString(conjEmpleados.cjtoEmpleados));
	
	
		//FICHERO DE SALIDA
		
		try {
			BufferedWriter out=new BufferedWriter(new FileWriter("src/pack/inicialNombreAlumnosal.txt"));
			
			for(int i=0;i<conjEmpleados.cjtoEmpleados.length;i++) {
				 nombre=conjEmpleados.cjtoEmpleados[i].getNombre();
				 int edad=conjEmpleados.cjtoEmpleados[i].edad();
				
				out.write(String.valueOf(nombre+" "+edad));
				out.newLine();
			}
			out.close();
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
