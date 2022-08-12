public class Horse extends ChessPiece {

    public Horse(String color) {
        super(color);
    }

    public String getColor() {
        return color;
    }

    public String getSymbol() {
        return "H";
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {


        if (checkCoordinatePosition(line, column, toLine, toColumn)) {
            if (checkEndPosition(chessBoard, toLine, toColumn,color)) {
                return (line - 2 == toLine && column - 1 == toColumn) ||
                        (line - 2 == toLine && column + 1 == toColumn) ||
                        (line + 2 == toLine && column - 1 == toColumn) ||
                        (line + 2 == toLine && column + 1 == toColumn) ||
                        (line - 1 == toLine && column - 2 == toColumn) ||
                        (line - 1 == toLine && column + 2 == toColumn) ||
                        (line + 1 == toLine && column - 2 == toColumn) ||
                        (line + 1 == toLine && column + 2 == toColumn);
            }
        }
        return false;
    }
}
