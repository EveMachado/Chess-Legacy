package chess;

import boardgame.Board;

//regras do jogo
public class ChessMatch {

    private Board board;

    //construtor padrão
    public ChessMatch(){
        board = new Board(8,8);

    }

    //Vai retornar uma matriz de peças de xadrez correspondentes a partida
    public ChessPiece[][] getPieces(){

        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for ( int  i = 0; i<board.getRows(); i++){
            for(int j = 0; i < board.getColumns(); i++){
                //downcast: transformar algo genérico em algo específico (ChessPiece)
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }

        }
        return mat;
    }

}
