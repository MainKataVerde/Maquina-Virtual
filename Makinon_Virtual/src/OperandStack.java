/*
 * Implementa la pila de operaciones donde se van apilando elementos de tipo entero
 * es la pila que muestra en medio de la ejecucion donde se van a guardar los resultados
 */
public class OperandStack {
    private int[] stack;
    private final int MAX_STACK = 10;
    private int numElement;

    public OperandStack() {
        this.stack = new int[MAX_STACK];
        this.numElement = 0;
    }

    /*
     * Retorna un string no lo imprime
     * Utiliza el array stuck y lo pasa a string
     * Sintaxis : Pila : valor valor
     */

    public String toString() {
        String cadena = "";

        if (!isEmpty()) {
            for (int i = 0; i < this.numElement; i++) {
                cadena += " " + this.stack[i];
            }
        } else {
        	cadena = " <vacio>";
        }

        return cadena;
    }

    /*
     * Nos dice si la array esta vacia o no
     */

    public boolean isEmpty() {
        return this.numElement == 0;
    }

    /*
     * Añadimos elemento a la array
     */

    public boolean push(int valor) {
        boolean estado = true;
        if (this.numElement == this.MAX_STACK) {
            estado = false;
        } else {
            this.stack[numElement] = valor;
            numElement++;
            estado = true;
        }
        return estado;
    }

    /*
     * Nos da el ultimo elemento de la array
     * tenemos que preguntar si esta vacia primero
     * saca el elemento de la array
     * si el pop falla se devuelve -1
     */

    public int pop() {
        if (!isEmpty()) {
            this.numElement--;
            return this.stack[this.numElement];
        } else {
            return -1;
        }
    }

    /*
     * te da el primer el elemento
     * siempre comprobando la cima si no se puede devolver devolvemos -1
     */
    public int getCima() {
        return 1;
    }

}
