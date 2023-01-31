package principal;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import menu.Menu;
import operaciones.Operaciones;

/**
 * Calculadora Main
 * 
 * @author Josu Foruria
 * @version 1.0
 */

public class Calculadora {
	private static final Logger LOGGER = Logger.getLogger(Calculadora.class.getName());

	public static void main(String[] args) {
		Handler consoleHandler = null;
		Handler fileHandler = null;
		try {

			consoleHandler = new ConsoleHandler();
			fileHandler = new FileHandler("./ficheroLog.log", true);
			LOGGER.addHandler(consoleHandler);
			LOGGER.addHandler(fileHandler);

			// Establecer niveles a handlers y LOGGER
			consoleHandler.setLevel(Level.ALL);
			fileHandler.setLevel(Level.ALL);
			LOGGER.setLevel(Level.ALL);

			// Eliminamos handler de la consola
			LOGGER.removeHandler(consoleHandler);

		} catch (IOException exception) {
			LOGGER.log(Level.WARNING, "Ocurrió un error en FileHandler.", exception);
		}

		int resultado = 0;
		String operacion = "";
		int[] operandos = new int[2];

		Menu menu = new Menu();
		Operaciones operaciones = new Operaciones();

		do {
			operandos = menu.pedirNumeros();
			operacion = menu.menuOpciones();
			try {
				if (operacion.equalsIgnoreCase("+")) {
					resultado = operaciones.sumar(operandos[0], operandos[1]);
					System.out.println("Resultado: " + resultado);
				} else if (operacion.equalsIgnoreCase("-")) {
					resultado = operaciones.restar(operandos[0], operandos[1]);
					System.out.println("Resultado: " + resultado);
				} else if (operacion.equalsIgnoreCase("*")) {
					resultado = operaciones.multiplicar(operandos[0], operandos[1]);
					System.out.println("Resultado: " + resultado);
				} else if (operacion.equalsIgnoreCase("/")) {
					resultado = operaciones.dividir(operandos[0], operandos[1]);
					System.out.println("Resultado: " + resultado);
				} else if (operacion.equalsIgnoreCase("%")) {
					resultado = operaciones.resto(operandos[0], operandos[1]);
					System.out.println("Resultado: " + resultado);
				} else {
					System.out.println("Operaci�n no v�lida");
				}
				LOGGER.log(Level.FINE, "Nivel de log cambiado a Fine");
			} catch (ArithmeticException e) {
				LOGGER.log(Level.WARNING, "Nivel de log cambiado a Warning");
				System.out.println("ERROR " + e.getMessage());

			}

		} while (menu.repetir());

	}
}