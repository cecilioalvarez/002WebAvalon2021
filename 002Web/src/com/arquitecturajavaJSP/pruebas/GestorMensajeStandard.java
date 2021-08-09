package com.arquitecturajavaJSP.pruebas;

public class GestorMensajeStandard implements GestorMensaje {

	@Override
	public void enviar(String texto) {
		System.out.println("El mensaje: "+texto);
		
	}

}
