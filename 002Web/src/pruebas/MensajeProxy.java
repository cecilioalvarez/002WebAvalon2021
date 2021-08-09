package pruebas;

public class MensajeProxy implements Mensaje {

	Mensaje mensaje;

	public MensajeProxy(Mensaje mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public void enviar(String texto) {
		System.out.println("aNTED DE ENVIAR MENSAJE...LO GRABO" + texto);
		mensaje.enviar(texto);
		System.out.println("despues de enviar mensaje...lo grabo" + texto);

	}

}
