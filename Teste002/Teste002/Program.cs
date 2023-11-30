
using System.Text;

class Program
{
    static void Main(string[] args)
    {
        var id = Guid.NewGuid();
        id.ToString();

        id = new Guid("79699b12-91ab-4752-87a2-b59558599e04");
        //Console.WriteLine(id.ToString().Substring(0, 8));

        //var texto = " Este texto é um teste ";
        var price = 10.2;
        //var texto = "O preço do produto é " + price + " apenas na promoção.";
        //var texto = string.Format("O preço do produto é {0} apenas na promoção", price);
        //var texto = $@"O preço do [\n] produto é {price} apenas na promoção";

        //Console.WriteLine(texto.StartsWith("Este"));
        //Console.WriteLine(texto.StartsWith("este", StringComparison.OrdinalIgnoreCase));
        //Console.WriteLine(texto.StartsWith("texto"));
        ////Console.WriteLine(texto.Contains(null));

        //Console.WriteLine(texto.EndsWith("teste"));
        //Console.WriteLine(texto.EndsWith("teste"));
        //Console.WriteLine(texto.EndsWith("fodase"));

        //Console.WriteLine(texto.Equals("Este texto é um teste")); // tem que ser exatamente igual para usar Equals
        //Console.WriteLine(texto.IndexOf("é"));
        //Console.WriteLine(texto.LastIndexOf("s"));

        //Console.WriteLine(texto.ToLower());
        //Console.WriteLine(texto.ToUpper());
        //Console.WriteLine(texto.ToUpper().Insert(5, " AQUI "));
        //Console.WriteLine(texto.ToUpper().Remove(5, 5));
        //Console.WriteLine(texto.Length);

        //Console.WriteLine(texto.Replace("Este", "Esse"));
        //Console.WriteLine(texto.Replace("e", "X", StringComparison.OrdinalIgnoreCase));

        //var divisao = texto.Split(" "); // split = divisão
        //Console.WriteLine(divisao[0]);
        //Console.WriteLine(divisao[1]);
        //Console.WriteLine(divisao[2]);
        //Console.WriteLine(divisao[3]);
        //Console.WriteLine(divisao[4]);

        //var resultado = texto.Substring(5, 5);
        //Console.WriteLine(resultado);

        //Console.WriteLine(texto.Trim());

        var texto = new StringBuilder();
        texto.Append("Este texto é um teste");
        texto.Append("é um teste");
        texto.Append("Este texto");
        texto.Append("Este um teste");

        texto.ToString();
        Console.WriteLine(texto);
       
    }
}