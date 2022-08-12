public class Queen extends ChessPiece {

    public Queen(String color) {
        super(color);
    }

    public String getColor() {
        return color;
    }

    public String getSymbol() {
        return "Q";
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return ChessPieceHelper.canMoveToPositionBishop(chessBoard,line,column,toLine,toColumn,color) ||
                ChessPieceHelper.canMoveToPositionRook(chessBoard,line,column,toLine,toColumn,color);
    }
}
