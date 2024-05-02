/*
 * Identificar que esta poniendo el ususario por consola
 */
public class ByteCodeParsear {
	/*
	 * Devuelve un bytecode
	 */
	public static ByteCode parser(String cadenaUsuario) {
		String[] cadema = cadenaUsuario.split(" ");
		// si la segunda cadena esta vacia eso quire decir que es de 1 solo
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
			}else{
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

		/*
		 * Paricionar el streang q no llega por consolar si el tamaño es 0 se devuelve
		 * null es q no ha puesto nada basicamente si tiene tamaño 1 tenemos que
		 * comprobar que palabra es y si coincide con una bytecode si no coincide con
		 * nada devuelve null si coincide pues creamos un objeto tipo bite code de tipo
		 * add si el tamaño es 2 es igual q el uno si no es nada es null si es mayor que
		 * todo esto es null
		 */
	}
}
