import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

public class AlunoTest {

    @Test
    public void testAprovacaoComAtividadesESuficientesCreditos() {
        Aluno aluno = new Aluno("João Silva", "123456", "CS101");
        AtividadeComplementar atividade1 = new AtividadeComplementar("formativa", "Descrição da atividade formativa", 120); // 120 horas
        AtividadeComplementar atividade2 = new AtividadeComplementar("extensionista", "Descrição da atividade extensionista", 60); // 60 horas
        aluno.adicionarAtividade(atividade1);
        aluno.adicionarAtividade(atividade2);
        boolean aprovado = aluno.verificarAprovacao();
        assertTrue(aprovado, "O aluno deveria estar aprovado.");

    }

    @Test
    public void testNaoAprovacaoComAtividadesInsuficientes() {
        Aluno aluno = new Aluno("Maria Oliveira", "654321", "CS102");
        AtividadeComplementar atividade = new AtividadeComplementar("monitoria", "Descrição da atividade de monitoria", 40); // 40 horas
        aluno.adicionarAtividade(atividade);
        boolean aprovado = aluno.verificarAprovacao();
        assertFalse(aprovado, "O aluno não deveria estar aprovado.");
    }
}
