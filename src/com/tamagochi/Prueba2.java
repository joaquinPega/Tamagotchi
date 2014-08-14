package com.tamagochi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Prueba2 {
	public static void main(String[] args) {
		Map<String, Mascota> mascotas = new HashMap<String, Mascota>();
		Mascota current, atacada = null;
		ArrayList<Mascota> hijos = new ArrayList<Mascota>();
		MascotaCura cura = new MascotaCura("cura");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		boolean running = true;
		int c;
		String s;
		while (running) {
			System.out
					.println("Menu creacion: 1 para crear mascota 2 borrar mascota 3 menu mascotas 4 casar dos mascotas 5 mostrar mascotas 6 salir");
			try {
				c = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				c = Integer.MAX_VALUE;
			}
			switch (c) {
			case 1:
				System.out.println("Ingrese nombre de la mascota a crear:");
				s = sc.nextLine();
				mascotas.put(s, new Mascota(s));
				break;
			case 2:
				Mascota rmv;
				System.out.println("Ingrese el nombre de la mascota a borrar:");
				s = sc.nextLine();
				rmv = mascotas.remove(s);
				if (rmv != null) {
					System.out.println("Se borro la mascota");
				} else {
					System.out.println("No se encontro mascota a borrar");
				}

				break;
			case 3:
				System.out
						.println("Ingrese el nombre de la mascota a la cual acceder");
				s = sc.nextLine();
				current = mascotas.get(s);
				if (current != null) {
					boolean inMenu = true;
					while (current.isVivo() && inMenu) {
						System.out
								.println("Ingrese 1 para comer 2 para beber 3 para dormir 4 para despertar"
										+ "\n5 para caminar 6 para correr 7 para saltar 8 para atacar 9 divorciarse 10 procrear 11 mostrar los hijos 12 volver menu creacion");
						try {
							c = Integer.parseInt(sc.nextLine());
						} catch (Exception e) {
							c = Integer.MAX_VALUE;
						}
						switch (c) {
						case 1:
							System.out.println(current.comer());
							System.out.println("Mi humor cambio a: "
									+ current.getMood());
							break;
						case 2:
							System.out.println(current.beber());
							System.out.println("Mi humor cambio a: "
									+ current.getMood());
							break;
						case 3:
							System.out.println(current.dormir());
							System.out.println("Mi humor cambio a: "
									+ current.getMood());
							break;
						case 4:
							System.out.println(current.despertar());
							System.out.println("Mi humor cambio a: "
									+ current.getMood());
							break;
						case 5:
							System.out.println(current.caminar());
							System.out.println("Mi humor cambio a: "
									+ current.getMood());
							break;
						case 6:
							System.out.println(current.correr());
							System.out.println("Mi humor cambio a: "
									+ current.getMood());
							break;
						case 7:
							System.out.println(current.saltar());
							System.out.println("Mi humor cambio a: "
									+ current.getMood());
							break;
						case 8:
							System.out
									.println("Ingrese el nombre de la mascota a atacar");
							s = sc.nextLine();
							atacada = mascotas.get(s);
							if (atacada != null) {
								System.out.println(current.atacar(atacada));
							} else {
								System.out
										.println("No se encontro mascota a atacar");
							}
							break;
						case 9:
							System.out.println(current.divorciarse());
							break;
						case 10:
							Mascota tmp;
							tmp = current.procrear();
							if (tmp != null) {
								mascotas.put(tmp.getName(), tmp);
								System.out.println("Tuvo un pibe llamado "+tmp.getName());
							}else{
								System.out.println("No pudo procrear ");
							}
							break;
						case 11:
							hijos = current.getHijos();
							if (hijos.isEmpty()) {
								System.out.println("No tiene hijos");
							} else {
								for (Mascota m : hijos) {
									System.out.println("nombre: " + m.getName()
											+ " energia: " + m.getEnergy());
								}
							}
							break;
						case 12:
							inMenu = false;
							break;
						default:
							System.out.println("Opcion incorrecta");
							break;
						}
						if (!current.isVivo()) {
							mascotas.remove(current.getName());
						}
						if (atacada instanceof Mascota) {
							if (!atacada.isVivo()) {
								mascotas.remove(atacada.getName());
							}
						}
					}
				} else {
					System.out
							.println("No existe esa mascota llevado al menu creacion");
				}
				break;
			case 4:
				String casar1,
				casar2;
				Mascota m1,
				m2;
				System.out.println("Ingrese el nombre de la mascota a casar");
				casar1 = sc.nextLine();
				m1 = mascotas.get(casar1);
				if (m1 != null) {
					System.out.println("Ingrese el nombre de la pareja");
					casar2 = sc.nextLine();
					m2 = mascotas.get(casar2);
					if (m2 != null) {
						if (m1.equals(m2)) {
							System.out
									.println("No se puede casar consigo mismo");
						} else {
							System.out.println(cura.casar(m1, m2));
						}
					} else {
						System.out.println("No existe la pareja");
					}
				} else {
					System.out.println("No existe la mascota 1 para crear");
				}
				break;
			case 5:
				for (Mascota m : mascotas.values()) {
					System.out.println("Mascota: " + m.getName() + " energia: "
							+ m.getEnergy() + " humor: " + m.getMood());
				}
				break;
			case 6:
				running = false;
				break;
			default:
				System.out.println("Opcion incorrecta");
				break;
			}
		}
	}
}
