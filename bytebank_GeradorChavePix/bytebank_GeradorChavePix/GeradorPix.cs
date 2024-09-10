using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace bytebank_GeradorChavePix
{
    /// <summary>
    ///  Pix usando Guid.
    /// </summary>

    public static class GeradorPix
    {

        /// <summary>
        /// Método chave PIX
        /// </summary>
        /// <returns>Retorna uma chave aleatória de PIX</returns>
        public static string GetChavePix()
        {
            return Guid.NewGuid().ToString();
        }

        /// <summary>
        /// Método que retorna uma lista aleatória de chaves PIX
        /// </summary>
        /// <param name="numeroChaves">Quantidade de chaves que serão geradas</param>
        /// <returns>Retorna um List<string> de chaves pix</returns>
        public static List<string> GetChavesPix(int numeroChaves)
        {
            if (numeroChaves <= 0)
            {
                return null;
            }
            else
            {
                var chaves = new List<string>();
                for (int i = 0; i < numeroChaves; i++)
                {
                    chaves.Add(Guid.NewGuid().ToString());
                }
                return chaves;

            }


        }
    }
}
