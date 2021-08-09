package com.arquitecturajava.viejo;

public class GestorMensajeProxy  implements GestorMensaje{

	GestorMensaje gestorMensaje;
	
	
	public GestorMensaje getGestorMensaje() {
		return gestorMensaje;
	}

	public void setGestorMensaje(GestorMensaje gestorMensaje) {
		this.gestorMensaje = gestorMensaje;
	}

	@Override
	public void enviar(String texto) {
		
		System.out.println("antes de enviar el mensaje .... lo grabo"+ texto);
		// usa el objeto original para operar con el 
		gestorMensaje.enviar(texto);
		System.out.println("despues de enviar el mensaje ... lo grabo" +texto);
		
	}

}
