package com.arquitecturajavaJSP.pruebas;

public class Main {

	public static void main(String[] args) {
		GestorMensaje m = FactoriaGestorMensaje.getMensaje();
		m.enviar("Hola");

	}

}
