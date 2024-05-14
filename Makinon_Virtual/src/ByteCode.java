/**
 * Clase que se encarga de dar forma a los ByteCodes
 */
public class ByteCode {
	private ENUM_BYTECODE name;
	private int param;

	/**
	 * Constructora para los ByteCode que tengan parametro ,push por ejemplo
	 * 
	 * @param _name
	 * @param _param
	 */
	public ByteCode(ENUM_BYTECODE _name, int _param) {
		this.name = _name;
		this.param = _param;
	}

	/**
	 * Constructora para ByteCode que no tengan parametro ,add por ejemplo
	 * 
	 * @param _name
	 */
	public ByteCode(ENUM_BYTECODE _name) {
		this.name = _name;
	}

	/**
	 * Metodo que que nos da el enum que nos dice que bytecode es
	 * 
	 * @return ENUM_BYTECODE que dice el tipo de ByteCode que es
	 */
	public ENUM_BYTECODE getName() {
		return name;
	}

	/**
	 * Devuelve un string con el parametro solo si lo tiene
	 * 
	 * @return String Con el parametro
	 */
	public String getParam() {
		if (this.name == ENUM_BYTECODE.ADD || this.name == ENUM_BYTECODE.SUB || this.name == ENUM_BYTECODE.DIV
				|| this.name == ENUM_BYTECODE.MUL || this.name == ENUM_BYTECODE.OUT
				|| this.name == ENUM_BYTECODE.HALT) {
			return "";
		} else {
			return "" + this.param;
		}
	}

	/**
	 * Merodo que nos devuelve el parametro pero esta vez devuelve un int
	 * 
	 * @return El parametro de los ByteCode
	 */
	public int getParam2() {
		return this.param;
	}
}
