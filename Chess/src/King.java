public class King extends ChessPiece {

    public King(String color) {
        super(color);
    }

    public String getColor() {
        return color;
    }

    public String getSymbol() {
        return "K";
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (((line - toLine) == 0 && Math.abs(column - toColumn) == 1) ||
                (Math.abs(line - toLine) == 1 && (column - toColumn) == 0) ||
                (Math.abs(line - toLine) == 1 && Math.abs(column - toColumn) == 1)) {
            return ChessPieceHelper.canMoveToPositionBishop(chessBoard, line, column, toLine, toColumn, color) ||
                    ChessPieceHelper.canMoveToPositionRook(chessBoard, line, column, toLine, toColumn, color);
        }
        return false;
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {

        //Проверка что король не под атакой

        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                if (board.board[i][j] != null && !(board.board[i][j].getColor().equals(color))) {
                    if (board.board[i][j].getSymbol().equals("P")) {
                        if (((Pawn) board.board[i][j]).canAttackToPosition(board, i, j, line, column)) {
                            System.out.println("Король под атакой пешки");
                            return true;
                        }
                    }
                    if (board.board[i][j].canMoveToPosition(board, i, j, line, column)) {
                        System.out.println("Король под атакой");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isUnderAttackAfterCastling(ChessBoard board, int line, int column) {

        //Проверка что король после рокировки не будет под атакой

        if (board.board[line][column] == null) {
            board.board[line][column] = new King(color);
            if (new King(color).isUnderAttack(board, line, column)) {
                board.board[line][column] = null;
                System.out.println("После рокировки король будет под атакой");
                return true;
            }
        }
        return false;
    }
}
