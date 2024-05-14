/**
 * Implementa la pila de operaciones donde se van apilando elementos de tipo
 * entero es la pila que muestra en medio de la ejecucion donde se van a guardar
 * los resultados
 */
public class OperandStack {
	private int[] stack;
	private final int MAX_STACK = 10;
	private int numElement;

	/**
	 * Constructora
	 */
	public OperandStack() {
		this.stack = new int[MAX_STACK];
		this.numElement = 0;
	}

	/**
	 * Metodo que devuelve una cadena con el estado de la pila
	 */
	public String toString() {
		String cadena = "";

		if (!isEmpty()) {
			for (int i = 0; i < this.numElement; i++) {
				cadena += " " + this.stack[i];
			}
		} else {
			cadena = " <vacio>";
		}

		return cadena;
	}

	/**
	 * Metodo que nos dice si la pila esta vacia
	 * 
	 * @return True = vavia , False = no vacia
	 */

	public boolean isEmpty() {
		return this.numElement == 0;
	}

	/**
	 * Metodo para añadir un numero a la pila
	 * 
	 * @param valor Valor para añadir a la pila
	 * @return True = se puedo introducir , False = no se pudo introducir
	 */
	public boolean push(int valor) {
		boolean estado = true;
		if (this.numElement == this.MAX_STACK) {
			estado = false;
		} else {
			this.stack[this.numElement] = valor;
			this.numElement++;
			estado = true;
		}
		return estado;
	}

	/**
	 * Metodo que nos da el ultimo elemento de la array Se resta el numero de
	 * elementos cada vez que se saca un numero
	 * 
	 * @return Si no esta vacio devuelve el ultimo , si esta vacio devuelve -1
	 */

	public int pop() {
		if (!this.isEmpty()) {
			this.numElement--;
			return this.stack[this.numElement];
		} else {
			return -1;
		}
	}

	/**
	 * Metodo como el pop pero no lo quita de la pila
	 * 
	 * @return Cadena con el ultimo elemento de la pila
	 */
	public String getCima() {
		String cadena = "";
		if (!this.isEmpty()) {
			cadena = "Ultimo numero de la pila : " + this.stack[this.numElement - 1];
		} else {
			cadena = "<vacio>";
		}
		return cadena;
	}
}
