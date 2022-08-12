public class Bishop extends ChessPiece {

    public Bishop(String color) {
        super(color);
    }

    public String getColor() {
        return color;
    }

    public String getSymbol() {
        return "B";
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return ChessPieceHelper.canMoveToPositionBishop(chessBoard,line,column,toLine,toColumn,color);
    }
}
