class Program
{
    static void Main(string[] args)
    {
        Menu();
    }

    static void Menu()
    {
        Console.Clear();
        Console.WriteLine("O que deseja fazer?");
        Console.WriteLine("1 - Soma");
        Console.WriteLine("2 - Subtração");
        Console.WriteLine("3 - Multiplicação");
        Console.WriteLine("4 - Divisão");
        Console.WriteLine("5 - Peça");
        Console.WriteLine("0 - Sair");
        Console.WriteLine("---------------------");
        Console.WriteLine("Selecione uma opção: ");
        short result = short.Parse(Console.ReadLine());

        switch (result)
        {
            case 1: Soma(); 
                break;
            case 2: Subtracao(); 
                break;
            case 3: Multiplicacao();
                break;
            case 4: Divisao(); 
                break;
            case 5: Peca();
                break;
            case 0: System.Environment.Exit(0);
                break;
            default: Menu();
                break;
        }
    }

    static void Soma()
    {
        Console.Clear();

        Console.WriteLine("Primeiro valor:");
        float v1 = float.Parse(Console.ReadLine());

        Console.WriteLine("Segundo valor:");
        float v2 = float.Parse(Console.ReadLine());

        Console.WriteLine("");

        float resultado = v1 + v2;
        Console.WriteLine($"O resultado da soma é: {resultado}");
    }

    static void Subtracao()
    {
        Console.Clear();

        Console.WriteLine("Primeiro valor:");
        float v1 = float.Parse(Console.ReadLine());

        Console.WriteLine("Segundo valor:");
        float v2 = float.Parse(Console.ReadLine());

        Console.WriteLine("");

        float resultado = v1 - v2;
        Console.WriteLine($"O resultado da subtração é: {resultado}");
    }

    static void Divisao()
    {
        Console.Clear();

        Console.WriteLine("Primeiro valor:");
        float v1 = float.Parse(Console.ReadLine());

        Console.WriteLine("Segundo valor:");
        float v2 = float.Parse(Console.ReadLine());

        Console.WriteLine("");

        float resultado = v1 / v2;
        Console.WriteLine($"O resultado da divisão é: {resultado}");
    }

    static void Multiplicacao()
    {
        Console.Clear();

        Console.WriteLine("Primeiro valor:");
        float v1 = float.Parse(Console.ReadLine());

        Console.WriteLine("Segundo valor:");
        float v2 = float.Parse(Console.ReadLine());

        Console.WriteLine("");

        float resultado = v1 * v2;
        Console.WriteLine($"O resultado da multiplicação é: {resultado}");
    }

    static void Peca()
    {
        Random randNum = new Random();
        int valorInt = randNum.Next(1, 40);

        Console.WriteLine($"Sua peça tem {valorInt} cm!");
        if (valorInt < 12)
        {
            Console.WriteLine("Que pena, sua peça é pequena");
        }
        else
        {
            Console.WriteLine("Parabéns! Você tem uma bela peça!");
        }

    }
}