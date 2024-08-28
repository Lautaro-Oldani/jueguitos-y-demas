import random
from getpass import getpass
IMAGENES_AHORCADO = ['''

 +------+
 |      |
        |
        |
        |
        |
=========''', '''
 +------+
 |      |
 O      |
        |
        |
        |
=========''', '''

 +------+
 |      |
 O      |
 |      |
        |
        |
=========''', '''

 +------+
 |      |
 O      |
/|      |
        |
        |
=========''', '''

 +------+
 |      |
 O      |
/|\     |
        |
        |
=========''', '''

 +------+
 |      |
 O      |
/|\     |
/       |
        |
=========''', '''

 +------+
 |      |
 O      |
/|\     |
/ \     |
        |
=========''']



def mostrartablero(IMAGENES_AHORCADO, letrasincorrectas, letrascorrectas, palabra):
    print(IMAGENES_AHORCADO[len(letrasincorrectas)])
    print()

    print('letrasincorrectas:',letrasincorrectas)
    print()
    espaciosvacios = '_' * len(palabra)
    for i in range(len(palabra)):
        if palabra[i] in letrascorrectas:
            espaciosvacios = espaciosvacios[:i] + palabra[i] + espaciosvacios[i+1:]
    for letra in espaciosvacios:
        print(letra, end=' ')
    print()

def obtenerintento(letrasprobadas):
    while True:
        print('adivina una letra')
        intento = input()
        intento = intento.lower()
        if len(intento) != 1:
            print('una letra sola dale no seas tramposo')
        elif intento in letrasprobadas:
            print('esa ya la probaste, media pila')
        elif intento not in 'abcdefghijklmnñopqrstuvwxyz':
            print('sabes muy bien que eso no es una letra')
        else:
            return intento

def jugarDeNuevo():
    print('¿Queres jugar de nuevo? (sí o no)')
    return input().lower().startswith('s')

print('A H O R C A D O')
letrasincorrectas = ''
letrascorrectas = ''
print('ingresa una palabra para adivinar, por favor en minuscula')
palabra = getpass().lower()
juegoTerminado = False

while True:
    mostrartablero(IMAGENES_AHORCADO, letrasincorrectas, letrascorrectas, palabra)
    intento = obtenerintento(letrasincorrectas + letrascorrectas)

    if intento in palabra:
        letrascorrectas = letrascorrectas + intento

        victoria = True
        for i in range(len(palabra)):
            if palabra[i] not in letrascorrectas:
                victoria = False
                break
        if victoria:
            print('GANASTEEE!!, la palabra era " ' + palabra + '"')
            juegoTerminado = True
    else:
        letrasincorrectas = letrasincorrectas + intento

        if len(letrasincorrectas) == len(IMAGENES_AHORCADO):
            mostrartablero
            print('te quedaste sin intentos, perdite :( \n la palabra secreta era "'+ palabra + '"')
            juegoTerminado = True

    if juegoTerminado:
        if jugarDeNuevo():
            letrasincorrectas = ''
            letrascorrectas = ''
            juegoTerminado = False
            print('ingresa una palabra para adivinar, por favor en minuscula')
            palabra = getpass().lower()
        else:
            break