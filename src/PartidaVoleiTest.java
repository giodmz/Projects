
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PartidaVoleiTest {

    private PartidaVolei partida;

    @BeforeEach
    public void setUp() {
        partida = new PartidaVolei("Equipe A", "Equipe B");
    }

    @Test
    public void testExibirPlacarInicial() {
        String placarEsperado = "               1   2   3   4   5  FINAL\n"
                + "Equipe A   --   --   --   --   --  0\n"
                + "Equipe B   --   --   --   --   --  0\n";
        assertEquals(placarEsperado, partida.exibirPlacar());
    }

    @Test
    public void testRegistrarPlacarSet() {
        boolean resultado = partida.registrarPlacarSet(1, 25, 20);
        assertTrue(resultado);
    }

    @Test
    public void testRegistrarPlacarSetInvalido() {
        boolean resultado = partida.registrarPlacarSet(6, 25, 20);
        assertFalse(resultado);
    }

    @Test
    public void testVencedorDoJogo() {
        partida.registrarPlacarSet(1, 25, 20);
        partida.registrarPlacarSet(2, 25, 23);
        partida.registrarPlacarSet(3, 25, 19);
        String vencedorEsperado = "A equipe Equipe A venceu o jogo com 3 sets vencidos.";
        assertEquals(vencedorEsperado, partida.vencedorDoJogo());
    }

    @Test
    public void testPontuacaoTotalEquipe() {
        partida.registrarPlacarSet(1, 25, 20);
        partida.registrarPlacarSet(2, 25, 23);
        assertEquals(50, partida.pontosTotaisEquipe("Equipe A"));
        assertEquals(43, partida.pontosTotaisEquipe("Equipe B"));
    }
}
