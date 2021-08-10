package viejo;

public class MensajeStandard implements Mensaje {

	@Override
	public void enviar(String texto) {
		System.out.println("el mensaje "+ texto);

	}

	

}
