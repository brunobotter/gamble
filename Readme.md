# Objetivo dessse projeto e mostrar como uma casa de aposta pode manipular os jogos
# Projeto totalmente para estudos

# Features ja incluidas
1. Cadastro cliente

2. Depositos ficticios

3. Apostas básicas

4. Validações e handle de erros basicos

# Proximas features

1. Histórico de Apostas
   Descrição: Permitir que o usuário visualize o histórico completo de suas apostas, incluindo data, valor apostado, resultado (ganhou ou perdeu) e o saldo após cada aposta.
   E tambem mostrar intervalos de data, exemplo so ver apostas do ultimo mês.
   Objetivo: Mostrar como o sistema pode registrar e manipular dados para criar uma falsa sensação de controle.

2. Probabilidade Manipulável
   Descrição: Adicionar uma funcionalidade para alterar a probabilidade de vitória do jogador.
   Objetivo: Demonstrar como cassinos podem ajustar as chances de vitória para maximizar seus lucros.
   Exemplo de implementação:
   Adicionar um parâmetro de configuração no sistema que permita ajustar a probabilidade de vitória (ex.: 10%, 20%, etc.).
   Alterar a lógica de checkWinCondition para levar em conta essa probabilidade.

3. Simulação de "Quase Vitória"
   Descrição: Implementar uma lógica que mostre ao usuário que ele "quase ganhou" (ex.: duas colunas iguais e uma diferente).
   Objetivo: Demonstrar como sistemas podem manipular a experiência do usuário para incentivá-lo a continuar apostando.
   Exemplo de implementação:
   Alterar a geração do tabuleiro para criar situações de "quase vitória" com mais frequência.

4. Sistema de Recompensas
   Descrição: Criar um sistema de recompensas para o jogador, como bônus por número de apostas ou por perdas consecutivas.
   Objetivo: Mostrar como sistemas podem incentivar o usuário a continuar jogando, mesmo quando está perdendo.
   Exemplo de implementação:
   Adicionar um contador de apostas consecutivas e oferecer um bônus (ex.: saldo extra) após um número específico de apostas.

5. Simulação de "Jogador VIP"
   Descrição: Implementar um sistema de níveis (ex.: Bronze, Prata, Ouro) com benefícios fictícios para jogadores que apostam grandes quantias.
   Objetivo: Demonstrar como sistemas podem criar uma falsa sensação de exclusividade para incentivar apostas maiores.
   Exemplo de implementação:
   Criar uma lógica que classifique os jogadores com base no total apostado.
   Exibir mensagens como "Parabéns, você é um jogador Ouro!".

6. Estatísticas do Jogador
   Descrição: Mostrar estatísticas detalhadas para o jogador, como taxa de vitória, total apostado, total ganho e total perdido.
   Objetivo: Demonstrar como sistemas podem usar dados para criar uma falsa sensação de controle ou habilidade.
   Exemplo de implementação:
   Criar uma rota para calcular e exibir essas estatísticas com base no histórico de apostas.

7. Modo de Simulação
   Descrição: Adicionar um modo de simulação onde o jogador pode "testar" o sistema sem gastar dinheiro real.
   Objetivo: Mostrar como sistemas podem manipular resultados em simulações para criar uma falsa sensação de confiança.
   Exemplo de implementação:
   Criar uma flag no sistema para alternar entre "modo real" e "modo simulação".
   No modo simulação, aumentar a probabilidade de vitória.

8. Logs de Manipulação
   Descrição: Adicionar logs no sistema que mostrem como as probabilidades e resultados são manipulados.
   Objetivo: Demonstrar de forma transparente como o sistema pode ser configurado para enganar o usuário.
   Exemplo de implementação:
   Criar logs detalhados para cada aposta, incluindo a probabilidade de vitória e o resultado gerado.

9. Simulação de Fraude
   Descrição: Adicionar uma funcionalidade que permita ao administrador alterar os resultados de apostas específicas.
   Objetivo: Demonstrar como sistemas podem ser manipulados por administradores mal-intencionados.
   Exemplo de implementação:
   Criar uma rota protegida para alterar o resultado de uma aposta no banco de dados

10. Sistema de Limites
    Descrição: Implementar limites de apostas diárias ou mensais para o jogador.
    Objetivo: Mostrar como sistemas podem criar uma falsa sensação de segurança para o usuário.
    Exemplo de implementação:
    Adicionar uma lógica para rastrear o total apostado em um período e bloquear novas apostas após atingir o limite.

11. Simulação de "Jackpot"
    Descrição: Adicionar uma funcionalidade de "jackpot" com uma probabilidade extremamente baixa de vitória.
    Objetivo: Demonstrar como sistemas podem usar prêmios grandes para atrair jogadores, mesmo que as chances de ganhar sejam mínimas.
    Exemplo de implementação:
    Adicionar uma lógica para calcular a probabilidade de acionar o jackpot (ex.: 0.01%).

12. Deploy da aplicação na aws pelo github actions, criação docker, criação terraform para levantar a infra da aws