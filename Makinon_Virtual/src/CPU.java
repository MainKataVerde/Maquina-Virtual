/*
 * Tiene una pila de tipo operanstuck (ninugno es una array ni nada)
 * tiene un atributo q se llama memoria q es de tipo memoria
 * tiene un booleano llamado halt , q es la condicion de parada
 */

public class CPU {
	private OperandStack pila;
	private Memory memory;
	private boolean halt ;
		
	//tengo q hacer un get.enumin si no no funcionan (todo esto dentro de bc)
	public boolean execute(ByteCode BC) {
		switch (BC.getName()) {
		case ADD:

			break;
		case SUB:

			break;
		case MUL:

			break;
		case DIV:

			break;
		case STORE:

			break;
		case PUSH:

			break;
		case HALT:

			break;
		case LOAD:

			break;

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
		return "Estado de la CPU:\n" + "Memoria : " +memory.toString() + "\n"+ "Pila :" + pila.toString();
	}

	/*
	 * metodo erase borra la pila y la memoria
	 */

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
	 * usar los metodos de pop y push
	 * todos estos metodos son booleanos
	 */

}
