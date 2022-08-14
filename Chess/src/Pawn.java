public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    public String getColor() {
        return color;
    }

    public String getSymbol() {
        return "P";
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if (checkCoordinatePosition(line, column, toLine, toColumn)) {

            if (column == toColumn) {

                if (line == 1 && (color.equals("White"))) {
                    if ((toLine == (line + 2)) && (chessBoard.board[toLine - 1][toColumn] == null) && (chessBoard.board[toLine][toColumn] == null)) {
                        return true;
                    } else if (toLine == (line + 1) && (chessBoard.board[line + 1][toColumn] == null)) {
                        return true;
                    }
                    return false;
                }
                if (toLine == (line + 1) && (color.equals("White")) && (chessBoard.board[toLine][toColumn] == null)) {
                    return true;
                }

                if (line == 6 && (color.equals("Black"))) {
                    if (toLine == (line - 2) && (chessBoard.board[toLine + 1][toColumn] == null) && (chessBoard.board[toLine][toColumn] == null)) {
                        return true;
                    } else if (toLine == (line - 1) && (chessBoard.board[toLine][toColumn] == null)) {
                        return true;
                    }
                    return false;
                }
                if (toLine == (line - 1) && (color.equals("Black")) && (chessBoard.board[line - 1][toColumn] == null)) {
                    return true;
                }
            } else if (toColumn == (column + 1) || toColumn == (column - 1)) {
                if (chessBoard.board[toLine][toColumn] != null && !(chessBoard.board[toLine][toColumn].getColor().equals(color))) {
                    return canAttackToPosition(chessBoard, line, column, toLine, toColumn);
                }
            }
        }
        return false;
    }

    public boolean canAttackToPosition(ChessBoard board, int line, int column, int toLine, int toColumn) {

        if ((board.board[toLine][toColumn] != null)) {

            if (color.equals("Black")) {
                if (board.board[toLine][toColumn].getColor().equals("White")) {
                    return (toLine == line - 1 && toColumn == column + 1) || (toLine == line - 1 && toColumn == column - 1);
                }
            } else {
                if (board.board[toLine][toColumn].getColor().equals("Black")) {
                    return (toLine == line + 1 && toColumn == column + 1) || (toLine == line + 1 && toColumn == column - 1);
                }
            }
        }
        return false;
    }
}
