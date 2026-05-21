public class Pista {

    private int numero;

    public Pista(int numero) {
        this.numero = numero;
    }

    public void usarParaPouso(Aviao aviao) {
        System.out.println("Pista " + numero +
                " -> POUSO do avião " + aviao.getId());
    }

    public void usarParaDecolagem(Aviao aviao) {
        System.out.println("Pista " + numero +
                " -> DECOLAGEM do avião " + aviao.getId());
    }
}