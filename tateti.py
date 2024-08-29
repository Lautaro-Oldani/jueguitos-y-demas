import random

def tablerotateti(tablero):
    print('   |   |')
    print(' ' + tablero[7] + ' | ' + tablero[8] + ' | ' + tablero[9])
    print('   |   |')
    print('-----------')
    print('   |   |')
    print(' ' + tablero[4] + ' | ' + tablero[5] + ' | ' + tablero[6])
    print('   |   |')
    print('-----------')
    print('   |   |')
    print(' ' + tablero[1] + ' | ' + tablero[2] + ' | ' + tablero[3])
    print('   |   |')


def quiencomienza():
    if random.randint(0, 1) == 0:
        return 'la X'
    else:
        return 'la O'

def jugarDeNuevo():
    print('¿Deseas volver a jugar? (sí/no)?')
    return input().lower().startswith('s')

def hacerJugada(tablero, letra, jugada):
    tablero[jugada] = letra

def esGanador(ta, le):
    return ((ta[7] == le and ta[8] == le and ta[9] == le) or
    (ta[4] == le and ta[5] == le and ta[6] == le) or
    (ta[1] == le and ta[2] == le and ta[3] == le) or
    (ta[7] == le and ta[4] == le and ta[1] == le) or
    (ta[8] == le and ta[5] == le and ta[2] == le) or
    (ta[9] == le and ta[6] == le and ta[3] == le) or
    (ta[7] == le and ta[5] == le and ta[3] == le) or
    (ta[9] == le and ta[5] == le and ta[1] == le))

def obtenerDuplicadoTablero(tablero):
    dupTablero = []
    for i in tablero:
        dupTablero.append(i)
    return dupTablero

def hayEspacioLibre(tablero, jugada):
    return tablero[jugada] == ' '

def obtenerjugada(tablero):
    jugada = ' '
    while jugada not in '1 2 3 4 5 6 7 8 9'.split() or not hayEspacioLibre(tablero, int(jugada)):
        print('¿Cuál es tu próxima jugada? (1-9)')
        jugada = input()
    return int(jugada)

def elegirAzarDeLista(tablero, listaJugada):
    jugadasPosibles = []
    for i in listaJugada:
      if hayEspacioLibre(tablero, i):
        jugadasPosibles.append(i)
    if len(jugadasPosibles) != 0:
       return random.choice(jugadasPosibles)
    else:
       return None

def tableroCompleto(tablero):
    for i in range(1, 10):
       if hayEspacioLibre(tablero, i):
         return False
    return True

print('BIENVENIDO AL TA TE TI!!')

while True:
    elTablero = [' '] * 10
    turno = quiencomienza()
    print(turno + ' va primero')
    juegoEnCurso = True

    while juegoEnCurso:
        if turno == 'la X':
            letraX = 'X'
            tablerotateti(elTablero)
            jugada = obtenerjugada(elTablero)
            hacerJugada(elTablero, letraX, jugada)

            if esGanador(elTablero, letraX):
                tablerotateti(elTablero)
                print('¡Felicidades, has ganado!')
                juegoEnCurso = False
            else:
                if tableroCompleto(elTablero):
                    tablerotateti(elTablero)
                    print('¡Es un empate!')
                    break
                else:
                    turno = 'la O'
        else:
            letraO = 'O'
            tablerotateti(elTablero)
            jugada = obtenerjugada(elTablero)
            hacerJugada(elTablero, letraO, jugada)

            if esGanador(elTablero, letraO):
                tablerotateti(elTablero)
                print('¡Felicidades, has ganado!')
                juegoEnCurso = False
            else:
                if tableroCompleto(elTablero):
                    tablerotateti(elTablero)
                    print('¡Es un empate!')
                    break
                else:
                    turno = 'la X'
    if not jugarDeNuevo():
        break
