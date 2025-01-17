package application;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;

public class Program {

    public static void main(String[] args) {

        ChessMatch chessMatch = new ChessMatch();

        //função para imprimir as peças da partida

        //classe User Interface e dentro dela o método printBoard
        UI.printBoard(chessMatch.getPieces());
    }

}
