class Program
{
    static void Main(string[] args)
    {
        ds13();

    }

    static void ds1()
    {
        Console.WriteLine("Olá Mundo!");
    }

    static void ds2()
    {
        Console.WriteLine("Qual é o seu nome?");

        var nome = Console.ReadLine();

        Console.WriteLine($"Olá {nome}, é um prazer the conhecer");

    }

    static void ds3()
    {
        var funcionario = "Maria";
        var sale = 1850.25;
        Console.WriteLine($"O funcionario(a) {funcionario} tem um salário de {sale} em Junho");
    }

    static void ds4()
    {
        Console.WriteLine("Digite 2 números que deseja somar:");
        
        float n1 = float.Parse(Console.ReadLine());
        float n2 = float.Parse(Console.ReadLine());
        float n3 = n1 + n2;

        Console.WriteLine(n3);
    }

    static void ds5()
    {
        double nota1 = 4.5;
        double nota2 = 8.5;
        double media = (nota1 + nota2) / 2;
        Console.WriteLine($"A média da nota é {media}");
    }

    static void ds6()
    {
        Console.Clear();
        Console.WriteLine("Digite um número: ");
        float n1 = float.Parse(Console.ReadLine());
        Console.WriteLine($"O antecessor de {n1} é {n1 - 1}");
        Console.WriteLine($"O sucessor de {n1} é {n1 + 1}");
    }

    static void ds7() 
    {
        Console.Clear();
        Console.WriteLine("Digite um número: ");
        double n1 = double.Parse(Console.ReadLine());
        Console.WriteLine($"O dobro de {n1} é {n1 * 2}");
        Console.WriteLine($"A terça parte de {n1} é {n1 / 3}");
    }

    static void ds8()
    {
        Console.Clear();
        Console.WriteLine("Digite uma distância em metros: ");
        double n1 = double.Parse(Console.ReadLine());
        Console.WriteLine($"A distância de {n1} corresponde a:");
        Console.WriteLine($"{n1 / 1000}Km");
        Console.WriteLine($"{n1 / 100}Hm");
        Console.WriteLine($"{n1 / 10}Dam");
        Console.WriteLine($"{n1 * 100}dm");
        Console.WriteLine($"{n1 * 1000}cm");
        Console.WriteLine($"{n1 * 10000}mm");
    }
    static void ds9()
    {
        Console.Clear();
        Console.WriteLine("Quanto você possui em sua carteira? (reais)");
        double real = double.Parse(Console.ReadLine());
        double dollar = 3.45;
        double result = real / dollar;
            
        Console.WriteLine($"Você tem {real}R$");
        Console.WriteLine($"Então você pode comprar {Math.Round(result)}US$");

    }

    static void ds10() 
    {
        Console.Clear();
        Console.WriteLine("Largura: ");
        float largura = float.Parse(Console.ReadLine());

        Console.WriteLine("Altura: ");
        float altura = float.Parse(Console.ReadLine());

        float area = altura * largura;

        float tinta = area / 2;

        Console.Clear();
        Console.WriteLine($"A parede possui a área da parede é {area}m, então serão necessários {tinta}L de tinta para pinta-lá por completo.");
    }

    static void ds11()
    {
        Console.Clear();
        Console.WriteLine("Digite o valor de A: ");
        double A = double.Parse(Console.ReadLine());
        Console.WriteLine("Digite o valor de B: ");
        double B = double.Parse(Console.ReadLine());
        Console.WriteLine("Digite o valor de C: ");
        double C = double.Parse(Console.ReadLine());
        double result = A + B * C;
        Console.WriteLine($"O valor de delta é {Math.Pow(result, 2)}");
        Console.WriteLine("");
        Console.WriteLine("OBS: delta = A² + (B x C)");
    }

    static void ds12()
    {
        Console.Clear();
        Console.WriteLine("Digite o nome do produto que deseja obter um desconto de 5%: ");
        var produto = Console.ReadLine();
        if (produto == "Banana")
        {
            Console.WriteLine("Digite o preço do produto: ");
            double preco = double.Parse(Console.ReadLine());
            double desconto = 95 * preco / 100;
            Console.WriteLine($"O preço do produto com desconto é de {desconto}");
        }   else
        {
            Console.WriteLine("Produto não encontrado no estoque.");
        }
        
    }

    static void ds13()
    {
        Console.Clear();
        Console.WriteLine("Digite seu salário atual: ");
        double salario = double.Parse(Console.ReadLine());
        double salarioAumento = 15 * salario / 100 + salario;
        Console.WriteLine($"Você recebeu um aumento e agora seu salário é de: {salarioAumento}");
    }
}