package com.arquitecturajavaJSP.pruebas;

public class GestorMensajeProxy implements GestorMensaje{
	
	GestorMensaje gestorMensaje;
	
	public GestorMensajeProxy() {}
	public GestorMensajeProxy(GestorMensaje mensaje) {
		this.gestorMensaje = mensaje;
	}
	
	public GestorMensaje getGestorMensaje() {
		return gestorMensaje;
	}
	
	public void setGestorMensaje(GestorMensaje gestorMensaje) {
		this.gestorMensaje = gestorMensaje;
	}



	@Override
	public void enviar(String texto) {
		System.out.println("Antes de Enviar Mensaje.. lo grabo "+texto);
		gestorMensaje.enviar(texto);
		System.out.println("Después de Enviar Mensaje.. lo grabo "+texto);
	}

}
