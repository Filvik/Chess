public class Rook extends ChessPiece{

    public Rook(String color) {
        super(color);
    }

    public String getColor() {
        return color;
    }

    public String getSymbol() {
        return "R";
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return ChessPieceHelper.canMoveToPositionRook(chessBoard,line,column,toLine,toColumn,color);
    }
}
