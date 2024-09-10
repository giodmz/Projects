
public class Aluno {

    private String nome;
    private AtividadeComplementar[] atividades;
    private String matricula;
    private String codigoCurso;
    private double creditos;
    private int atividadesFeitas;
    private static final double CREDITO_PARA_APROVACAO = 4.0;
    private static final int ATIVIDADE_PARA_APROVACAO = 2;


    public Aluno(String nome, String matricula, String codigoCurso) {
       this.nome = nome;
       creditos = 0; // inicia com 0
       atividadesFeitas = 0;
       atividades = new AtividadeComplementar[100];
    }


    public int confereQuantasAtividades(){
        return atividadesFeitas;
    }

    public void adicionarAtividade(AtividadeComplementar atividade){
        if (atividadesFeitas < atividades.length) {
            atividades[atividadesFeitas] = atividade;
            creditos += atividade.calcularCreditos();
            atividadesFeitas++;
        }
    }

    public boolean verificaAtividade(){
        return confereQuantasAtividades() >= ATIVIDADE_PARA_APROVACAO;
    }

    public boolean verificarCreditos(){
        return creditos >= CREDITO_PARA_APROVACAO;
           
    }

    public boolean verificarAprovacao(){
        return verificaAtividade() && verificarCreditos();
     
    }

   
}

    




   
    

