package boardgame;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if(rows < 1 || columns < 1){
            throw new BoardException("Erro ao criar o tabuleiro: É necessário que aja pelo menos 1 linha e 1 coluna");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }


    //vai retornar a matriz pieces na linha row e coluna column
    public Piece piece(int row, int column){
        if(!positionExists(row, column)){
            throw new BoardException("Posição não está no tabuleiro");
        }
        return pieces[row][column];
    }

    //sobrecarga do método acima
    public Piece piece (Position position){
        if(!positionExists((position))){
            throw new BoardException("Posição não está no tabuleiro");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position){
        if(theseIsAPiece(position)){
            throw new BoardException("Já tem uma peça na posição " + position);
        }
        //Pegar a matriz na posição dada e atribuir a ela a peça que eu informei
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;

    }

    public Piece removePiece(Position position){
        if(!positionExists(position)){
            throw new BoardException(("Posição não está no tabuleiro"));
        }
        if (piece(position) == null){
           return null;
        }
        Piece aux = piece(position);
        aux.position = null;
        pieces[position.getRow()][position.getColumn()] = null;
        return aux;
    }

    public boolean positionExists(int row, int column){
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionExists(Position position){
        return positionExists(position.getRow(),position.getColumn());
    }

    public boolean theseIsAPiece(Position position){
        if(!positionExists((position))){
            throw new BoardException("Posição não está no tabuleiro");
        }
       return piece(position) != null;
    }



}
