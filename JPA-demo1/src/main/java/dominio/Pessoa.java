package dominio;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;




// Indica que a classe é um entidade que corresponde a uma tabela
@Entity
public class Pessoa implements Serializable {

    // mapeamento para indicar que a chave vai ser gerada automaticamente pelo banco de dados
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    // muda o campo que vai ser gerada na tabela, já que por padrão ela é gerada com o mesmo nome, no caso: "nome"
    // @Column(name="nomecompleto")
    private String nome;
    private String email;

    public Pessoa(){

    }

    public Pessoa(Integer id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa [id=" + id + ", nome=" + nome + ", email=" + email + "]";
    }

    

    

}
