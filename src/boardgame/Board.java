package boardgame;

public class Board {
    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new BoardException("Error while creating board");
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

    public Piece piece(int row, int column) {
        if (!positionExits(row, column)) {
            throw new BoardException("Position does not exists!");
        }
        return pieces[row][column];
    }

    public Piece piece(Position position) {
        if (!positionExits(position)) {
            throw new BoardException("Position does not exists!");
        }
        return pieces[position.getRow()][position.getCol()];
    }

    public void placePiece(Piece piece, Position position) {
        if(thereIsAPiece(position)){
            throw new BoardException("There already is a piece on that position " + position);
        }
        pieces[position.getRow()][position.getCol()] = piece;
        piece.position = position;
    }


    public boolean positionExits(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionExits(Position position) {
        return positionExits(position.getRow(), position.getCol());
    }

    public boolean thereIsAPiece(Position position) {
        if (!positionExits(position)) {
            throw new BoardException("Position does not exists!");
        }
        return piece(position) != null;
    }


}
