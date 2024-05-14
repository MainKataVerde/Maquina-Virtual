/**
 * Esta clase solo se encarga de crear los ByteCode a partir de la cadena que
 * nos de el usuario
 */
public class ByteCodeParsear {
	/**
	 * Metodo que nos haace saber que ByteCode no esta llegando por parametro
	 * 
	 * @param cadenaUsuario
	 * @return El Bytecode en cuestion si no devuelve null
	 */
	public static ByteCode parser(String cadenaUsuario) {
		String[] cadema = cadenaUsuario.split(" ");
		if (cadema.length == 2) {
			if (cadema[1] != null) {
				switch (cadema[0]) {
				case "push":
					return new ByteCode(ENUM_BYTECODE.PUSH, Integer.parseInt(cadema[1]));
				case "load":
					return new ByteCode(ENUM_BYTECODE.LOAD, Integer.parseInt(cadema[1]));
				case "store":
					return new ByteCode(ENUM_BYTECODE.STORE, Integer.parseInt(cadema[1]));
				default:
					return null;
				}
			} else {
				return null;
			}
		} else if (cadema.length == 1) {
			switch (cadema[0]) {
			case "add":
				return new ByteCode(ENUM_BYTECODE.ADD);
			case "sub":
				return new ByteCode(ENUM_BYTECODE.SUB);
			case "div":
				return new ByteCode(ENUM_BYTECODE.DIV);
			case "mul":
				return new ByteCode(ENUM_BYTECODE.MUL);
			case "out":
				return new ByteCode(ENUM_BYTECODE.OUT);
			case "halt":
				return new ByteCode(ENUM_BYTECODE.HALT);
			default:
				return null;
			}
		} else {
			return null;
		}

	}
}
