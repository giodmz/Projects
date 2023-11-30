using try03;
using System.Text.Json;

using (HttpClient client = new HttpClient())
{
    try
    {
        string nome = await client.GetStringAsync("https://www.anapioficeandfire.com/api/characters/16\r\n");
        var personagem = JsonSerializer.Deserialize<List<Personagem>>(nome)!;
        Console.WriteLine(nome);
        personagem[1].ExibirPersonagem();
    }
    catch (Exception ex)
    {
        Console.WriteLine($"Ocorreu um problema inesperado: {ex.Message}");
    }
}