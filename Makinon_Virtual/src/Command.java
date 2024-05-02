/*
 * Esta clase representa los distintos comandos que puede utilizar un usuario
 */
public class Command {
	private ENUM_COMMAND command;
	private ByteCode instruction; // toma valor cuando se hace referencia al comando NEWINST
	private int replace;// Hace referencia al comando REPLACE

	public Command(ENUM_COMMAND comando, ByteCode BC) {
		this.instruction = BC;
		this.command = comando;
	}

	public Command(ENUM_COMMAND command) {
		this.command = command;
	}

	public Command(ENUM_COMMAND command, int replace) {
		this.replace = replace;
	}

	/*
	 * aqui tiene un ifesle enorme si es help si es run si es etc y dentro pones
	 * engine.reset(por ejemplo) todos los comandos como reset etc se ejectura en
	 * engine , en el mismo engine van a estar aqui solo los llamamos por eso
	 * pedimos un metodo de tipo engine
	 */
	public boolean execute(Engine engine) {
		switch (this.command) {
		case HELP:
			engine.CommandHelp();
			return true;
		case NEWINST:
			engine.CommandNewInst(this);
			return true;
		case RUN:
			// engine.CommandRun()
		case REPLACE:
			// engine.CommandReplace()
		case RESET:
			// engine.CommandReset()
		case QUIT :
			engine.ComandQuit();
			return true;
		default:
			return false;
		}
	}

	/*
	 * 
	 */

	public ENUM_COMMAND getCommand() {
		return command;
	}

	public ByteCode getInstruction() {
		return instruction;
	}
}
