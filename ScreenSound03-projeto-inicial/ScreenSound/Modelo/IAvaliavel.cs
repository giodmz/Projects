using ScreenSound.Modelos;

namespace ScreenSound.Modelo
{
    internal interface IAvaliavel
    {
        void AdicionarNota(Avaliacao nota);
        double Media { get; }
    }
}
