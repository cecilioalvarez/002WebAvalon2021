package com.arquitecturajava.viejo;

public class FactoriaGestorMensaje {
	public static GestorMensaje getMensaje() {
		
		GestorMensajeProxy proxy = new GestorMensajeProxy();
		proxy.setGestorMensaje(new GestorMensajeStandard());
		return proxy;
	}
}
