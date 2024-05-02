/*
 * Implenta las distintas instrucciones bytecode que puede manejar nuestra maquina virtual
 */
public class ByteCode {
    private ENUM_BYTECODE name;
    private int param ;

    public ByteCode (ENUM_BYTECODE _name, int _param){
        this.name = _name;
        this.param = _param;
    }
    
    

    public ByteCode(ENUM_BYTECODE _name) {
    	this.name = _name;
    }



	public ENUM_BYTECODE getName() {
        return name;
    }

    public String getParam() {
    	if(this.name == ENUM_BYTECODE.ADD || this.name == ENUM_BYTECODE.SUB || this.name == ENUM_BYTECODE.DIV || this.name == ENUM_BYTECODE.MUL || this.name == ENUM_BYTECODE.OUT || this.name == ENUM_BYTECODE.HALT) {
    		return "";
    	}else{
            return ""+this.param;
    	}
    }
    
    public int getParam2() {
    	return this.param;
    }
    
    
    


    /*
     * 
     */

}
