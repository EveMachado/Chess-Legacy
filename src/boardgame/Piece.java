package boardgame;

public class Piece {

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
}
