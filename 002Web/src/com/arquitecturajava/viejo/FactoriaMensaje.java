package com.arquitecturajava.viejo;

public class FactoriaMensaje {

	public static Mensaje getMensaje() {
		
		return new MensajeStandard();
	}
}
