import java.util.Scanner;

/**
 * Esta clase representa el bucle de control de la aplucacion
 */
public class Engine {
	private ByteCodeProgram program;
	private boolean end;
	private CPU cpu;
	private Scanner sc = new Scanner(System.in);

	/**
	 * Constuctora
	 */
	public Engine() {
		this.end = false;
		this.program = new ByteCodeProgram();
		this.cpu = new CPU();
	}

	/**
	 * Metodo de con una Loop de ejecucion de la maquina
	 */
	public void star() {
		while (!this.end) {
			String entrada = sc.nextLine();
			Command cmd = CommandParsear.parse(entrada);
			if (cmd != null) {
				if (cmd.getInstruction() == null) {
					System.out.println("Comieza la ejecucion de " + cmd.getCommand());
				} else {
					System.out.println("Comieza la ejecucion de " + cmd.getCommand() + " "
							+ cmd.getInstruction().getName() + " " + cmd.getInstruction().getParam() + "\n\n");
				}
				if (cmd.execute(this)) {
				} else {
					System.out.println("Error : el comando no se pudo ejecutar");
				}
			} else {
				System.out.println("Error : Comando incorrecto");
			}
		}
	}

	/**
	 * Metodo que devuelve la una cadena con las ayudas
	 * 
	 * @return Booleano de ejecucion
	 */
	public boolean CommandHelp() {
		System.out.println(
				" HELP : Muestra esta ayuda\n QUIT : Cierra la aplicacion\n RUN : Ejecuta el programa\n NEWINST BYTECODE : Introduce una nueva instruccion al programa\n RESET: Vacia el programa actual\n REPLACE N : Reemplaza la instuccion N por la solicitada al usuario");
		return true;
	}

	/**
	 * Metodo para crear nuevas instucciones
	 * 
	 * @param cmd comando para poder añadir un nuevo ByteCode a la pila
	 * @return si se ha podido ejecutar o no
	 */

	public boolean CommandNewInst(ByteCode BC) {
		if (BC == null) {
			return false;
		} else {
			this.program.setInstruction(BC);
			System.out.println(this.program.toSting());
			return true;
		}
	}

	/**
	 * Metodo para salir del bucle y acabar el programa
	 * 
	 * @return si se ha podido ejecutar o no
	 */
	public boolean CommandQuit() {
		System.out.println(this.program.toSting());
		System.out.println("Fin de la ejecucion....");
		this.end = true;
		return true;
	}

	/**
	 * Metodo para ejecutar los ByteCode alamacenados en program
	 * 
	 * @return si se ha podido ejecutar o no
	 */
	public boolean CommandRun() {
		System.out.println(this.program.runProgram(cpu));
		System.out.println(this.program.toSting());
		return true;
	}

	/**
	 * Metodo para resetear el array de programas
	 * @return
	 */
	public boolean CommandReset() {
		this.program.reset();
		return true;
	}
	/**
	 * Metodo para remplazar un programa por otro que ya este almacena en la array
	 * @param cmd comando necesario para saber la posicion en la que queremos remplazar todo
	 * @return
	 */

	public boolean CommandReplace(int replace) {
		if (replace < this.program.programSize() && replace >= 0) {
			System.out.print("Nueva instruccion : ");
			String entrada = sc.nextLine();
			ByteCode bc = ByteCodeParsear.parser(entrada);
			this.program.setInstructionPosition(bc, replace);
			System.out.println(this.program.toSting());
			return true;
		} else {
			System.out.println(this.program.toSting());
			return false;
		}
	}
}
