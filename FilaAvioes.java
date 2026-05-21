import java.util.LinkedList;
import java.util.Queue;

public class FilaAvioes {

    private Queue<Aviao> fila;

    public FilaAvioes() {
        fila = new LinkedList<>();
    }

    public void adicionar(Aviao aviao) {
        fila.add(aviao);
    }

    public Aviao remover() {
        return fila.poll();
    }

    public Aviao primeiro() {
        return fila.peek();
    }

    public boolean vazia() {
        return fila.isEmpty();
    }

    public int tamanho() {
        return fila.size();
    }

    public Queue<Aviao> getFila() {
        return fila;
    }

    public void mostrarFila(String nome) {

        System.out.print(nome + ": ");

        if (fila.isEmpty()) {
            System.out.println("vazia");
            return;
        }

        for (Aviao a : fila) {
            System.out.print(a + " ");
        }

        System.out.println();
    }
}