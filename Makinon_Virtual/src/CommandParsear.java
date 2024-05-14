/**
 * Clase que traduce los escrito por el ususario y lo combierte si existe en un
 * Comando nuevo
 */
public class CommandParsear {
	/**
	 * Metodo que traduce el string que nos da el ususario a un comando
	 * 
	 * @param line Strinf del ususario
	 * @return Comando dado por el usuario y si no null
	 */
	public static Command parse(String line) {
		String[] comando = line.toLowerCase().split(" ");

		switch (comando.length) {
		case 1:
			switch (comando[0]) {
			case "help":
				return new Command(ENUM_COMMAND.HELP);
			case "quit":
				return new Command(ENUM_COMMAND.QUIT);
			case "run":
				return new Command(ENUM_COMMAND.RUN);
			case "reset":
				return new Command(ENUM_COMMAND.RESET);
			default:
				return null;
			}
		case 2:
			if (comando[1] != null) {
				switch (comando[0]) {
				case "replace":
					return new Command(ENUM_COMMAND.REPLACE, Integer.parseInt(comando[1]));
				case "newinst":
					return new Command(ENUM_COMMAND.NEWINST, ByteCodeParsear.parser(comando[1]));
				default:
					return null;
				}
			} else {
				return null;
			}

		case 3:
			switch (comando[0]) {
			case "newinst":
				if (comando[1] != null) {
					return new Command(ENUM_COMMAND.NEWINST, ByteCodeParsear.parser(comando[1] + " " + comando[2]));
				} else {
					return null;
				}
			default:
				return null;

			}
		default:
			return null;
		}
	}
}
