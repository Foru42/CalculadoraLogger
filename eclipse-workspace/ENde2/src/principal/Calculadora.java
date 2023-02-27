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
					LOGGER.log(Level.FINE,"Operacion sumar" + " numero 1: " + operandos[0] + " numero 2: " + operandos[1]);
				} else if (operacion.equalsIgnoreCase("-")) {
					resultado = operaciones.restar(operandos[0], operandos[1]);
					System.out.println("Resultado: " + resultado);
					LOGGER.log(Level.FINE,"Operacion restar" + " numero 1: " + operandos[0] + " numero 2: " + operandos[1]);
				} else if (operacion.equalsIgnoreCase("*")) {
					resultado = operaciones.multiplicar(operandos[0], operandos[1]);
					LOGGER.log(Level.FINE,"Operacion multiplicar" + " numero 1: " + operandos[0] + " numero 2: " + operandos[1]);
				} else if (operacion.equalsIgnoreCase("/")) {
					resultado = operaciones.dividir(operandos[0], operandos[1]);
					System.out.println("Resultado: " + resultado);
					LOGGER.log(Level.FINE,"Operacion dividir" + " numero 1: " + operandos[0] + " numero 2: " + operandos[1]);
				} else if (operacion.equalsIgnoreCase("%")) {
					resultado = operaciones.resto(operandos[0], operandos[1]);
					System.out.println("Resultado: " + resultado);
					LOGGER.log(Level.FINE,"Operacion resto" + " numero 1: " + operandos[0] + " numero 2: " + operandos[1]);
				} else {
					System.out.println("Operaci�n no v�lida");
				}
				
			} catch (ArithmeticException e) {
				LOGGER.log(Level.WARNING, "Nivel de log cambiado a Warning");
				System.out.println("ERROR " + e.getMessage());

			}

		} while (menu.repetir());
		consoleHandler.close();
		fileHandler.close();
	}
}