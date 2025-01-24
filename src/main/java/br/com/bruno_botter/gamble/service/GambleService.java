package br.com.bruno_botter.gamble.service;

import br.com.bruno_botter.gamble.config.exception.InsuficientBalanceException;
import br.com.bruno_botter.gamble.dto.BoardResponse;
import br.com.bruno_botter.gamble.model.Client;
import br.com.bruno_botter.gamble.model.Gamble;
import br.com.bruno_botter.gamble.repository.ClientRepository;
import br.com.bruno_botter.gamble.repository.GambleRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class GambleService {

    private final GambleRepository gambleRepository;
    private final ClientRepository clientRepository;
    private final DepositService depositService;

    public GambleService(GambleRepository gambleRepository, ClientRepository clientRepository, DepositService depositService) {
        this.gambleRepository = gambleRepository;
        this.clientRepository = clientRepository;
        this.depositService = depositService;
    }

    public List<Gamble> findByClient(Client client) {
        return gambleRepository.findByClient(client);
    }

    public Gamble gamble(Gamble gamble) {
        Client client = gamble.getClient();
        if (client.getSaldo().compareTo(gamble.getAmountBet()) < 0) {
            throw new InsuficientBalanceException("Insufficient balance to place the bet.");
        }
        depositService.removeAmount(gamble);

        // Simula a roleta (3x3 matriz de letras)
        char[][] board = generateBoard();
        boolean isWin = checkWinCondition(board);

        // Atualiza o saldo do cliente se ganhou
        BigDecimal winAmount = BigDecimal.ZERO;
        if (isWin) {
            winAmount = gamble.getAmountBet().multiply(BigDecimal.valueOf(2)); // Exemplo: 2x o valor apostado
            client.setSaldo(client.getSaldo().add(winAmount));
        }

        // Atualiza os dados da aposta
        gamble.setWin(isWin);
        gamble.setPrizeValue(winAmount);
        gamble.setResult(boardToString(board)); // Converte o tabuleiro para string
        gamble.setUpdateAt(LocalDateTime.now());

        // Salva no repositório (se necessário)
        gambleRepository.save(gamble);

        return gamble;
    }

    // Gera uma matriz 3x3 de letras aleatórias (Z, X, Y, A)
    private char[][] generateBoard() {
        char[] letters = {'Z', 'X', 'Y', 'A'};
        char[][] board = new char[3][3];
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = letters[random.nextInt(letters.length)];
            }
        }
        return board;
    }

    // Verifica se há uma linha, coluna ou diagonal com letras iguais
    private boolean checkWinCondition(char[][] board) {
        // Verifica linhas e colunas
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) return true;
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) return true;
        }

        // Verifica diagonais
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) return true;
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) return true;

        return false;
    }

    private BoardResponse boardToString(char[][] board) {
        BoardResponse boardResponse = new BoardResponse();
        boardResponse.setBoardA(String.valueOf(board[0]));
        boardResponse.setBoardB(String.valueOf(board[1]));
        boardResponse.setBoardC(String.valueOf(board[2]));
        return boardResponse;
    }
}
