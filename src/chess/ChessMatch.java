package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

//regras do jogo
public class ChessMatch {

    private Board board;

    //construtor padrão
    public ChessMatch(){
        //cria um tabuleiro 8 por 8 e chama o initialSetup()
        board = new Board(8,8);
        initialSetup();

    }

    //Vai retornar uma matriz de peças de xadrez correspondentes a partida
    public ChessPiece[][] getPieces(){

        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for ( int  i = 0; i<board.getRows(); i++){
            for(int j = 0; j < board.getColumns(); j++){
                //downcast: transformar algo genérico em algo específico (ChessPiece)
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }

        }
        return mat;
    }

    //este método vai ser resposavel por iniciar a partida, colocando as peças no tabuleiro
    private void initialSetup(){
        board.placePiece(new Rook(board, Color.WHITE), new Position(2,1));
        board.placePiece(new King(board, Color.BLACK), new Position(0, 4));
        board.placePiece(new King(board, Color.WHITE), new Position(7, 4));
    }

}
