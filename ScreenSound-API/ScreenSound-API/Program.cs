using ScreenSound_API.Modelos;
using System.Text.Json;
using ScreenSound_API.Filtros;


using (HttpClient client = new HttpClient())
{
    try 
    {
        string resposta = await client.GetStringAsync("https://guilhermeonrails.github.io/api-csharp-songs/songs.json");
        var musicas = JsonSerializer.Deserialize<List<Musica>>(resposta)!;
        //musicas[1].ExibirDetalhesDaMusica();
        //LinqFilter.FiltrarTodosOsGenerosMusicais(musicas);
        //LinqOrder.ExibirListaDeArtistasOrdenados(musicas);
        //LinqFilter.FiltrarArtistasPorGeneroMusical(musicas, "pop");
        //LinqFilter.FiltrarMusicasDeUmArtista(musicas, "U2");
        LinqFilter.FiltrarMusicasAno(musicas, 2014);
        //LinqFilter.FiltrarKey(musicas, 1);


        //var musicasPreferidasDoCelin = new MusicasPreferidas("Celin");
        //musicasPreferidasDoCelin.AdicionarMusicasFavoritas(musicas[1]);
        //musicasPreferidasDoCelin.AdicionarMusicasFavoritas(musicas[377]);
        //musicasPreferidasDoCelin.AdicionarMusicasFavoritas(musicas[4]);
        //musicasPreferidasDoCelin.AdicionarMusicasFavoritas(musicas[6]);
        //musicasPreferidasDoCelin.AdicionarMusicasFavoritas(musicas[1467]);

        //musicasPreferidasDoCelin.ExibirMusicasFavoritas();

        //var musicasPreferidasDoGut = new MusicasPreferidas("Gugut");
        //musicasPreferidasDoGut.AdicionarMusicasFavoritas(musicas[500]);
        //musicasPreferidasDoGut.AdicionarMusicasFavoritas(musicas[666]);
        //musicasPreferidasDoGut.AdicionarMusicasFavoritas(musicas[14]);
        //musicasPreferidasDoGut.AdicionarMusicasFavoritas(musicas[69]);
        //musicasPreferidasDoGut.AdicionarMusicasFavoritas(musicas[111]);

        //musicasPreferidasDoGut.ExibirMusicasFavoritas();

        //musicasPreferidasDoGut.GerarArquivoJson();
    }
    catch (Exception ex)
    {
        Console.WriteLine($"Temos um problema: {ex.Message}");
    }
}