using ByteBankIO;
using System.Text;

partial class Program
{
    static void Main(string[] args)
    {
        var linhas = File.ReadAllLines("contas.txt");
        Console.WriteLine(linhas.Length);

        //foreach (var line in linhas)
        //{
        //    Console.WriteLine(line);
        //}

        var bytesArq = File.ReadAllBytes("contas.txt");
        Console.WriteLine(bytesArq.Length);

        File.WriteAllText("escrevendoFile.txt", "teste dessa merda File.WriteAllText");

        Console.WriteLine("App finalizado.");
    }

   

}