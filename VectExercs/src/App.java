import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
    
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("\nQual opção deseja consultar? ");
        System.out.println("1 - Negativos");
        System.out.println("2 - Media Vetores");
        System.out.println("3 - Alturas");
        System.out.println("4 - Pensionato");
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
            System.out.println("\nNome: ");
            String nome = sc.next();
            System.out.println("\nIdade: ");
            int idade = sc.nextInt();
            System.out.println("\nAltura: ");
            double altura = sc.nextDouble();
            pessoas[i] = new Pessoas(nome, idade, altura);
        }

        double sum = 0.0;
        for (int i = 0; i < pessoas.length; i++) {
            sum += pessoas[i].getAltura();
        }
        double avg = sum / pessoas.length;

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
                System.out.println(pessoas[i].getNome());
            }
        }


        sc.close();

    }

    public static void Pensionato(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Quantos estudantes vão alugar os quartos? ");
        int[] quartos = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int input = sc.nextInt();

        Aluguel[] aluguel = new Aluguel[input];

        for (int i = 0; i < aluguel.length; i++) {
            System.out.println("Digite seu nome: ");
            String nome = sc.next();
            System.out.println("Digite seu e-mail: ");
            String email = sc.next();
            System.out.println("Digite qual quarto deseja alugar (1 a 10)");
            quartos[i] = sc.nextInt();
            aluguel[i] = new Aluguel(nome, email, quartos);
            System.out.println(aluguel[i].toString());
        }
        

        sc.close();
    }

}
