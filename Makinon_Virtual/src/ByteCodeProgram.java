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
		boolean resice = false;

		if (pos >= 0) {
			if (pos >= this.size) {
				this.resize();
				this.programs[pos] = BC;
				resice = true;
			}
			this.programs[pos] = BC;
		} else {

		}
		return resice;
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

		for (int i = 0; i <= this.numElements - 1 ; i++) {
			temp[i] = this.programs[i];
		}

		this.programs = temp;
	}
	
	public void reset() {
		this.programs = new ByteCode[this.size];
	}
	
	
	public String runProgram(CPU cpu) {
    	String mensaje = "El estado de la maquina tras la ejecucion de : \n"+this.programs[this.numElements];
    	
    	for (int i = 0; i < this.numElements; i++) {
			if(!cpu.isHalt() && cpu.execute(this.programs[i])) {
				mensaje += cpu.toString();
			}else {
				mensaje = "Error : Ejecucion incorrecta del comando" ;
			}
		}
    	
    	return mensaje;
    }

	/*
	 * necesito run program (lo paso el jony , lo tengo explicado escrito y en la hojas)
	 * necesito un metodo reset = elimina el array (this.program = new
	 * ByteCode[size])
	 */

}
