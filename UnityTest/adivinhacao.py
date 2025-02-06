import random

def jogar():

    print("*********************************")
    print("Bem vindo no jogo de adivinhação!")
    print("*********************************")

    secret_number = random.randrange(1, 101) # 0.0 1.0
    total_de_tentativas = 0
    pontos = 1000

    print("Qual nível de dificuldade?", secret_number)
    print("(1) Fácil (2) Médio (3) Difícil")

    nivel = int(input("Defina o nível: "))

    if(nivel == 1):
        total_de_tentativas = 20
    elif(nivel == 2):
        total_de_tentativas = 10
    else:
        total_de_tentativas = 5

    for rodada in range(1, total_de_tentativas + 1):
        print("Tentativa {} de {}".format(rodada, total_de_tentativas))
        chute_str = input("Digite um número entre 1 e 100: ")
        print("Você digitou", chute_str)
        chute = int(chute_str)

        if(chute < 1 or chute > 100):
            print("Você deve digitar um número entre 1 e 100")
            continue

        acertou = chute == secret_number
        maior = chute > secret_number
        menor = chute < secret_number

        if(acertou):
            print("Você acertou e fez {} pontos!".format(pontos))
            break
        else:
            if(maior):
                print("Você errou! O seu chute foi maior do que o número secreto.")
            elif(menor):
                print("Você errou! O seu chute foi menor do que o número secreto.")
            pontos_perdidos = abs(secret_number - chute)
            pontos = pontos - pontos_perdidos

    print("Fim de jogo.")

if(__name__ == "__main__"):
    jogar()