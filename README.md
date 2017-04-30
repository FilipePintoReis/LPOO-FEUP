# LPOO1617_T2G1

User Navigation Diagram:

![](https://imgur.com/a/pIqMh)


Packets Diagran:

![](https://imgur.com/a/eDtRb)


Sequence Diagram:

![](https://imgur.com/a/3MGTY)


UML:

![](https://imgur.com/a/9bohw)


User Cases:

![](https://imgur.com/a/F61t2)


Design Patterns:


TEMPLATE METHOD

Padrão utilizado frequentemente em jogos que seguem a seguinte rotina:
- espera por input
- recebe input
- atualiza o mundo
- executa o ciclo de jogo
- desenha o mundo

Implementa esta rotina sem fazer mudanças à lógica do jogo. 
Será utilizado no âmbito do libdgx, que facilita o uso deste padrão.


SINGLETON

Assegura que uma dada classe só possui uma instâncea para o programa inteiro que
vai ser acedida por todas as restantes classes, fornecendo um acesso global.

Este padrão será usado para o manuseamento da classe do libdgx SpriteBatch, que como é uma classe
que usa bastantes recursos e poder de computação, terá somente uma instâncea, sendo acedida por quaisquer
classes do programa que necessitem de desenhar texturas.


STATE

Recorre a uma máquina de estados para navegar entre a lógica do jogo.

O programa possuirá várias classes derivadas de uma classe mãe State, conforme cada etapa/menu do jogo
(menu principal, estado de jogo, menu de opções, etc.) e usará uma classe gestora desses estados (Game State Manager) na classe principal que mudará de estado conforme o menu em que o utilizador se encontra.



SUBCLASS SANDBOX

Padrão que define uma class mãe com vários métodos que serão overrided pelas suas classes derivadas, cada uma adaptando esses métodos à sua função especializada respectiva, evitando código redundante.

Este padrão será usado para definir os vários estados do jogo; Cada estado será derivado de uma classe mãe State e fará override de certos métodos definidos na classe mãe, conforme a sua função específica.



GAME LOOP

Unm ciclo de jogo permanece ativo, recebendo input do utilizador e atualizando o jogo conforme o input, terminando quando uma das condições de vitória/derrota são cumpridas.



UPDATE METHOD

Padrão que define um certo número de objectos para um dado programa, tendo cada um deles um método update()
que actualiza o seu respetivo objecto, em função de um tempo delta t, simulando uma (ou várias) frames.

Este método será usado recorrendo às features do libdgx de modo a atualizar as texturas que são desenhadas no ecrã.





Expected tests:

- Testa se o jogador acerta uma palavra
- Testa se o jogador falha uma palavra
- Testa se o jogador perde o jogo
- Testa se o jogador acaba o jogo sem perder
- Testa se o jogador ganha pontos ao acertar uma palavra
- Testa se o jogador não ganha pontos ao falhar uma palavra
- Testa se o programa dá parse correcto dos ficheiros lrc
- Testa se o utilizador consegue submeter o seu highscore para o servidor
- Testa se o utilziador consegue criar um servidor


