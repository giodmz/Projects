package application;
import java.util.Locale;
import java.util.Scanner;

import entities.Aluguel;
import entities.Aluno;
import entities.NumberVector;
import entities.Pessoas;

public class App {
    public static void main(String[] args) throws Exception {
    
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("\nQual opção deseja consultar? ");
        System.out.println("1 - Negativos");
        System.out.println("2 - Media Vetores");
        System.out.println("3 - Alturas");
        System.out.println("4 - Pensionato");
        System.out.println("5 - Números pares");
        System.out.println("6 - Aprovados");
        System.out.println("7 - Soma de vetores");
        int input = sc.nextInt();
        switch (input) {
            case 1:
                Negativos();
                break;
            case 2:
                MediaVetores();
                break;
            case 3:
                Alturas();
                break;
            case 4:
                Pensionato();
                break;
            case 5:
                NumerosPares();
                break;
            case 6:
                Aprovados();
            case 7:
                SomaVetores();
                break;

            default: System.out.println("Tente um número válido");

        }
        
        
        sc.close();
    }


    public static void Negativos(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Quantos números você vai digitar ?");
        int input = sc.nextInt();
        NumberVector[] vect = new NumberVector[input];

        for (int i = 0; i < vect.length; i++) {
            int value = sc.nextInt();
            vect[i] = new NumberVector(value);
        }

        
        System.out.println("\nNúmeros negativos: ");
        for (int i = 0; i < vect.length; i++) {
           int negatives = vect[i].getValue();
           if (negatives < 0) {
            System.out.println(negatives);
           }
        }

        sc.close();

    }

    public static void MediaVetores(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Quantos números você vai digitar? ");
        int input = sc.nextInt();
        NumberVector[] vect = new NumberVector[input];

        for (int i = 0; i < vect.length; i++) {
            System.out.println("Digite um número: ");
            double valueDb = sc.nextDouble();
            vect[i] = new NumberVector(valueDb);
        }

        double sum = 0.0;
        for (int i = 0; i < vect.length; i++) {
            sum += vect[i].getValueDb();
        }

        double avg = sum / vect.length;


        System.out.println("\nVALORES: ");

        for (int i = 0; i < vect.length; i++) {
            System.out.printf("%.1f  ", vect[i].getValueDb());            
        }
        System.out.printf("\nSOMA: %.2f%n", sum);
        System.out.printf("MÉDIA: %.2f%n", avg);

        sc.close();
    }

    public static void Alturas(){

        Scanner sc = new Scanner(System.in);

        System.out.println("\nQuantas pessoas serão digitadas? ");
        int input = sc.nextInt();
        Pessoas[] pessoas = new Pessoas[input];

        for (int i = 0; i < pessoas.length; i++) {
            System.out.println("\nDados da " + (i + 1) +"a pessoa");
            System.out.print("Nome: ");
            String nome = sc.next();
            System.out.print("Idade: ");
            int idade = sc.nextInt();
            System.out.print("Altura: ");
            double altura = sc.nextDouble();
            pessoas[i] = new Pessoas(nome, idade, altura);
        }

        double sum = 0.0;
        for (int i = 0; i < pessoas.length; i++) {
            sum += pessoas[i].getAltura();
        }
        double avg = sum / pessoas.length;

        System.out.println("Informações: ");
        System.out.printf("\nAltura média: %.2f%n", avg);

        int idadePessoas = 0;
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i].getIdade() < 16){
                idadePessoas++;
            }
        }

        double percentualMenores = ((double)idadePessoas / pessoas.length) * 100;
        System.out.printf("Pessoas com menos de 16 anos: %.1f%%\n", percentualMenores);

        for (int i = 0; i < pessoas.length; i++) {
            if(pessoas[i].getIdade() < 16) {
                System.out.println("- " + pessoas[i].getNome());
            }
        }


        sc.close();

    }

    public static void Pensionato(){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Quantos estudantes vão alugar os quartos? ");
        int input = sc.nextInt();

        Aluguel[] aluguel = new Aluguel[10];

        for (int i = 0; i < input; i++) {
            System.out.println("\nEstudante #" + (i + 1) + ":");
            System.out.println("Digite seu nome: ");
            String nome = sc.next();
            System.out.println("Digite seu e-mail: ");
            sc.next();
            String email = sc.next();
            System.out.println("Digite qual quarto deseja alugar (1 a 10)");
            int numeroQuarto = sc.nextInt();
            // atribui o objeto para a opção 'numeroQuarto'
            aluguel[numeroQuarto] = new Aluguel(nome, email);
        }

        System.out.println();
        System.out.println("Quartos ocupados: ");
        for (int i = 0; i < 10; i++) {
            if (aluguel[i] != null) {
                System.out.println(i + ": " + aluguel[i]);
            }
        }
        

        sc.close();
    }

    public static void NumerosPares(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Quantos números você vai digitar? ");
        int input = sc.nextInt();
        NumberVector[] vect = new NumberVector[input];

        for (int i = 0; i < vect.length; i++) {
            System.out.println("Digite um número: ");
            int value = sc.nextInt();
            vect[i] = new NumberVector(value);
        }

        int pares = 0;
        System.out.println("\nNúmeros pares: ");

        for (int i = 0; i < vect.length; i++) {
            int value = vect[i].getValue();  
        
            if (value %2 == 0) {
                System.out.printf("%d  ", value);
                pares++;
            }
        }
        
        System.out.println("\nQuantidade de pares: ");
        System.out.printf("%d", pares);

        sc.close();
    }

    public static void Aprovados(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Quanto alunos serão avaliados? ");
        int input = sc.nextInt();
        Aluno[] aluno = new Aluno[input];
        
        for (int i = 0; i < aluno.length; i++) {
            System.out.println("\nDigite o nome, primeira e segunda nota do aluno: ");
            sc.nextLine();
            String nome = sc.nextLine();
            double nota1 = sc.nextDouble();
            double nota2 = sc.nextDouble();
            double nota = (nota1 + nota2) / 2;
            aluno[i] = new Aluno(nome, nota);
            System.out.println(aluno[i].toString());
        }

        System.out.println("\nAlunos aprovados: ");
        for (int i = 0; i < aluno.length; i++) {
            String nome = aluno[i].getNome();
            if (aluno[i].getNota() >= 6.0){
                System.out.println(nome);
            } 
        }
        

        sc.close();

    }

    public static void SomaVetores(){
        Scanner sc = new Scanner(System.in);
        
        int input;

        System.out.println("Quantos valores cada vetor terá? ");
        input = sc.nextInt();
        
        int[] a = new int[input];
        int[] b = new int[input];
        int[] c = new int[input];
        
        
        System.out.println("Digite os valores do vetor A: ");
        for (int i = 0; i < input; i++) {
            a[i] = sc.nextInt(); 
        }
        
        
        System.out.println("Digite os valores do vetor B: ");
        for (int i = 0; i < input; i++) {
            b[i] = sc.nextInt(); 
        }

        
        System.out.println("Digite os valores do vetor A: ");
        for (int i = 0; i < input; i++) {
            c[i] = a[i] + b[i]; 
        }

        System.out.println("Vetor resultante: ");

        for (int i = 0; i < input; i++) {
            System.out.printf("%d\n", c[i]);
        }
        

        
        sc.close();
    }

}
