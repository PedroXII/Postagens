class Player:
    def __init__(self, icon):
        self.icon = str(icon)


def tabuleiro(vez):
    print("vez do: ", vez, "\n\n ", casas[0], " | ", casas[1], " | ", casas[2], "\n------------------------\n ",
          casas[3], " | ", casas[4], " | ", casas[5], " \n------------------------\n ", casas[6], " | ", casas[7],
          " | ", casas[8], " \n\nDigite as coordenadas de uma casa que não foi preenchida e pressione [Enter]: ")


def sair(comando):
    comando = comando.upper()
    if comando == "SAIR":
        exit()


def menu():
    iniciar = input(
        "# JOGO DA VELHA #\n\nPressione [Enter] - Você pode sair a qualquer instante digitando 'Sair' e pressionando [Enter].")
    sair(iniciar)
    modo_de_jogo = ""
    while (modo_de_jogo != "1") and (modo_de_jogo != "2"):
        modo_de_jogo = input(
            "Modo de jogo\n\n1 - Jogador vs Computador\n2 - Jogador vs Jogador\n\nPressione o número do modo de jogo desejado e [Enter]:\n")
        sair(modo_de_jogo)
        if (modo_de_jogo != "1") and (modo_de_jogo != "2"):
            confirmacao = input(
                "Comando inválido!\n\nPor favor, digite o número do modo de jogo desejado, que é o número que aparece antes do nome do modo de jogo no menu de seleção, e depois pressione [Enter].\n\nPRESSIONE [ENTER] PARA PROSSEGUIR.")
            sair(confirmacao)
    if modo_de_jogo == "1":
        return modo_de_jogo
    elif modo_de_jogo == "2":
        return modo_de_jogo


casas = ["A1", "A2", "A3", "B1", "B2", "B3", "C1", "C2", "C3"]
casas_disponiveis = ["A1", "A2", "A3", "B1", "B2", "B3", "C1", "C2", "C3"]
fim_de_jogo = False
modo_de_jogo = menu()

if modo_de_jogo == "1":
    pass
elif modo_de_jogo == "2":
    icon = ""
    while icon != "X" and icon != "O":
        icon = input("Com qual icóne deseja jogar?\n\n 'X' ou 'O'?\n\nDigite 'X' ou 'O' e pressione [Enter]").upper()
        sair(icon)
        if icon == "X":
            p1 = Player(icon)
            p2 = Player("O")
        elif icon == "O":
            p1 = Player(icon)
            p2 = Player("X")
        else:
            comando = input(
                "ICÓNE INVÁLIDO!\n\nVocê deve digitar o icóne desejado, que só pode ser entre 'X' ou 'O' e pressionar [Enter].\n\nPressione [Enter] para prosseguir.")
            sair(comando)

    while fim_de_jogo == False:
        jogada = ""
        casa_existente = False
        jogada = input(tabuleiro(p1.icon))
        sair(jogada)
        for i in casas_disponiveis:
            if casa_existente == True:
                casas[casas.index(jogada)] = p1.icon
                casas_disponiveis.remove(jogada)
