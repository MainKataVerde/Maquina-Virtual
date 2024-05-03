/*
 * Tiene una pila de tipo operanstuck (ninugno es una array ni nada)
 * tiene un atributo q se llama memoria q es de tipo memoria
 * tiene un booleano llamado halt , q es la condicion de parada
 */

public class CPU {
	private OperandStack pila;
	private Memory memory;
	private boolean halt;

	public CPU() {
		this.pila = new OperandStack();
		this.memory = new Memory();
	}

	// tengo q hacer un get.enumin si no no funcionan (todo esto dentro de bc)
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
			return pila.push(BC.getParam2());
		case HALT:
			this.halt = true;
			return true;
		case LOAD:
			return this.pila.push(this.memory.read(BC.getParam2()));
		default:
			break;
		}

		return false;
	}

	/*
	 * tiene un metodo to string llama al metodo tostring de operanstuck y al de
	 * memory
	 */

	public String toString() {
		return "\n\nEstado de la CPU:\n" + "  Memoria : " + memory.toString() + "\n" + "  Pila :" + pila.toString();
	}

	/*
	 * metodo erase borra la pila y la memoria
	 */
	public void erase() {
		this.pila = new OperandStack();
		this.memory = new Memory();
	}
	/*
	 * tiene otro metodo isHalt dice si la maquina esta parada o no la maquina
	 * virtual
	 */

	public boolean isHalt() {
		return this.halt;
	}

	/*
	 * metodos : Suma pila , resta pila , multiplica pila , divide pila se tiene que
	 * sacar el elemento hacer la operacion y solo meter el resultado se tienen que
	 * usar los metodos de pop y push todos estos metodos son booleanos
	 */

	public boolean sumaPila() {

		int num1 = this.pila.pop();
		int num2 = this.pila.pop();

		if (num1 == -1) {
			return false;
		} else if (num2 == -1) {
			this.pila.push(num1);
			return true;
		} else {
			this.pila.push(num1 + num2);
			return true;
		}
	}
	
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

	public boolean divPila() {
		int num1 = this.pila.pop();
		int num2 = this.pila.pop();

		if (num1 == -1) {
			return false;
		} else if (num2 == -1) {
			this.pila.push(num1);
			return true;
		} else if (num2 == 0) {
			this.pila.push(num1);
			return true;
		} else {
			this.pila.push(num1 / num2);
			return true;
		}

	}

	public boolean store(ByteCode bc) {
		this.memory.write(bc.getParam2(), this.pila.pop());
		return true;
	}
	
}
