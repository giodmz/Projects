using System;
using System.Text;

partial class Program
{
	static void CriarArquivo()
	{
		var caminhoNovoArquivo = "contasExportadas.";

		using (var fluxoDeArquivo = new FileStream(caminhoNovoArquivo, FileMode.Create))
		{
			var contaString = "456, 7895, 4785.40, Gustavo Santos";
			var enconding = Encoding.UTF8;
			var bytes = enconding.GetBytes(contaString);

			fluxoDeArquivo.Write(bytes, 0, bytes.Length);

		}

	}

	static void CriarArquivoComWriter()
	{
		var caminhoNovoArquivo = "contasExportadas.txt";
		using(var fluxoDeArquivo = new FileStream(caminhoNovoArquivo, FileMode.Create))
		using(var escritor = new StreamWriter(fluxoDeArquivo))
		{
			escritor.Write("456,65464,432.0,Fodase");
		}
	}

	static void TestaEscrita()
	{
        var caminhoNovoArquivo = "teste.txt";

        using (var fluxoDeArquivo = new FileStream(caminhoNovoArquivo, FileMode.Create))
        using (var escritor = new StreamWriter(fluxoDeArquivo))
		{
			for (int i = 0; i < 1000000; i++)
			{
				escritor.WriteLine($"Linha {i}");
				escritor.Flush(); // acela o buffer para o stream
				Console.WriteLine($"Linha {i} foi escrita no arquivo. Tecle enter...");
				Console.ReadLine();

			}

		}
    }


}
