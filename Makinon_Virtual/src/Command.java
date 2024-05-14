/**
 * Esta clase representa los distintos comandos que puede utilizar un usuario
 */
public class Command {
	private ENUM_COMMAND command;
	private ByteCode instruction; // toma valor cuando se hace referencia al comando NEWINST
	private int replace;// Hace referencia al comando REPLACE

	/**
	 * Constructora de comandos que necesiten de un bytecode , como newinst
	 * 
	 * @param comando Enum del comando
	 * @param BC      Posibles bytecodes
	 */
	public Command(ENUM_COMMAND comando, ByteCode BC) {
		this.instruction = BC;
		this.command = comando;
	}

	/**
	 * Constuctora de comandos que no necesiten nada como help o quit
	 * 
	 * @param command Enum del comando
	 */

	public Command(ENUM_COMMAND command) {
		this.command = command;
	}

	/**
	 * Constuctora para el comando replace solo
	 * 
	 * @param command Enum del comando
	 * @param replace luegar que va a remplazat
	 */

	public Command(ENUM_COMMAND command, int replace) {
		this.command = command;
		this.replace = replace;
	}

	/**
	 * Metodo que ejecuta los metodos de engine
	 * 
	 * @param engine objeto engine para poder ejecutar los metodos y mandar la
	 *               informacion a engine
	 * @return booleano , si se ha podido ejecutar todo o no
	 */

	public boolean execute(Engine engine) {
		switch (this.command) {
		case HELP:
			return engine.CommandHelp();
		case NEWINST:
			return engine.CommandNewInst(this);
		case RUN:
			return engine.CommandRun();
		case REPLACE:
			return engine.CommandReplace(this);
		case RESET:
			return engine.CommandReset();
		case QUIT:
			return engine.CommandQuit();
		default:
			return false;
		}
	}

	/**
	 * Metodo getter que nos devuelve el enum tipo comand
	 * 
	 * @return el enum del comando en cuestion
	 */
	public ENUM_COMMAND getCommand() {
		return command;
	}

	/**
	 * Metodo getter que nos devuelve el ByteCode
	 * 
	 * @return el bytecode
	 */

	public ByteCode getInstruction() {
		return instruction;
	}

	/**
	 * Metodo getter que nos devuelve el ByteCode
	 * 
	 * @return posicion que se quiere remplazar
	 */

	public int getReplace() {
		return replace;
	}
}
