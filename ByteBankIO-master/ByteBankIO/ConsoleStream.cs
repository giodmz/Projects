using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

partial class Program
{
  static void ConsoleStream()
    {
        using (var fluxoDeEntrada = Console.OpenStandardInput())
        using (var fs = new FileStream("Console.txt", FileMode.Create))
        {
            var buffer = new byte[1024];

            while (true)
            {
                var bytesLidos = fluxoDeEntrada.Read(buffer, 0, 1024);
                fs.Write(buffer, 0, bytesLidos);
                fs.Flush();
                
                Console.WriteLine($"Bytes lidos no console: {bytesLidos}");

            }

        }
    }
    
}

