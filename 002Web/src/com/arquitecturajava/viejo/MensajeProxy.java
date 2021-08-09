package com.arquitecturajava.viejo;

public class MensajeProxy  implements Mensaje{

	Mensaje mensaje;
	
	public MensajeProxy(Mensaje mensaje) {
		
		this.mensaje=mensaje;
	}
	
	@Override
	public void enviar(String texto) {
		
		System.out.println("antes de enviar el mensaje .... lo grabo"+ texto);
		mensaje.enviar(texto);
		System.out.println("despues de enviar el mensaje ... lo grabo" +texto);
		
	}

}
