package com.arquitecturajava.viejo;

public class Principal {

	public static void main(String[] args) {
		
		Mensaje m= FactoriaMensaje.getMensaje();
		m.enviar("hola");
	}
}
