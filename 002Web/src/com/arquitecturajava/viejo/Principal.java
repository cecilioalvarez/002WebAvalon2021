package com.arquitecturajava.viejo;

public class Principal {
	public static void main(String[] args) {
		GestorMensaje m = FactoriaGestorMensaje.getMensaje();
		m.enviar("Hola pichon");
		m.enviar("Hola tigre");
		m.enviar("Hola crack");
		m.enviar("Hola mastodonte");
	}
}
