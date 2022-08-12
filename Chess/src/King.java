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

        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                if (board.board[i][j] != null && !(board.board[i][j].getColor().equals(color))) {
                    if (board.board[i][j].getSymbol().equals("P")) {
                        return ((Pawn) board.board[i][j]).canAttackToPosition(board, i, j, line, column);
                    }
                    if (board.board[i][j].canMoveToPosition(board, i, j, line, column)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
