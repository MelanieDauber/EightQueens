package hw2;

	//solving the Eight Queens problem

	public class eightQueens{

	    public static boolean checkDiagonals(boolean[][] board) {
	        // the code below checks the diagonals of the first type
	        
	        // diagonals, that start on the first column
	        for (int row = 0; row < 8; ++row) {
	            boolean hasQueen = false;
	            for (int col = 0; row + col < 8; ++col) {
	                if (board[row + col][col]) {
	                    if (hasQueen) return false; // we found the second queen on the diagonal
	                    hasQueen = true;
	                }
	            }
	        }
	        // diagonals, that start on the first row
	        for (int col = 0; col < 8; ++col) {
	            boolean hasQueen = false;
	            for (int row = 0; row + col < 8; ++row) {
	                if (board[row][row + col]) {
	                    if (hasQueen) return false; // we found the second queen on the diagonal
	                    hasQueen = true;
	                }
	            }
	        }
	        
	        // the code below checks the diagonals of the second type
	        // diagonals, that start on the first column
	        for (int row = 0; row < 8; ++row) {
	            boolean hasQueen = false;
	            for (int col = 0; row - col >= 0; ++col) {
	                if (board[row - col][col]) {
	                    if (hasQueen) return false; // we found the second queen on the diagonal
	                    hasQueen = true;
	                }
	            }
	        }
	        // diagonals, that start on the last row
	        for (int col = 0; col < 8; ++col) {
	            boolean hasQueen = false;
	            for (int row = 7; 7 - row + col < 8; --row) {
	                if (board[row][7 - row + col]) {
	                    if (hasQueen) return false; // we found the second queen on the diagonal
	                    hasQueen = true;
	                }
	            }
	        }   
	        
	        return true;
	    }    

		public static boolean checkRowsAndColumns(boolean[][]board){
			for (int col = 0; col < 8; ++col){
				boolean hasQueen = false;
				for (int row = 0; row < 8; ++row){
					if (board[row][col]){
						if (hasQueen) return false;
						hasQueen = true;
					}
				}
			}
			for (int row = 0; row < 8; ++row){
				boolean hasQueen = false;
				for (int col = 0; col < 8; ++col){
					if (board[row][col]){
						if (hasQueen) return false;
						hasQueen = true;
					}
				}
			}	
			return true;
		}

		public static boolean placeQueen(boolean[][] board, int col){
			if (col == 8) return true;
			for(int row = 0; row < 8; ++row){
				board[row][col] = true;
				if (checkRowsAndColumns(board) && checkDiagonals(board)){
					boolean rest = placeQueen(board, col+1);
					if (rest) return true;
					board[row][col] = false;
				} else {
					board[row][col] = false;
				}
			}
			return false;
		}

		public static void main(String[] args){
			int colIndex = 0;
			boolean[][] board = new boolean[8][8];
			boolean allGood = placeQueen(board, colIndex);
			for (int i = 0; i < board.length; ++i){
				System.out.println();
				for (int j = 0; j < board.length; ++j){
					if (board[i][j]){
						System.out.print("[Q]");
					} else {
						System.out.print("[ ]");
					}
				}
			}
			System.out.println();
		}
	}
