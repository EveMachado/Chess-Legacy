package boardgame;

public abstract class Piece {

    protected Position position;
    private Board board;

    public Piece(Board board) {
        this.board = board;
        //posição de uma peça recem criada
        position = null;
    }

    //somente classes dentro do mesmo pacote e sub classes vão poder acessar o tabuleiro de uma peça
    protected Board getBoard() {
        return board;
    }

    public abstract boolean[][] possibleMoves();

    public boolean possibleMoves(Position position){
        return possibleMoves()[position.getRow()][position.getColumn()];
    }

    public boolean isThereAnyPossibleMove(){
        boolean[][] mat = possibleMoves();
        for(int i = 0; i< mat.length; i++){
            for(int j = 0; j< mat.length; j++){
                if(mat[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }



}

