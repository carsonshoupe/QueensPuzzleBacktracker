class QueensPuzzleBacktracker extends Backtracker{
	//Instance Variables:
	
	//Constructors:
	
	//Methods: 
	
	
	
	
	
	
	public boolean checkValueAtBlank(String[] queenPositionAsArr, ChessRow inputChessRow){
		if (checkColumn(queenPositionAsArr, inputChessRow) && checkDiagonal(queenPositionAsArr, inputChessRow) == true){
			return true; 
		}
		return false; 
	}
	
	
		//stopped here
	
	public boolean checkColumn(String[] queenPositionAsArr, ChessRow inputChessRow){
		int queenIndex = this.findQueen(); 
		ChessRows[] chessBoardRows = inputBoard.getChessRows();
		
		for (int counter = 0; counter < 8; counter++){ 
			if (chessBoardRows[counter].findQueen() == this){
				continue;
			}
			if (queenIndex == chessBoardRows[counter].findQueen()){
				return false;
			}
		}
		return true; 
	}
	public boolean checkDiagonal(String[] queenPositionAsArr, ChessRow inputChessRow){
		Coordinate[][] chessBoardCoordinates = inputBoard.getCoordinates(); 
		int positiveDiagonal = this.getXCoordinate() + this.getYCoordinate(); 
		int negativeDiagonal = this.getXCoordinate() - this.getYCoordinate(); 
		
		for (int yCounter = 0; yCounter<8; yCounter++){
			for (int xCounter = 0; xCounter<8; xCounter++){
				Coordinate checkCoordinate = chessBoardCoordinates[xCounter][yCounter]; 
				int checkPositiveDiagonal = checkCoordinate.getXCoordinate() + checkCoordinate.getYCoordinate(); 
				int checkNegativeDiagonal = checkCoordinate.getXCoordinate() - checkCoordinate.getYCoordinate(); 
				
				if (positiveDiagonal == checkPositiveDiagonal || negativeDiagonal == checkNegativeDiagonal){
					if (checkCoordinate.getValue() == null){
						continue;
					}
					if (checkCoordinate.equals(this)){
						continue;
					}
					if (checkCoordinate.getValue() == checkValue){
						return false;
					}
				}
			}
		}
		return true;
	}