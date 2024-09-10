import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AtividadeComplementarTest {

    @Test
    void testCalcularCreditosMonitoria() {
        AtividadeComplementar atividade = new AtividadeComplementar("monitoria", "Monitoria de Algoritmos", 40);
        assertEquals(2.0, atividade.calcularCreditos(), "O cálculo de créditos para atividade de monitoria deve ser 2.0");
    }

    @Test
    void testCalcularCreditosTipoInvalido() {
        AtividadeComplementar atividade = new AtividadeComplementar("invalido", "Atividade Inválida", 30);
        assertThrows(IllegalArgumentException.class, atividade::calcularCreditos, "Deveria lançar IllegalArgumentException para tipo de atividade inválido");
    }

    
}
