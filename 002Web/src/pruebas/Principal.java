package pruebas;

public class Principal {
	public static void main(String[] args) {
		Mensaje m = FactoriaMensaje.getMensaje();
		m.enviar("hola");
		m.enviar("hola2");
		m.enviar("hola3");
		m.enviar("hola4");
	}

}
