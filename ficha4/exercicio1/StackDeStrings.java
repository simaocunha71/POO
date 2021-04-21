import java.util.ArrayList;

public class StackDeStrings {
    private ArrayList<String> stack;

    public StackDeStrings() {
        this.stack = new ArrayList<String>();
    }

    /**
     * Determina a string que está no topo
     * 
     * String get(int i) : devolve a string no indice i (inclui o indice 0) 
     * Boolean isEmpty() : verifica se algo está vazio (e.g. devolve true sse o comprimento é 0)
     * 
     * @return String que está no topo da stack
     */
    public String top() {
        if (!this.stack.isEmpty())
            return this.stack.get(this.stack.size() - 1); // o valor que está no topo da stack está no indice SIZE-1
        else
            return null;
    }

    /**
     * Insere uma string no topo da stack
     * 
     * void add (Object o): adiciona o objecto o num ArrayList
     * 
     * @param s String a inserir na stack
     */
    public void push(String s) {
        this.stack.add(s);
    }

    /**
     * Remove a string do topo da stack, se esta não estiver vazia
     * 
     * void remove (Object o): remove o objecto o num ArrayList
     * 
     * @return String removida
     */
    public String pop() {
        if (!this.stack.isEmpty())
            return this.stack.remove(this.stack.size() - 1); // o valor que está no topo da stack está no indice SIZE-1
        else
            return null;
    }

    /**
     * Verifica se a stack está vazia
     * 
     * Boolean isEmpty() : verifica se algo está vazio (e.g. devolve true sse o comprimento é 0)
     * 
     * @return True se está vazia, false caso contrário
     */
    public boolean empty() {
        return this.stack.isEmpty();
    }

    /**
     * Calcula o comprimento da stack
     * 
     * int size() : devolve o tamanho do ArrayList
     * 
     * @return Comprimento da stack
     */
    public int length() {
        return this.stack.size();
    }

    /**
     * Stack para string
     */
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Stack: " + this.stack.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        StackDeStrings ss = new StackDeStrings();
        System.out.println("Stack original:");
        System.out.println(ss.toString());
        System.out.println("");

        ss.push("Que ");
        ss.push("stack ");
        ss.push("tao");
        ss.push("bonita");
        System.out.println("Construindo stack...");
        System.out.println(ss.toString());
        System.out.println("");

        ss.pop();
        System.out.println("Efetuando pop...");
        System.out.println(ss.toString());
        System.out.println("");

        System.out.println("Efetuando top...");
        System.out.println("Elemento no topo -> " + ss.top());
        System.out.println("");

        System.out.println("Calculando tamanho da stack...");
        System.out.println("Tamanho da stack -> " + ss.length());
    }
}