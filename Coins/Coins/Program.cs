using System.Globalization;

class Program
{
    static void Main(string[] args)
    {
        Console.Clear();

        // N, P, C -> MAIS IMPORTANTES

        decimal valor = 10.25m;
        //Console.WriteLine(valor.ToString("C", CultureInfo.CreateSpecificCulture("pt-BR")));

        // Round = arredondar
        // Ceiling = telhado (arredonda pra cima)
        // Floor = chão (arredeonda pra baixo)
        Console.WriteLine(Math.Round(valor));
        Console.WriteLine(Math.Ceiling(valor));
        Console.WriteLine(Math.Floor(valor));
    }
}