public class CommandParsear {
	/*
	 * Coge un strean lo particiona y lo analiza viendo cada parte del String Si
	 * esta mal o no correspongo con nungun comando se devuelve null
	 */

	// tengo que hacer dos filtros uno del tamaño de comando y otro de que es cada
	// uno
	public static Command parse(String line) {
		String[] comando = line.toLowerCase().split(" ");

		switch (comando.length) {
		// filtrado de tamaño
		case 1:
			// filtrado de contenido(saber cual es cual)
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
			if(comando[1] != null) {
				switch (comando[0]) {
				case "replace":
						return new Command(ENUM_COMMAND.REPLACE, Integer.parseInt(comando[1]));
				case "newinst" :
						return new Command(ENUM_COMMAND.NEWINST, ByteCodeParsear.parser(comando[1]));
				default:
					return null;
				}
			}else {
				return null;
			}
			
		case 3:
			switch (comando[0]) {
			case "newinst":
				if (comando[1] != null) {
					return new Command(ENUM_COMMAND.NEWINST, ByteCodeParsear.parser(comando[1] + " " + comando[2]));
				}else {
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
