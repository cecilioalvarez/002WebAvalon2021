package com.arquitecturajava.viejo;

public class GestorMensajeStandard implements GestorMensaje{

	@Override
	public void enviar(String texto) {
		System.out.println("el mensaje: " + texto);
	}

}
