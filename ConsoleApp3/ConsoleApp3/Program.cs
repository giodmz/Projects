Random aleatorio = new Random();
int secretNumber = aleatorio.Next(1, 101);

do
{
    Console.WriteLine("Digite um número entre 1 e 100: ");
    int chute = int.Parse(Console.ReadLine());
    if (chute == secretNumber)
    {
    Console.WriteLine("Você acertou o número!");
    break;
    } else if (chute < secretNumber) {
    Console.WriteLine("O número é maior.");
    } else {
    Console.WriteLine("O número é menor");
    }
} while (true);

Console.WriteLine("O jogo acabou. Você acerrtou o número secreto.");