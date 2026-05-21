import java.util.Random;

public class Aeroporto {

    // Filas de pouso
    private FilaAvioes filaPouso1;
    private FilaAvioes filaPouso2;
    private FilaAvioes filaPouso3;
    private FilaAvioes filaPouso4;

    // Filas de decolagem
    private FilaAvioes filaDecolagem1;
    private FilaAvioes filaDecolagem2;
    private FilaAvioes filaDecolagem3;

    // Pistas
    private Pista pista1;
    private Pista pista2;
    private Pista pista3;

    private Random random;

    private int idPouso = 1;
    private int idDecolagem = 2;

    private int totalTempoPouso = 0;
    private int totalTempoDecolagem = 0;

    private int totalPousos = 0;
    private int totalDecolagens = 0;

    private int emergencias = 0;

    public Aeroporto() {

        filaPouso1 = new FilaAvioes();
        filaPouso2 = new FilaAvioes();
        filaPouso3 = new FilaAvioes();
        filaPouso4 = new FilaAvioes();

        filaDecolagem1 = new FilaAvioes();
        filaDecolagem2 = new FilaAvioes();
        filaDecolagem3 = new FilaAvioes();

        pista1 = new Pista(1);
        pista2 = new Pista(2);
        pista3 = new Pista(3);

        random = new Random();
    }

    public void simular(int tempoTotal) {

        for (int tempo = 1; tempo <= tempoTotal; tempo++) {

            System.out.println("\n======================");
            System.out.println("TEMPO " + tempo);
            System.out.println("======================");

            gerarAvioes();

            atualizarFilas();

            operarPistas();

            mostrarFilas();

            mostrarEstatisticas();
        }
    }

        //Teste FIFO
        private void gerarAvioes() {

    filaPouso1.adicionar(
            new Aviao(1, 5, true));

    filaPouso1.adicionar(
            new Aviao(3, 5, true));

    filaPouso1.adicionar(
            new Aviao(5, 5, true));
}






// Teste Controlado
//     private void gerarAvioes() {

//     Aviao a1 =
//             new Aviao(1, 5, true);

//     filaPouso1.adicionar(a1);

//     Aviao d1 =
//             new Aviao(2, 0, false);

//     filaDecolagem1.adicionar(d1);
// }

    //---------------------------------------------------------

    // private void gerarAvioes() {

    //     int qtdPousos = random.nextInt(4);
    //     int qtdDecolagens = random.nextInt(4);

    //         Aviao emergencia =
    //         new Aviao(1, 0, true);

    //         filaPouso1.adicionar(emergencia);

    //     // Aviões de pouso
    //     for (int i = 0; i < qtdPousos; i++) {

    //         int combustivel = random.nextInt(20) + 1;

    //         Aviao aviao =
    //                 new Aviao(idPouso, combustivel, true);

    //         menorFilaPouso().adicionar(aviao);

    //         System.out.println(
    //                 "Novo avião POUSO ID "
    //                         + idPouso
    //                         + " Combustível "
    //                         + combustivel
    //         );

    //         idPouso += 2;
    //     }

    //     // Aviões de decolagem
    //     for (int i = 0; i < qtdDecolagens; i++) {

    //         Aviao aviao =
    //                 new Aviao(idDecolagem, 0, false);

    //         menorFilaDecolagem().adicionar(aviao);

    //         System.out.println(
    //                 "Novo avião DECOLAGEM ID "
    //                         + idDecolagem
    //         );

    //         idDecolagem += 2;
    //     }
    // }

    private void atualizarFilas() {

        atualizarFilaPouso(filaPouso1);
        atualizarFilaPouso(filaPouso2);
        atualizarFilaPouso(filaPouso3);
        atualizarFilaPouso(filaPouso4);

        atualizarFilaDecolagem(filaDecolagem1);
        atualizarFilaDecolagem(filaDecolagem2);
        atualizarFilaDecolagem(filaDecolagem3);
    }

    private void atualizarFilaPouso(FilaAvioes fila) {

        for (Aviao a : fila.getFila()) {
            a.reduzirCombustivel();
            a.aumentarTempoEspera();
        }
    }

    private void atualizarFilaDecolagem(FilaAvioes fila) {

        for (Aviao a : fila.getFila()) {
            a.aumentarTempoEspera();
        }
    }

    private void operarPistas() {

        boolean emergencia =
                existeEmergencia();

        if (emergencia) {

            pousarEmergencias();

        } else {

            pousarNormal();
            decolarNormal();
        }
    }

    private boolean existeEmergencia() {

        return verificarEmergencia(filaPouso1)
                || verificarEmergencia(filaPouso2)
                || verificarEmergencia(filaPouso3)
                || verificarEmergencia(filaPouso4);
    }

