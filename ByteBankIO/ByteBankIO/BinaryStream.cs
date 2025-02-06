﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


partial class Program
{
    static void EscritaBinaria()
    {
        using (var fs = new FileStream("contaCorrente.txt", FileMode.Create))
        using (var escritor = new BinaryWriter(fs))
        {
            escritor.Write(456); // n ag
            escritor.Write(4555643); // n acc
            escritor.Write(4536.50); // saldo
            escritor.Write("Marta Assis");
        }
    }

    static void LeituraBinaria()
    {
        using (var fs = new FileStream("contaCorrente.txt", FileMode.Open))
        using (var leitor = new BinaryReader(fs))
        {
            var agencia = leitor.ReadInt32();
            var numeroConta = leitor.ReadInt32();
            var saldo = leitor.ReadDouble();
            var titular = leitor.ReadString();


            Console.WriteLine($"{agencia}//{numeroConta}//{saldo}//{titular}");
        }

    }
}

