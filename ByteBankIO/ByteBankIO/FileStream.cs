﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


    partial class Program
    {
        static void FileStream(string[] args)
        {
            var enderecoDoArquivo = "contas.txt";

            using (var fluxoDoArquivo = new FileStream(enderecoDoArquivo, FileMode.Open))
            {
                var buffer = new byte[1024];
                var numeroDeBytesLidos = -1;
                numeroDeBytesLidos = fluxoDoArquivo.Read(buffer, 0, 1024);

                while (numeroDeBytesLidos != 0)
                {
                    numeroDeBytesLidos = fluxoDoArquivo.Read(buffer, 0, 1024);

                    Console.WriteLine($"Bytes lidos: {numeroDeBytesLidos}");
                    EscreverBuffer(buffer, numeroDeBytesLidos);
                }

                fluxoDoArquivo.Close();
                Console.ReadLine();
            }
        }

        static void EscreverBuffer(byte[] buffer, int bytesLidos)
        {
            var utf8 = new UTF8Encoding();
            var texto = utf8.GetString(buffer, 0, bytesLidos);


            Console.Write(texto);
            //foreach(var meuByte in buffer)
            //{
            //    Console.Write(meuByte);
            //    Console.WriteLine(" ");
            //}
        }

    }

