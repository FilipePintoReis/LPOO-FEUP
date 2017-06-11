
Design Patterns usados:

SINGLETON

Assegura que uma dada classe só possui uma instância para o programa inteiro que vai ser acedida
por várias classes alheias.

Este padrão é uado para o manuseamento da classe do libdgx SpriteBatch, visto que esta é uma classe
excessivamente pesada e que consome demasiados recursos. È criada uma SpriteBatch na classe principal do
jogo que é passada a todos os States do jogo como argumento.


STATE

Recorre a uma máquina de estados para navegar entre a lógica do jogo.

O programa possui várias classes derivadas de uma classe State, conforme cada etapa/menu do jogo. Para se efectuar a gestão
de estados, recorre-se a uma classe GameStateManager.


SUBCLASS SANDBOX

Padrão que define uma classe mãe com vários métodos que serão overrided
pelas suas classes derivadas.

Este pattern é utilizado nas classes States e seus derivados, cada uma dando override
aos métodos que existem na classe State, adaptando-os às suas funções específicas


UPDATE METHOD

Padrão que define um certo número de objectos para um dado programa, tendo cada um deles um método update() que 
actualiza o respectivo objecto, em função de um delta t, simulando uma (ou várias) frames.

Este padrão é utilizado para animações e para todos os renders de objectos no ecrã. É também utilizado para
os updates da lógica do jogo.




DIFICULDADES ENCONTRADAS



O tema inicialmente escolhido mostrou-se não adequado às capacidades do grupo. Teria que ser efectuada demasiada pesquisa
sem garantias que as soluções encontradas funcionariam, pelo menos dentro do prazo especificado para a entrega do trabalho.
Foi então definido um tema mais simples e concreto. No entanto, devido à escolha tardia do tema, não foi possível efectuar um bom planeamento de estratégias
de desenvolvimento, acabando o trabalho por ter sido desenvolvido não com as melhores práticas.
Devido a esta falta de planeamento, não foi possível isolar a lógica do jogo e realizar testes unitários.


CRÉDITOS

Parte da estrutura da lógica do jogo foi baseada no código fornecido por Brent Aureli.
https://github.com/BrentAureli/FlappyDemo



TEMPO GASTO

O trabalho foi desenvolvido na sua íntegra ao longo de uma semana (7 dias úteis) tendo sido gastas,
por estimativa, 8/9 horas diárias, perfazendo o total de 56 a 63 horas.

A distruibuição de tarefas foi feita de forma a que cada membro realiza-se cerca de metade do trabalho cada
(50/50).





Tutorial to download and run the game.


To use the app you need to open the file Pepsiman.jar and click on View Raw to download.

After the download is complete, you click the Pepsiman.jar to run it.

To start the game click the run button on the center

http://tinypic.com/r/rh01gh/9

JUMP makes you jump and the pepsi simbol changes your color.
Avoid obstacles to gain score

http://tinypic.com/r/24vr9jp/9

If you enter an area without having it's color

http://tinypic.com/r/dyof2u/9

or fail to avoid the obstacles, you will lose

http://tinypic.com/r/2e5qwdl/9

Click the first butoon to play again and the second one to come back to play menu.
