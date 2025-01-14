package pack;

import java.util.Arrays;
import java.util.Scanner;

public class Ej5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		int[][]matriz=generaArrayBiInt(10, 20);
		
		for(int i=0;i<matriz.length;i++) {
			for(int j=0;j<matriz[i].length;j++) {
				System.out.print(matriz[i][j]+"|");
			}
			System.out.println();
		}
		
		int[]fila=filaDeArrayBiInt(matriz, 0);
		System.out.println();
		System.out.println(Arrays.toString(fila));
		System.out.println();
		int[]columna=columnaDeArrayBiInt(matriz, 0);
		System.out.println(Arrays.toString(columna));
		
		System.out.print("Dime un numero:");
		int n=sc.nextInt();
		
		int[]coord=coordenadasEnArrayBiInt(matriz, n);
		
		System.out.println();
		System.out.println(Arrays.toString(coord));
		System.out.println();
		System.out.println();
		
		minimoPorColumnas(matriz);
		
	}
	
	static int[][]generaArrayBiInt(int inf,int sup) {
		int nFil=3,nCol=3;
		int[][]mat=new int[nFil][nCol];
		for(int i=0;i<nFil;i++) {
			for(int j=0;j<nCol;j++) {
				mat[i][j]=(int)(Math.random()*(sup-inf+1)+inf);
			}
		}
		
		return mat;
	}
	
	static int[]filaDeArrayBiInt(int[][]matriz,int fila){
		int[]arr=new int[matriz[fila].length];
		int cont=0;
		for(int i=0;i<matriz.length;i++) {
			for(int j=0;j<matriz[i].length;j++) {
				if(cont<arr.length) {
					if(i==fila) {
						arr[cont]=matriz[i][j];
						cont++;
					}
				}
				
			}
		}
		return arr;
		
	}
	
	

	static int[]columnaDeArrayBiInt(int[][]matriz,int col){
		int[]arr=new int[matriz.length];
		int cont=0;
		for(int i=0;i<matriz.length;i++) {
			for(int j=0;j<matriz[i].length;j++) {
				if(cont<arr.length) {
					if(j==col) {
						arr[cont]=matriz[i][j];
						cont++;
					}
				}
				
			}
		}
		return arr;
		
	}
	
	static int[]coordenadasEnArrayBiInt(int[][]matriz,int numBusq){
		int[]res=new int[2];
		boolean encontrado=false;
		for(int i=0;i<matriz.length && !encontrado;i++) {
			for(int j=0;j<matriz[i].length && !encontrado;j++) {
				if(matriz[i][j]==numBusq) {
					res[0]=i;
					res[1]=j;
					encontrado=true;
				}
			}
		}
		
		if(!encontrado) {
			res[0]=-1;
			res[1]=-1;
		}
		
		return res;
	}
	
	static void minimoPorColumnas(int[][]matriz) {
		int max=-100000,min=1000000;
		int contFil=0;
		for(int col=0;col<matriz.length;col++) {
			
			while(contFil<matriz.length) {
				if(max<matriz[contFil][col]) {
					max=matriz[contFil][col];
				}
				if(min>matriz[contFil][col]) {
					min=matriz[contFil][col];
				}
				contFil++;
			}
			System.out.println("Maximo de la columna "+col+" es "+max);
			System.out.println("Minimo de la columna "+col+" es "+min);
			max=-100000;
			min=1000000;
			contFil=0;
		}
	}

}
