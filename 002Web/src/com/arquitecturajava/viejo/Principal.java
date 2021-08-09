package com.arquitecturajava.viejo;

public class Principal {

	public static void main(String[] args) {
		
		GestorMensaje m= FactoriaGestorMensaje.getMensaje();
		m.enviar("hola");
		m.enviar("hola2");
		m.enviar("hola3");
		m.enviar("hola4");
		m.enviar("hola5");
	}
}
