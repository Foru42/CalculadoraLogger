package operaciones;

/**
 * Operaciones
 * 
 * @author Josu_Foruria
 * @version 1.0
 */
public class Operaciones {
	/**
	 * operacion sumar
	 * 
	 * @param valor1 Primer numero introducido
	 * @param valor2 Segundo numero introducido
	 * @param numero
	 * @return numero devuelve la suma de los valores
	 */
	public int sumar(int valor1, int valor2) {
		int numero;
		numero = valor1 + valor2;
		return numero;
	}

	/**
	 * Operacion restar
	 * 
	 * @param valor1 Primer numero introducido
	 * @param valor2 Segundo numero introducido
	 * @param numero
	 * @return numero devuelve la suma de los valores
	 */

	public int restar(int valor1, int valor2) {
		int numero;
		numero = valor1 - valor2;
		return numero;
	}

	/**
	 * Operacion multiplicar
	 * 
	 * @param valor1 Primer numero introducido
	 * @param valor2 Segundo numero introducido
	 * @param numero
	 * @return numero
	 */
	public int multiplicar(int valor1, int valor2) {
		int numero;
		numero = valor1 * valor2;
		return numero;
	}

	/**
	 * Operacion dividir
	 * 
	 * @throws ArithmeticException devuelve la excepcion 0/0
	 * @param valor1 Primer numero introducido
	 * @param valor2 Segundo numero introducido
	 * @param numero
	 * @return numero devuelve la suma de los valores
	 */
	public int dividir(int valor1, int valor2) throws ArithmeticException {
		int numero;
		numero = valor1 / valor2;
		return numero;
	}

	/**
	 * Operacion resto
	 * 
	 * @param valor1 Primer numero introducido
	 * @param valor2 Segundo numero introducido
	 * @param numero
	 * @return numero devuelve la suma de los valores
	 */
	public int resto(int valor1, int valor2) {
		int numero;
		numero = valor1 % valor2;
		return numero;
	}
}