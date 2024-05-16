/**
 * Representa la memoria de la maquina y no es volatil 
 */
public class Memory {
    private Integer[] memory;
    private int size;
    private boolean empty;
    private int numElements;
/**
 * Constructora
 */
    public Memory() {
        this.size = 1;
        this.memory = new Integer[this.size];
    }

   /**
    * Metodo que escribe en la memoria 
    * @param pos posicion de en la q se va a escribir
    * @param value valor que va a introducir en la memoris
    * @return Si se hizo un resize true si no false
    */
    public boolean write(int pos, int value) {
        if (pos >= this.memory.length) {
            resize(pos);
            this.memory[pos] = value;
            this.numElements++;
            return true;
        } else {
            this.memory[pos] = value;
            this.numElements++;
            return false;
        }
    }

    /**
     * Leemos lo q hay en la posicion que decimos en el array
     * si no hay nada en la posicion "pos" se devuelve -1
     * @param pos nos dice la posicion que quiere leer
     */
    public int read(int pos) {
        if (this.memory[pos] == null) {
            return -1;
        }else{
            return this.memory[pos];
        }
    }

    /**
     * Metodo que le da un nuevo tamaño a al array
     * @param pos posicion del array para dupliar el tamaño
     */
    private void resize(int pos) {
        Integer[] temp = new Integer[pos * 2];

        for (int i = 0; i < this.memory.length; i++) {
                temp[i] = this.memory[i];
        }

        this.memory = temp;
    }
/**
 * Metodo que imprime el estado de la memoria
 */
    public String toString(){
        String cadena = "";
        if (this.numElements > 0) {
            for (int i = 0; i < this.memory.length; i++) {
            	if(this.memory[i] != null) {
            		cadena += "[" + i + "]" + ":"+ this.memory[i] + " ";
            	}
            }
        }else{
        	cadena = "<vacio>";
        }
        return cadena;
    }
}
