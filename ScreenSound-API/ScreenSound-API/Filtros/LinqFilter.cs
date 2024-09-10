using ScreenSound_API.Modelos;

namespace ScreenSound_API.Filtros;

internal class LinqFilter
{

    public static void FiltrarTodosOsGenerosMusicais(List<Musica> musicas)
    {
        var todosOsGenerosMusicais = musicas.Select(generos => generos.Genero).Distinct().ToList();
        foreach (var genero in todosOsGenerosMusicais)
        {
            Console.WriteLine($"- {genero}");
        }
    }

    public static void FiltrarArtistasPorGeneroMusical(List<Musica> musicas, string genero)
    {
        var artistasPorGeneroMusical = musicas.Where(musica => musica.Genero!.Contains(genero)).Select(musica => musica.Artista).Distinct().ToList();
        Console.WriteLine($"Exibindo os artistas por gênero musical >>> {genero}");
        foreach(var artista in artistasPorGeneroMusical)
        {
            Console.WriteLine($"- {artista}");
        }
    }

    public static void FiltrarMusicasDeUmArtista(List<Musica> musicas, string nomeDoArtista)
    {
        var musicasDoArtista = musicas.Where(musica => musica.Artista!.Equals(nomeDoArtista)).ToList();
        Console.WriteLine(nomeDoArtista);
        foreach (var musica in musicasDoArtista)
        {
            Console.WriteLine($"- {musica.Nome}");
        }
    }

    public static void FiltrarMusicasAno(List<Musica> musicas, int anoDaMusica)
    {
        var anoDeLancamento = musicas.Where(musica => musica.Ano!.Equals(anoDaMusica)).OrderBy(musicas => musicas.Nome).Select(musicas => musicas.Nome)
            .Distinct().ToList();
        Console.WriteLine(anoDaMusica);
        foreach (var musica in anoDeLancamento)
        {
            Console.WriteLine($"- {musica}");
        }

    }
    public static void FiltrarKey(List<Musica> musicas, int key)
    {
        var keyCode = musicas.Where(musica => musica.Key.Equals(key))
            .OrderBy(musicas => musicas.Nome)
            .Select(musicas => musicas.Nome)
            .Distinct()
            .ToList();
        Console.WriteLine("Músicas em C#:");
        foreach (var musica in keyCode)
        {
            Console.WriteLine($"-{musica}");
        }
    }
}
