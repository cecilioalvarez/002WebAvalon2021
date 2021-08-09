package com.arquitecturajavaJSP.pruebas;

public class FactoriaGestorMensaje {
	public static GestorMensaje getMensaje() {
		//Opcion con Constructor
		//return new GestorMensajeProxy(new GestorMensajeStandard());
		
		//Opcion con Setters y Getters
		GestorMensajeProxy proxy = new GestorMensajeProxy();
		proxy.setGestorMensaje(new GestorMensajeStandard());
		return proxy;
		
	}
}