    private boolean verificarEmergencia(FilaAvioes fila) {

        if (!fila.vazia()) {

            return fila.primeiro()
                    .getCombustivel() <= 0;
        }

        return false;
    }

    private void pousarEmergencias() {

        System.out.println("!!! EMERGÊNCIA !!!");

        pousarSeEmergencia(pista1);
        pousarSeEmergencia(pista2);
        pousarSeEmergencia(pista3);
    }

    private void pousarSeEmergencia(Pista pista) {

        FilaAvioes fila =
                filaComEmergencia();

        if (fila != null) {

            Aviao aviao = fila.remover();

            pista.usarParaPouso(aviao);

            emergencias++;

            totalPouso(aviao);
        }
    }

    private void pousarNormal() {

        pousarFila(pista1);
        pousarFila(pista2);
    }

    private void pousarFila(Pista pista) {

        FilaAvioes fila =
                maiorFilaPouso();

        if (fila != null && !fila.vazia()) {

            Aviao aviao = fila.remover();

            pista.usarParaPouso(aviao);

            totalPouso(aviao);
        }
    }

    private void decolarNormal() {

        FilaAvioes fila =
                maiorFilaDecolagem();

        if (fila != null && !fila.vazia()) {

            Aviao aviao = fila.remover();

            pista3.usarParaDecolagem(aviao);

            totalDecolagem(aviao);
        }
    }

    private void totalPouso(Aviao aviao) {

        double totalPouso = aviao.getTempoEspera();
        totalPousos++;
    }

    private void totalDecolagem(Aviao aviao) {

        totalTempoDecolagem += aviao.getTempoEspera();
        totalDecolagens++;
    }

    private FilaAvioes menorFilaPouso() {

        FilaAvioes[] filas = {
                filaPouso1,
                filaPouso2,
                filaPouso3,
                filaPouso4
        };

        FilaAvioes menor = filas[0];

        for (FilaAvioes f : filas) {
            if (f.tamanho() < menor.tamanho()) {
                menor = f;
            }
        }

        return menor;
    }

    private FilaAvioes menorFilaDecolagem() {

        FilaAvioes[] filas = {
                filaDecolagem1,
                filaDecolagem2,
                filaDecolagem3
        };

        FilaAvioes menor = filas[0];

        for (FilaAvioes f : filas) {
            if (f.tamanho() < menor.tamanho()) {
                menor = f;
            }
        }

        return menor;
    }

    private FilaAvioes maiorFilaPouso() {

        FilaAvioes[] filas = {
                filaPouso1,
                filaPouso2,
                filaPouso3,
                filaPouso4
        };

        FilaAvioes maior = filas[0];

        for (FilaAvioes f : filas) {
            if (f.tamanho() > maior.tamanho()) {
                maior = f;
            }
        }

        return maior;
    }

    private FilaAvioes maiorFilaDecolagem() {

        FilaAvioes[] filas = {
                filaDecolagem1,
                filaDecolagem2,
                filaDecolagem3
        };

        FilaAvioes maior = filas[0];

        for (FilaAvioes f : filas) {
            if (f.tamanho() > maior.tamanho()) {
                maior = f;
            }
        }

        return maior;
    }

    private FilaAvioes filaComEmergencia() {

        FilaAvioes[] filas = {
                filaPouso1,
                filaPouso2,
                filaPouso3,
                filaPouso4
        };

        for (FilaAvioes f : filas) {

            if (!f.vazia()
                    && f.primeiro()
                    .getCombustivel() <= 0) {

                return f;
            }
        }

        return null;
    }

    private void mostrarFilas() {

        filaPouso1.mostrarFila("Pouso 1");

        System.out.println("\n--- FILAS ---");

        filaPouso1.mostrarFila("Pouso 1");
        filaPouso2.mostrarFila("Pouso 2");
        filaPouso3.mostrarFila("Pouso 3");
        filaPouso4.mostrarFila("Pouso 4");

        filaDecolagem1.mostrarFila("Decolagem 1");
        filaDecolagem2.mostrarFila("Decolagem 2");
        filaDecolagem3.mostrarFila("Decolagem 3");
    }

    private void mostrarEstatisticas() {

        System.out.println("\n--- ESTATÍSTICAS ---");

        if (totalPousos > 0) {
            double totalPouso = 0;
            System.out.println(
                    "Tempo médio pouso: "
                            + (double) totalPouso / totalPousos
            );
        }

        if (totalDecolagens > 0) {
            System.out.println(
                    "Tempo médio decolagem: "
                            + (double) totalTempoDecolagem
                            / totalDecolagens
            );
        }

        System.out.println(
                "Emergências: " + emergencias
        )
    }
}
