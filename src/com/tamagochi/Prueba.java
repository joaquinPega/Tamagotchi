/**@author joaquin.pega
 * Main del ejercicio 
 */
package com.tamagochi;

import java.util.Scanner;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Mascota m;
		int c=Integer.MAX_VALUE;
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese nombre de su mascota");
		m = new Mascota(sc.nextLine());
		while(m.isVivo()){
			System.out.println("Ingrese 1 para comer 2 para beber 3 para dormir 4 para despertar 5 para caminar 6 para correr 7 para saltar");
			try{
				c = Integer.parseInt(sc.nextLine());
			}catch(Exception e){
				c = Integer.MAX_VALUE;
			}
			switch(c){
			case 1:
				System.out.println(m.comer());
				System.out.println("Mi humor cambio a: "+m.getMood());
				break;
			case 2:
				System.out.println(m.beber());
				System.out.println("Mi humor cambio a: "+m.getMood());
				break;
			case 3:
				System.out.println(m.dormir());
				System.out.println("Mi humor cambio a: "+m.getMood());
				break;
			case 4:
				System.out.println(m.despertar());
				System.out.println("Mi humor cambio a: "+m.getMood());
				break;
			case 5:
				System.out.println(m.caminar());
				System.out.println("Mi humor cambio a: "+m.getMood());
				break;
			case 6:
				System.out.println(m.correr());
				System.out.println("Mi humor cambio a: "+m.getMood());
				break;
			case 7:
				System.out.println(m.saltar());
				System.out.println("Mi humor cambio a: "+m.getMood());
				break;
			default:
				System.out.println("Opcion incorrecta");
				break;
			}
			
		}
		sc.close();
	}

}
