
/**
 * Classe que representa uma partida de voleibol.
 * Esta classe gerencia as equipes, pontuações e o resultado da partida.
 */
public class PartidaVolei {

    // Atributos 
    private final int MAX_SETS = 5;
    private String[] equipes = new String[2];
    private int[][] pontuacoes = new int[2][MAX_SETS];

    /**
     * Construtor da classe PartidaVolei. Inicializa as equipes e valida seus
     * nomes.
     *
     * @param equipe1 Nome da primeira equipe.
     * @param equipe2 Nome da segunda equipe.
     */
    public PartidaVolei(String equipe1, String equipe2) {
        if (!validaPartida(equipe1, equipe2)) {
            equipe1 = "equipe1";
            equipe2 = "equipe2";
        }
        this.equipes[0] = equipe1;
        this.equipes[1] = equipe2;
    }

    /**
     * Exibe o placar atual da partida.
     *
     * @return String formatada com o placar das equipes.
     */
    public String exibirPlacar() {
        StringBuilder placar = new StringBuilder();
        String pontos = "--";

        placar.append("               1   2   3   4   5  FINAL\n");

        for (int i = 0; i < equipes.length; i++) {
            placar.append(equipes[i]);

            for (int j = 0; j < MAX_SETS; j++) {
                if (pontuacoes[i][j] > 0) {
                    pontos = String.valueOf(pontuacoes[i][j]);
                }
                placar.append("   ").append(pontos);
            }
            placar.append("  ").append(stesVencidos(i)).append("\n");
        }

        return placar.toString();
    }

    /**
     * Registra o placar de um set.
     *
     * @param set O número do set (1 a 5).
     * @param pontosEquipe1 Pontuação da equipe 1 no set.
     * @param pontosEquipe2 Pontuação da equipe 2 no set.
     * @return {@code true} se o placar foi registrado com sucesso,
     * {@code false} caso contrário.
     */
    public boolean registrarPlacarSet(int set, int pontosEquipe1, int pontosEquipe2) {
        if (setsDisputados() < 5) {
            if (set >= 1 && set <= 5) {
                if (pontosEquipe1 > 0 && pontosEquipe2 > 0) {
                    int[] pontos = {pontosEquipe1, pontosEquipe2};
                    for (int i = 0; i < equipes.length; i++) {
                        pontuacoes[i][set - 1] = pontos[i]; // Ajustando o índice para começar do 0
                    }
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    /**
     * Determina o vencedor do jogo.
     *
     * @return Uma string com o nome da equipe vencedora ou indicando que o jogo
     * terminou empatado.
     */
    public String vencedorDoJogo() {
        StringBuilder resultado = new StringBuilder();
        int[] setesVencidos = {stesVencidos(0), stesVencidos(1)}; // Índices 0 e 1 para as equipes
        int vencedor = -1; // Valor inicial indicando nenhum vencedor

        for (int i = 0; i < setesVencidos.length; i++) {
            if (setesVencidos[i] >= 3) {
                vencedor = i;
                break;
            }
        }

        if (vencedor == -1) {
            resultado.append("O jogo terminou empatado.");
        } else {
            resultado.append("A equipe ")
                    .append(equipes[vencedor])
                    .append(" venceu o jogo com ")
                    .append(setesVencidos[vencedor])
                    .append(" sets vencidos.");
        }

        return resultado.toString();
    }

    /**
     * Calcula a pontuação total de uma equipe.
     *
     * @param equipe O nome da equipe.
     * @return A pontuação total da equipe.
     */
    public int pontosTotaisEquipe(String equipe) {
        int pontosTotais = 0;
        for (int i = 0; i < equipes.length; i++) {
            if (equipes[i].toLowerCase().equals(equipe.toLowerCase())) {
                for (int j = 0; j < pontuacoes[i].length; j++) {
                    pontosTotais += pontuacoes[i][j];
                }
                break;
            }
        }
        return pontosTotais;
    }

    /**
     * Calcula o número total de sets disputados na partida.
     *
     * @return O número de sets disputados.
     */
    private int setsDisputados() {

        int totalsetsDisputados = 0;
        for (int i = 0; i < pontuacoes[0].length; i++) {
            if (pontuacoes[0][i] > 0 || pontuacoes[1][i] > 0) {
                totalsetsDisputados++;
            }
        }
        return totalsetsDisputados;
    }

    /**
     * Calcula o número de sets vencidos por uma equipe.
     *
     * @param time O índice da equipe (0 ou 1).
     * @return O número de sets vencidos pela equipe.
     */
    private int stesVencidos(int time) {
        int totalSetesVencidos = 0;
        int adversario = 0;
        if (time == 0) {
            adversario = 1;
        }
        for (int j = 0; j < MAX_SETS; j++) {
            if (pontuacoes[time][j] > pontuacoes[adversario][j]) {
                if ((j == 4 && pontuacoes[time][j] >= 15) || (j < 4 && pontuacoes[time][j] >= 25 && Math.abs(pontuacoes[time][j] - pontuacoes[adversario][j]) >= 2)) { // Sets anteriores, mínimo de 25 pontos com diferença de 2
                    totalSetesVencidos++;
                }
            }
        }

        return totalSetesVencidos;
    }

    /**
     * Valida se os nomes das equipes são diferentes e não estão vazios.
     *
     * @param equipe1 Nome da primeira equipe.
     * @param equipe2 Nome da segunda equipe.
     * @return {@code true} se os nomes são válidos, {@code false} caso
     * contrário.
     */
    private boolean validaPartida(String equipe1, String equipe2) {
        if (equipe1.toLowerCase().equals(equipe2.toLowerCase()) && (equipe1.length() == 0) && (equipe2.length() == 0)) {
            return false;
        }
        return true;
    }
}
