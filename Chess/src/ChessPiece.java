abstract public class ChessPiece {

    public String color;
    public boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    abstract public String getColor();

    abstract public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    abstract public String getSymbol();


    /**
     * Проверка хода в пустое поле,либо на поле где стоит соперник
     *
     * @param chessBoard Поле
     * @param toLine     Координаты строки конечного положения
     * @param toColumn   Координаты столбца конечного положения
     * @return Истину, если проверка пройдена
     */
    public static boolean checkEndPosition(ChessBoard chessBoard, int toLine, int toColumn, String color) {
        return ((chessBoard.board[toLine][toColumn] == null) || !(chessBoard.board[toLine][toColumn].getColor().equals(color)));
    }

    /**
     * Проверка на выход за пределы поля и ход в исходную точку
     *
     * @param line     Координаты строки текущего положения
     * @param column   Координаты столбца текущего положения
     * @param toLine   Координаты строки конечного положения
     * @param toColumn Координаты столбца конечного положения
     * @return Истину, если проверка пройдена
     */
    public static boolean checkCoordinatePosition(int line, int column, int toLine, int toColumn) {
        return (toLine >= 0 && toLine <= 7 && toColumn >= 0 && toColumn <= 7) &&
                (line >= 0 && line <= 7 && column >= 0 && column <= 7) &&
                !(line == toLine && column == toColumn);
    }
}
