public class Aviao {

    private int id;
    private int combustivel;
    private int tempoEspera;
    private boolean pouso;

    public Aviao(int id, int combustivel, boolean pouso) {
        this.id = id;
        this.combustivel = combustivel;
        this.pouso = pouso;
        this.tempoEspera = 0;
    }

    public int getId() {
        return id;
    }

    public int getCombustivel() {
        return combustivel;
    }

    public void reduzirCombustivel() {
        if (pouso && combustivel > 0) {
            combustivel--;
        }
    }

    public int getTempoEspera() {
        return tempoEspera;
    }

    public void aumentarTempoEspera() {
        tempoEspera++;
    }

    public boolean isPouso() {
        return pouso;
    }

    @Override
    public String toString() {
        if (pouso) {
            return "[ID:" + id + " C:" + combustivel + "]";
        } else {
            return "[ID:" + id + "]";
        }
    }
}

