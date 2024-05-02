/*
 * Representa la memoria de la maquina
 */
public class Memory {
    private final int MAX_MEMORY;
    private Integer[] memory;
    private int size;
    private boolean empty;
    private int numElements;

    public Memory() {
        this.MAX_MEMORY = 10;
        this.memory = new Integer[MAX_MEMORY];
        this.size = 0;
    }

    /*
     * Escribimos el valor que en la posicion de la memoria que elijamosb
     * en value tiene que ir la cima de la pila
     * hay que saber si en la posicion que nos pone es menor que cero
     * si se puede escribir tru si no da false
     */
    public boolean write(int pos, int value) {
        if (pos >= this.MAX_MEMORY) {
            resize(pos);
            this.numElements++;
            return true;
        } else {
            this.memory[pos] = value;
            this.numElements++;
            return false;
        }
    }

    /*
     * Leemos lo q hay en la posicion que decimos en el array
     * si no hay nada en la posicion "pos" se devuelve -1
     */
    public int read(int pos) {
        if (this.memory[pos] == null) {
            return -1;
        }else{
            return this.memory[pos];
        }
    }

    /*
     * Cuando el la posicion en la que queremos escribir es mayor que en el tamaño
     * de la array
     * este metodo crea una nueva array con el doble de tamaño que la anterior y lo
     * escribe dentro
     */
    private void resize(int pos) {
        Integer[] temp = new Integer[pos * 2];

        for (int i = 0; i < temp.length; i++) {
            if (i < this.memory.length) {
                temp[i] = this.memory[i];
            } else {
                temp[i] = null;
            }
        }

        this.memory = temp;
    }

    public String toString(){
        String cadena = "";
        if (this.size > 0) {
            for (int i = 0; i < this.memory.length; i++) {
                cadena += "[" + i + "]" + ":"+ this.memory[i] + " ";
            }
        }else{
            System.out.println("<vacia>");
        }
        return cadena;
    }
}
