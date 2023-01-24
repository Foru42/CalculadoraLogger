package menu;

import java.util.Scanner;

/*
 * Menu de la calculadora
 * 
 * @author Josu Foruria
 * @version 1.0
 */
public class Menu {
	private static Scanner teclado = new Scanner(System.in);

	/**
	 * Menu pedirNumeros
	 * 
	 * @param ret Guarda en un array el Primer Valor
	 * @param ret Guarda en un array el Segundo Valor
	 * @return ret Devuelve los valores Pedir numero al usuario
	 */
	public int[] pedirNumeros() {
		int[] ret = new int[2];
		System.out.print("Operando 1: ");
		ret[0] = teclado.nextInt();
		System.out.print("Operando 2: ");
		ret[1] = teclado.nextInt();
		return ret;
	}

	/**
	 * Menu menuOpciones
	 * 
	 * @param ret Pedir las operaciones
	 * @return ret
	 */
	public String menuOpciones() {
		String ret = "";
		do {
			System.out.print("Operaciones [+, -, *, /, %]: ");
			ret = teclado.next();
		} while (!((ret.equalsIgnoreCase("+")) || (ret.equalsIgnoreCase("-")) || (ret.equalsIgnoreCase("*"))
				|| (ret.equalsIgnoreCase("/")) || (ret.equalsIgnoreCase("%"))));
		return ret;
	}

	/**
	 * Menu repetir
	 * 
	 * @param ret boleean para que siga el programa
	 * @param respuesta guarda lo que quiere hacer el usuario
	 * @return ret Para que vuelva e ejecutarse el programa
	 */
	public boolean repetir() {
		boolean ret = false;
		String respuesta;
		do {
			System.out.print("�Desea continuar trabajando con la calculadora? [s / n]");
			respuesta = teclado.next();
		} while (!((respuesta.equalsIgnoreCase("s")) || (respuesta.equalsIgnoreCase("n"))));

		if (respuesta.equalsIgnoreCase("s")) {
			ret = true;
		}
		return ret;
	}
}