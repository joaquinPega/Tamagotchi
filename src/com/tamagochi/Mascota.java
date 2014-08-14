package com.tamagochi;

import java.util.ArrayList;
import java.util.Random;

public class Mascota {
	private String name;
	private double energy;
	private int mood;
	private boolean durmiendo;
	private Random r = new Random();
	private int contDesgaste;
	private int contIndigestion;
	private boolean vivo, casado;
	private Mascota pareja=null;
	private ArrayList<Mascota> hijos = new ArrayList<Mascota>();
	public final static byte MAX_ENERGY=100;

	public Mascota(String name) {
		this.name = name;
		this.energy = 100;
		this.durmiendo = false;
		mood = 5;
		contDesgaste = 0;
		contIndigestion = 0;
		vivo = true;
	}

	public Mascota getPareja() {
		return pareja;
	}

	public String getName() {
		return name;
	}

	public double getEnergy() {
		return energy;
	}

	public int getMood() {
		return mood;
	}

	public boolean isVivo() {
		return vivo;
	}
	
	public ArrayList<Mascota> getHijos() {
		return hijos;
	}

	public String comer() {
		int add = r.nextInt(MAX_ENERGY);
		String s;
		if (contIndigestion < 4) {
			if (!durmiendo) {
				contDesgaste = 0;
				contIndigestion++;
				if (energy + add <= MAX_ENERGY) {
					energy += add;
				} else {
					energy = MAX_ENERGY;
				}

				moodChange();
				s = "Comio: " + add + " y ahora tiene: " + energy + " energia.";
			} else {
				s = "Esta durmiendo, no pudo comer";
			}
		} else {
			s = morir();
		}
		return s;
	}

	public String beber() {
		int add = r.nextInt(MAX_ENERGY);
		String s;
		if (contIndigestion < 4) {
			if (!durmiendo) {
				contDesgaste = 0;
				contIndigestion++;
				if (energy + add <= MAX_ENERGY) {
					energy += add;
				} else {
					energy = MAX_ENERGY;
				}

				moodChange();
				s = "Bebio: " + add + " y ahora tiene: " + energy + " energia";
			} else {
				s = "Esta durmiendo, no pudo beber";
			}
		} else {
			s = morir();
		}
		return s;
	}

	public String dormir() {
		String s;
		if (!durmiendo) {
			contDesgaste = 0;
			contIndigestion = 0;
			durmiendo = true;
			if ((energy + (energy * 0.25)) <= MAX_ENERGY) {
				energy += energy * 0.25;
			} else {
				energy = MAX_ENERGY;
			}

			moodChange();
			s = "Durmio y ahora tiene " + energy + " energia";
		} else {
			s = "Esta durmiendo, no pudo dormir (redundancia)";
		}
		return s;

	}

	public String despertar() {
		String s;
		if (durmiendo) {
			contDesgaste = 0;
			contIndigestion = 0;
			moodChange();
			durmiendo = false;
			s = "Se desperto";
		} else {
			s = "Ya estaba despierto, no pudo despertarse (redundancia";
		}
		return s;
	}

	public String caminar() {
		String s;
		if (contDesgaste < 2) {
			int c = r.nextInt(MAX_ENERGY);
			if (!durmiendo) {
				contIndigestion = 0;
				contDesgaste++;
				if (energy - c <= 0) {
					s = morir();
				} else {
					energy -= c;
					moodChange();
					s = "Camino: " + c + " metros ahora tiene: " + energy;
				}
			} else {
				s = "Esta durmiendo, no pudo caminar";

			}
		} else {
			s = dormir();
		}
		return s;
	}

	public String correr() {
		String s;
		int c = r.nextInt(MAX_ENERGY);
		if (contDesgaste < 2) {
			if (!durmiendo) {
				contDesgaste++;
				contIndigestion = 0;
				if (energy - c <= 0) {
					s = morir();
				} else {
					energy -= c;
					moodChange();
					s = "Corrio: " + c + " metros ahora tiene: " + energy;
				}
			} else {
				s = "Esta durmiendo, no pudo correr";

			}
		} else {
			s = dormir();
		}
		return s;
	}

	public String saltar() {
		String s;
		int c = r.nextInt(MAX_ENERGY);
		if (contDesgaste < 2) {
			if (!durmiendo) {
				contDesgaste++;
				contIndigestion = 0;
				if (energy - c <= 0) {
					s = morir();
				} else {
					energy -= c;
					moodChange();
					s = "Salto: " + c + " veces ahora tiene: " + energy;
				}
			} else {
				s = "Esta durmiendo, no pudo saltar";

			}
		} else {
			s = dormir();
		}
		return s;
	}

	private void moodChange() {
		mood = (int)(energy/((double)MAX_ENERGY/5));
	}

	private String morir() {
		vivo = false;
		mood = 0;
		return "Murio";
	}

	// ejercicio 2:
	public String recibirAtaque(Mascota m, int daño) {
		String s;
		if (energy - daño <= 0) {
			s = morir();
			s= " me mato :( "+m.getName();
		} else {
			energy -= daño;
			s = m.getName() + " me ataco por " + daño;
		}
		return s;
	}

	public String atacar(Mascota m) {
		String s;
		int daño;
		daño = r.nextInt(20);		
		s = this.name + " ataco a " + m.getName()+ "\n"+m.recibirAtaque(this, daño);
		return s;
	}

	public void casarse(Mascota m) {
		casado = true;
		pareja = m;
	}
	public String divorciarse(){
		if(casado){
			casado = false;
			pareja = null;
			this.pareja.divorciarse();
			return "Se divorcio de: "+this.pareja;		
		}else{
			return "no estaba casado";
		}
	}
	private boolean puedeProcrear(){
		return casado&& this.energy>MAX_ENERGY*0.8 && this.mood==5;
	}
	public Mascota procrear(){
		Mascota hijo=null;
		if(puedeProcrear()){
			if(pareja.puedeProcrear()){
				hijo=new Mascota("HD"+this.getName()+pareja.getName()+hijos.size());
				hijos.add(hijo);								
			}else{
				
			}
		}else{
			
		}
		return hijo;
	}
	
	public boolean isCasado() {
		return casado;
	}
	
}
