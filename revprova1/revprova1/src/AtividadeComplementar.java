public class AtividadeComplementar{

    private String atividade;
    private String descricao;
    private double cargaHoraria;


    public AtividadeComplementar(String atividade, String descricao, double cargaHoraria) {
        this.atividade = atividade;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
    }

        public double calcularCreditos() {
            switch (this.atividade) {
                case "formativa":
                    return this.cargaHoraria / 30;
                case "extensionista":
                    return this.cargaHoraria / 15;
                case "monitoria":
                    return this.cargaHoraria / 20;
                    
                default:
                throw new IllegalArgumentException("Tipo de atividade inválido: " + this.atividade);
            }
        }
    }
  

    

