/**
 * Representa el programa actual
 */
public class ByteCodeProgram {
	private ByteCode[] programs;// array que contiene la lista de programas
	private int numElements; // todos los elemetos
	private int size;// tamaño de la array

	public ByteCodeProgram() {
		this.size = 1;
		this.numElements = 0;
		this.programs = new ByteCode[size];
	}

	public ByteCode pop() {
		return this.programs[size - 1];
	}

	public boolean setInstructionPosition(ByteCode BC, int pos) {
		if (pos >= 0 && pos <= this.programs.length) {
			this.programs[pos] = BC;
			return true;
		}else {
			return false;
		}
		
	}

	public String toSting() {
		String mensaje = "Programa almacenado : \n";

		for (int i = 0; i <= this.numElements - 1; i++) {
			mensaje += i + " : " + this.programs[i].getName() + " " + this.programs[i].getParam() + "\n";
		}

		return mensaje;
	}

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

	private void resize() {
		ByteCode[] temp = new ByteCode[this.programs.length*2];

		for (int i = 0; i < this.programs.length ; i++) {
			temp[i] = this.programs[i];
		}

		this.programs = temp;
	}
	
	public void reset() {
		this.programs = new ByteCode[this.size];
		this.numElements = 0;
	}
	
	
	public String runProgram(CPU cpu) {
    	
		String mensaje = "";
		
    	for (int i = 0; i < this.numElements; i++) {
			if(!cpu.isHalt() && cpu.execute(this.programs[i])) {
				mensaje += "\n\nEl estado de la maquina tras la ejecucion de : "+this.programs[i].getName()+ " " + this.programs[i].getParam() + cpu.toString();
			}else if(!cpu.isHalt()) {
				mensaje += "\nError : Ejecucion incorrecta del comando" ;
			}
		}
    	cpu.erase();
    	cpu.runCPU();
    	return mensaje;
    }
	
	public int getNumElements() {
		return numElements;
	}
	
	public int programSize() {
		return this.programs.length;
	}

	/*
	 * necesito run program (lo paso el jony , lo tengo explicado escrito y en la hojas)
	 * necesito un metodo reset = elimina el array (this.program = new
	 * ByteCode[size])
	 */

}
