package chess;

import boardgame.Board;
import boardgame.Piece;
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

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition){
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);
        Piece capturedPiece = makeMove(source, target);
        return (ChessPiece)capturedPiece;
    }

    private Piece makeMove(Position source, Position target){
        Piece p = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(p, target);
        return capturedPiece;
    }

    private void validateSourcePosition(Position position){
        if(!board.theseIsAPiece(position)){
            throw new ChessException("Não há nenhuma peça na posição de origem");
        }
        if(!board.piece(position).isThereAnyPossibleMove()){
            throw new ChessException("Não existe movimentos possiveis para a peça escolhida");
        }
    }

    //operação de colocar peças passando a posição nas coordenadas do xadrez
    private void placeNewPiece(char column, int row, ChessPiece piece){
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }

    //este método vai ser resposavel por iniciar a partida, colocando as peças no tabuleiro
    private void initialSetup(){

        placeNewPiece('c', 1, new Rook(board, Color.WHITE));

        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
    }

}
