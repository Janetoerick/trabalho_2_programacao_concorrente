# trabalho_2_programacao_concorrente

Este trabalho diz respeito a nota da segunda unidade da disciplina Programação Concorrente, no qual
tem o objetivo de melhorar tanto as habilidades trabalhando com threads na programação concorrente
como também os conhecimentos acerca das linguagens que utilizam os recursos concorrentes.

Para este trabalho é feito a implementação de uma lista encadeada concorrente, na qual dispõe de 3
threads para fazer o seu gerenciamento.

- ThreadB: Faz busca na lista.
- ThreadI: Faz inserção na lista.
- ThreadR: Faz remoção na lista.


Com o intuito de ficar mais interessante o desenvolvimento do sistema, foi proposto algumas restrições
na qual as threads deveriam seguir.

- ThreadB: Não há restrições.
- ThreadI: Deve ser inserido um elemento por vez, ou seja, uma threadI executando por vez.
- ThreadR: Deve ser removido um elemento quando não estiver tendo nenhuma ação na lista.



*Componentes:*
- Janeto Erick da Costa Lima
