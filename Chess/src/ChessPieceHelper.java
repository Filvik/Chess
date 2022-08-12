public class ChessPieceHelper {
    /**
     * Проверка возможности хода слоном
     *
     * @param chessBoard Поле
     * @param line       Координаты строки текущего положения
     * @param column     Координаты столбца текущего положения
     * @param toLine     Координаты строки конечного положения
     * @param toColumn   Координаты столбца конечного положения
     * @param color      Цвет
     * @return Истину, если проверка пройдена
     */
    public static boolean canMoveToPositionBishop(ChessBoard chessBoard, int line, int column, int toLine, int toColumn, String color) {

        if (ChessPiece.checkCoordinatePosition(line, column, toLine, toColumn)) {
            if (ChessPiece.checkEndPosition(chessBoard, toLine, toColumn, color)) {
                if (Math.abs(toLine - line) == Math.abs(toColumn - column)) {

                    if (toLine - line > 0 && toColumn - column > 0) {
                        for (int x = line + 1; x < toLine; x++) {
                            if (chessBoard.board[x][++column] != null) {
                                return false;
                            }
                        }
                    } else if (toLine - line < 0 && toColumn - column < 0) {
                        for (int x = line - 1; x > toLine; x--) {
                            if (chessBoard.board[x][--column] != null) {
                                return false;
                            }
                        }
                    } else if (toLine - line > 0 && toColumn - column < 0) {
                        for (int x = line + 1; x < toLine; x++) {
                            if (chessBoard.board[x][--column] != null) {
                                return false;
                            }
                        }
                    } else if (toLine - line < 0 && toColumn - column > 0) {
                        for (int x = line - 1; x > toLine; x--) {
                            if (chessBoard.board[x][++column] != null) {
                                return false;
                            }
                        }
                    }
                    else {
                        return false;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Проверка возможности хода ладьей
     *
     * @param chessBoard Поле
     * @param line       Координаты строки текущего положения
     * @param column     Координаты столбца текущего положения
     * @param toLine     Координаты строки конечного положения
     * @param toColumn   Координаты столбца конечного положения
     * @param color      Цвет
     * @return Истину, если проверка пройдена
     */
    public static boolean canMoveToPositionRook(ChessBoard chessBoard, int line, int column, int toLine, int toColumn, String color) {

        if (ChessPiece.checkCoordinatePosition(line, column, toLine, toColumn)) {
            if (ChessPiece.checkEndPosition(chessBoard, toLine, toColumn, color)) {
                if ((line == toLine) || (column == toColumn)) {

                    if (line < toLine) {
                        for (int x = line + 1; x < toLine; x++) {
                            if (chessBoard.board[x][column] != null) {
                                return false;
                            }
                        }
                    } else if (line > toLine) {
                        for (int x = line - 1; x > toLine; x--) {
                            if (chessBoard.board[x][column] != null) {
                                return false;
                            }
                        }
                    } else if (column < toColumn) {
                        for (int x = column + 1; x < toColumn; x++) {
                            if (chessBoard.board[line][x] != null) {
                                return false;
                            }
                        }
                    } else if (column > toColumn) {
                        for (int x = column - 1; x > toColumn; x--) {
                            if (chessBoard.board[line][x] != null) {
                                return false;
                            }
                        }
                    }
                    else {
                        return false;
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
