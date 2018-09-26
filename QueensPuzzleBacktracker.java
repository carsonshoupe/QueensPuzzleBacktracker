class QueensPuzzleBacktracker extends Backtracker<Integer>{
	//Instance Variables:
	
	//Constructors:
	QueensPuzzleBacktracker(ChessRow[] arrOfChessRowBlanks, Integer[] arrOfQueenPositions, ChessBoard chessBoard){
		this.blanks = arrOfChessRowBlanks; 
		this.checkValues = arrOfQueenPositions; 
		this.board = chessBoard; 
	}
		
	
	//Methods: 
	public boolean checkValueAtBlank(Integer queenPosition, Blank inputChessRow){
		if (checkColumn(queenPosition, (ChessRow) inputChessRow) && checkDiagonal(queenPosition, (ChessRow) inputChessRow) == true){
			return true; 
		}
		return false; 
	}

	public boolean checkColumn(Integer queenPosition, ChessRow inputChessRow){
		int queenXCoordinate = queenPosition; 
		int queenYCoordinate = inputChessRow.getColumnNum();
		
		ChessRow[] chessBoardRows = (ChessRow[]) this.board.getArrOfBlanks();
		
		for (int counter = 0; counter < inputChessRow.getRowLength(); counter++){ 
			if (queenYCoordinate == counter){
				continue; 
			}
			if (chessBoardRows[counter].getQueenLocation() == null){
				continue;
			}
			if (chessBoardRows[counter].getQueenLocation() == queenXCoordinate){
				return false; 
			}
		}
		return true; 
	}
				

	public boolean checkDiagonal(Integer queenPosition, ChessRow inputChessRow){
		int queenXCoordinate = queenPosition; 
		int queenYCoordinate = inputChessRow.getColumnNum();
		
		ChessRow[] chessBoardRows = (ChessRow[]) this.board.getArrOfBlanks(); 
		
		int positiveDiagonal = queenXCoordinate + queenYCoordinate; 
		int negativeDiagonal = queenXCoordinate - queenYCoordinate; 
		
		for (int counter = 0; counter < inputChessRow.getRowLength(); counter++){
			if (queenYCoordinate == counter){
				continue;
			}
			if (chessBoardRows[counter].getQueenLocation() == null){
				continue;
			}
				
			int checkQueenXCoordinate = chessBoardRows[counter].getQueenLocation(); 
			int checkQueenYCoordinate = counter; 
			int checkPositiveDiagonal = checkQueenXCoordinate + checkQueenYCoordinate; 
			int checkNegativeDiagonal = checkQueenXCoordinate - checkQueenYCoordinate; 
			
			if (positiveDiagonal == checkPositiveDiagonal || negativeDiagonal == checkNegativeDiagonal){
				return false; 
			}
		}
		return true; 
	}
}