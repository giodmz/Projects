using System.Text.Json.Serialization;

namespace try03
{
    internal class Personagem
    {
        [JsonPropertyName("mother")]
        public string? Nome { get; set; }
        public void ExibirPersonagem()
        {
            Console.WriteLine($"Personagem: {Nome}");
        }
    }
}
