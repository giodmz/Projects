class Program
{
    static void Main(string[] args)
    {
        Console.Clear();

        var arr = new int[3];

        try
        {
            //for (var index = 0; index < 10; index++)
            //{
            //    Console.WriteLine(arr[index]);
            //}

            Cadastrar("PORRA GAMES");
        }
        catch(IndexOutOfRangeException ex)
        {
            Console.WriteLine(ex.InnerException);
            Console.WriteLine(ex.Message);
            Console.WriteLine("O índice não foi encontrado na lista.");
        }

        catch (ArgumentNullException ex)
        {
            Console.WriteLine(ex.InnerException);
            Console.WriteLine(ex.Message);
            Console.WriteLine("Falha ao cadastrar texto.");
        }
        catch (MinhaException ex)
        {
            Console.WriteLine(ex.InnerException);
            Console.WriteLine(ex.Message);
            Console.WriteLine(ex.QuandoAconteceu);
            Console.WriteLine("Exception customizada.");
        }


        catch (Exception ex)
        {
            Console.WriteLine(ex.InnerException);
            Console.WriteLine(ex.Message);
            Console.WriteLine("Ops, algo deu errado!");
        }
        
        finally
        {
            Console.WriteLine("Chegou ao fim! 8=D");
        }

    }

    private static void Cadastrar(string texto)
    {
        if (string.IsNullOrEmpty(texto))
        {
            throw new MinhaException(DateTime.Now);
        }
    }

    public class MinhaException : Exception 
    {
        public MinhaException(DateTime date)
        {
            QuandoAconteceu = date;
        }
        public  DateTime QuandoAconteceu { get; set; }
    }


}