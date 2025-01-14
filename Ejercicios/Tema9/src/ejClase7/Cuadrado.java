package ejClase7;

import java.util.Arrays;

public class Cuadrado extends ClasePadre implements FiguraGeometrica,Comparable{
	
	Punto[]puntos=new Punto[4];
	
	

	public Cuadrado(String color, Punto[] puntos) {
		super(color);
		this.puntos = puntos;
	}



	@Override
	public double calcularArea() {
		// TODO Auto-generated method stub
		return Math.pow(puntos[0].y-puntos[1].y, 2);
	}



	@Override
	public String toString() {
		return "Cuadrado [puntos=" + Arrays.toString(puntos) + ", color=" + color + ", area=" + calcularArea()
				+ "]";
	}

	
	@Override
	public int comparaArea(FiguraGeometrica otra) {
		// TODO Auto-generated method stub
		return (int) (calcularArea()-otra.calcularArea());
	}

	


	
	

}
