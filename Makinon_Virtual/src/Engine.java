/*
 * Esta clase representa el bucle de control de la aplucacion
 */

import java.util.Scanner;

public class Engine {
	private ByteCodeProgram program; // representa el programa actual
	private boolean end; // representa cuando termina el programa
	private CPU cpu;
	private Scanner sc = new Scanner(System.in);

	public Engine() {
		this.end = false;// lo iniciamos en end pq se supone que tiene que empezar encendida
		this.program = new ByteCodeProgram();
		this.cpu = new CPU();
		// iniciamos todo de normal no hay que poner nada
	}

	/*
	 * se encarga de leer sucesivamente los comandos del usuario hasta que se
	 * escriba QUIT entra en un buble
	 * 
	 * Lo que hace : recoge lo q pone por pantalla (scanner) utilizamos el
	 * comandParser para saber que comando que ha ejecutado el ususario y creamos el
	 * comando , Comand cmd = ComandParser.parser(entrada) funciona pq es estatico
	 * ahora va "COMIENDA AL EJECUCION DE (COMANDO)" si el comando es distinti de
	 * null (que exista el comando)
	 * 
	 * if(cmd != null) el comando es valido ? if(!co.execute(this)) el comando se ha
	 * podido ejecutar?
	 * 
	 * NO HACE FALTA EJECUTAR NADA PQ EN EL MISMO IF SE EJECUTA
	 */
	public void star() {
		while (!this.end) {
			String entrada = sc.nextLine();
			Command cmd = CommandParsear.parse(entrada);
			if (cmd != null) {
				System.out.println("Comieza la ejecucion de " + cmd.getCommand() + "\n\n");
				if (cmd.execute(this)) {

				} else {
					System.err.println("Error : el comando no se pudo ejecutar");
				}
			} else {
				System.err.println("Error : Comando incorrecto");
			}
		}
	}

	/*
	 * CommandHelp() = sting enorme hace lo q hace el help CommandReplace(int
	 * replace) hace lo q hace el replace Y asi todos CommanReset() = llama al reset
	 * de ByteCodeProgram borra la pila de bytecodeprogram CommandNewinst(bytecode
	 * bc(este es el atributo del comando de arriba)) = llama al metodo solo añade
	 * un bytecode al programa (this.program.setIntructio(bc)) CommandRun() = llama
	 * a runProgram de la clase BytecodeProgram
	 */

	public boolean CommandHelp() {
		System.out.println(
				" HELP : Muestra esta ayuda\n QUIT : Cierra la aplicacion\n RUN : Ejecuta el programa\n NEWINST BYTECODE : Introduce una nueva instruccion al programa\n RESET: Vacia el programa actual\n REPLACE N : Reemplaza la instuccion N por la solicitada al usuario");
		return true;
	}

	public boolean CommandNewInst(Command cmd) {
		program.setInstruction(cmd.getInstruction());
		System.out.println(program.toSting());

		return true;
	}

	public boolean CommandQuit() {
		this.end = true;
		System.out.println(program.toSting());
		System.out.println("Fin de la ejecucion....");
		return true;
	}

	public boolean CommandRun() {
		System.out.println(this.program.runProgram(cpu));
		return true;
	}
	
	public boolean CommandReset() {
		this.program.reset();
		return true;
	}
}
