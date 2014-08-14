package com.tamagochi;

public class MascotaCura extends Mascota{

	public MascotaCura(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public String casar(Mascota m1,Mascota m2){
		m1.casarse(m2);
		m2.casarse(m1);
		return m1.getName()+" se caso con: "+ m2.getName();
	}

}
