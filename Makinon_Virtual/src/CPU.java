/**
 * Clase que reprena el corazon de la maquina aqui se van a ejecutar todas las
 * operaciones aritmeticas
 */
public class CPU {
	private OperandStack pila;
	private Memory memory;
	private boolean halt;

	/**
	 * Constructora
	 */
	public CPU() {
		this.pila = new OperandStack();
		this.memory = new Memory();
	}

	/**
	 * Metodo que ejecuta todos los metodos de los ByteCodes
	 * 
	 * @param BC ByteCode que vamos a ejecutar
	 * @return Booleano si se puede ejecutar o no
	 */
	public boolean execute(ByteCode BC) {
		switch (BC.getName()) {
		case ADD:
			return this.sumaPila();
		case SUB:
			return this.restaPila();
		case MUL:
			return this.multPila();
		case DIV:
			return this.divPila();
		case STORE:
			return this.store(BC);
		case PUSH:
			return this.pila.push(BC.getParam2());
		case HALT:
			this.halt = true;
			return true;
		case LOAD:
			return this.pila.push(this.memory.read(BC.getParam2()));
		case OUT:
			return this.out();
		default:
			return false;
		}
	}

	/**
	 * Metodo que imprime el estado de la memoria y el de la pila utilizando sus
	 * metodos to string de cada clase
	 */

	public String toString() {
		return "\n\nEstado de la CPU:\n" + "  Memoria : " + memory.toString() + "\n" + "  Pila :" + pila.toString();
	}

	/**
	 * Metodo que borra la pila y la memoria
	 */
	public void erase() {
		this.pila = new OperandStack();
		this.memory = new Memory();
	}

	/**
	 * Metodo para poner en funcionamiento la maquina
	 */

	public void runCPU() {
		this.halt = false;
	}

	/**
	 * Metodo que dice si la maquina esta parada o no la maquina
	 */

	public boolean isHalt() {
		return this.halt;
	}

	/**
	 * Metodo que suma los dos ultimos numeros de la pila
	 * 
	 * @return booleano si se puedo ejecutar o no
	 */

	public boolean sumaPila() {

		int num1 = this.pila.pop();
		int num2 = this.pila.pop();

		if (num1 == -1) {
			return false;
		} else if (num2 == -1) {
			this.pila.push(num1);
			return false;
		} else {
			this.pila.push(num1 + num2);
			return true;
		}
	}

	/**
	 * Metodo que resta los dos ultimos numeros de la pila
	 * 
	 * @return booleano si se puedo ejecutar o no
	 */

	public boolean restaPila() {

		int num1 = this.pila.pop();
		int num2 = this.pila.pop();

		if (num1 == -1) {
			return false;
		} else if (num2 == -1) {
			this.pila.push(num1);
			return true;
		} else {
			this.pila.push(num1 - num2);
			return true;
		}
	}

	/**
	 * Metodo que multiplica los dos ultimos numeros de la pila
	 * 
	 * @return booleano si se puedo ejecutar o no
	 */

	public boolean multPila() {
		int num1 = this.pila.pop();
		int num2 = this.pila.pop();

		if (num1 == -1) {
			return false;
		} else if (num2 == -1) {
			this.pila.push(num1);
			return true;
		} else {
			this.pila.push(num1 * num2);
			return true;
		}
	}

	/**
	 * Metodo que multiplica los dos ultimos numeros de la pila
	 * 
	 * @return booleano si se puedo ejecutar o no
	 */

	public boolean divPila() {
		int num1 = this.pila.pop();
		int num2 = this.pila.pop();

		if (num1 == -1) {
			return false;
		} else if (num1 == 0) {
			return false;
		} else {
			this.pila.push(num1 / num2);
			return true;
		}

	}

	/**
	 * Metodo que guarda en la posicion de la memoria la posicion que digamos
	 * 
	 * @param bc ByteCode para saber la posicion en la que ponerlo
	 * @return Booleano de si se pudo hacer o no
	 */

	public boolean store(ByteCode bc) {
		this.memory.write(bc.getParam2(), this.pila.pop());
		return true;
	}

	/**
	 * Metodo que nos muestra la cima de la pila sin quitarlo de ella
	 * 
	 * @return Booleano de si se pudo hacer o no
	 */
	public boolean out() {
		System.out.println(this.pila.getCima());
		return true;
	}

}
