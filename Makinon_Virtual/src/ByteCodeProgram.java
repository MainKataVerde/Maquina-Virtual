/**
 * Clase que representa el array de programas en el que se vana a almacenar los
 * Bytecodes
 */
public class ByteCodeProgram {
	private ByteCode[] programs;// array que contiene la lista de programas
	private int numElements; // todos los elemetos
	private int size;// tamaño de la array

	/**
	 * Constuctora
	 */
	public ByteCodeProgram() {
		this.size = 1;
		this.numElements = 0;
		this.programs = new ByteCode[size];
	}

	/**
	 * Nos da el ultimo programa almacenado
	 * 
	 * @return Programa almacenado
	 */
	public ByteCode pop() {
		return this.programs[size - 1];
	}

	/**
	 * Metodo que nos permite introducir una instuccion en la parte que queramos
	 * mientras este dentro de limites
	 * 
	 * @param BC  Programa a introducir
	 * @param pos posicion en la que se intoduce
	 * @return Booleano , true = se pudo hacer la introduccion , false = no se pude
	 *         hacer
	 */
	public boolean setInstructionPosition(ByteCode BC, int pos) {
		if (pos >= 0 && pos <= this.programs.length) {
			this.programs[pos] = BC;
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Metodo que devuelve una cadena de programas almacenados
	 * 
	 * @return Cadena con los programas almacenados
	 */
	public String toSting() {
		String mensaje = "Programa almacenado : \n";

		for (int i = 0; i <= this.numElements - 1; i++) {
			mensaje += i + " : " + this.programs[i].getName() + " " + this.programs[i].getParam() + "\n";
		}

		return mensaje;
	}

	/**
	 * Metodo que instroduce una instuccion dentro de la array de programas
	 * 
	 * @param BC Programa a introducir
	 */
	public void setInstruction(ByteCode BC) {
		if (this.numElements >= this.programs.length) {
			this.resize();
			this.programs[this.numElements] = BC;
			this.numElements++;
		} else {
			this.programs[this.numElements] = BC;
			this.numElements++;
		}
	}

	/**
	 * Metodo que solo se usara dentro de esta clase , le da un nuevo tamaño a la
	 * array cuando el numero de programas sobrepasa al tamaño de la array
	 */
	private void resize() {
		ByteCode[] temp = new ByteCode[this.programs.length * 2];

		for (int i = 0; i < this.programs.length; i++) {
			temp[i] = this.programs[i];
		}

		this.programs = temp;
	}

	/**
	 * Metodo que resetea los programas
	 */
	public void reset() {
		this.programs = new ByteCode[this.size];
		this.numElements = 0;
	}

	/**
	 * Metodo que ejecuta todos los programas almacenados
	 * 
	 * @param cpu Obejeto tipo execute que nos permite ejecutar los programas
	 * @return Cadena con todo el proceso de ejecucion de todos los programas
	 */
	public String runProgram(CPU cpu) {

		String mensaje = "";

		for (int i = 0; i < this.numElements; i++) {
			if (!cpu.isHalt() && cpu.execute(this.programs[i])) {
				mensaje += "\n\nEl estado de la maquina tras la ejecucion de : " + this.programs[i].getName() + " "
						+ this.programs[i].getParam() + cpu.toString();
			} else if (cpu.isHalt()) {
				mensaje += "\nError : Ejecucion incorrecta del comando";
			}
		}
		cpu.erase();
		cpu.runCPU();
		return mensaje;
	}

	/**
	 * Metodo getter que nos da el el numero de elementos de la array
	 * 
	 * @return numero de elementos
	 */
	public int getNumElements() {
		return numElements;
	}

	/**
	 * Metodo que nos devuelve el tamaño de de la array de programa
	 * 
	 * @return
	 */
	public int programSize() {
		return this.programs.length;
	}
}
