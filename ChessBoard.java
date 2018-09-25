import java.util.Arrays;

class ChessBoard extends BacktrackableObject{
	//Instance Variables:
	private ChessRow[] chessRows;
	
	//Constructors:
	ChessBoard(int chessBoardSize){
		for (int counter = 0; counter < chessBoardSize; counter++){
			this.chessRows[counter] = new ChessRow(0); 
		}
		this.arrOfBlanks = chessRows; 
	}
	
	
	/* 
	ChessBoard(String boardAsNumbers){
		this.boardInputAsString = boardAsNumbers; 
		int locationCounter = 0; //This var is the location in the string of boardAsNumbers
		for (int yCounter = 0; yCounter<8; yCounter++){
			for (int xCounter = 0; xCounter<8; xCounter++){
				this.coordinates[xCounter][yCounter] = new Coordinate(xCounter+1, yCounter+1);
				
				char tempChar = boardAsNumbers.charAt(locationCounter);
				System.out.println("Comparison: " + Character.toString(tempChar) + ": " + "0"); 
				if (Character.toString(tempChar).equals("0")){
					this.coordinates[xCounter][yCounter].setValue(null);
				}					
				else{ //Could change this to incorporate other chess pieces//
					this.coordinates[xCounter][yCounter].setValue(new Queen(xCounter));
					this.coordinates[xCounter][yCounter].getValue().setQueenLocation(coordinates[xCounter][yCounter]); 
				}
				
				locationCounter++;
			}
		}
		setSingleDimArrOfCoordinates();
	}
	
	ChessBoard(Coordinate[][] inputCoordinates){ //clones coordinates
		for (int yCounter = 0; yCounter<8; yCounter++){
			for (int xCounter = 0; xCounter<8; xCounter++){
				Coordinate updatedCoordinate = inputCoordinates[xCounter][yCounter].clone(); 
				this.coordinates[xCounter][yCounter] = updatedCoordinate; 
			}
		}
		setSingleDimArrOfCoordinates();
	}
	
	ChessBoard(){
		this("QQQQQQQQ00000000000000000000000000000000000000000000000000000000");
	}
	 */
	
	//Methods: 
	
	public ChessRows[] getChessRows(){return this.chessRows;}
	
	/* 
	public Coordinate[][] getCoordinates(){return this.coordinates;} 
	public void setCoordinates(Coordinate[][] updatedCoordinates){this.coordinates = updatedCoordinates;}
	public void setSingleDimArrOfCoordinates(){
		Coordinate[] outputArr = new Coordinate[64];
		int counter = 0;
		for (int yCounter = 0; yCounter<8; yCounter++){
			for (int xCounter = 0; xCounter<8; xCounter++){
				outputArr[counter] = this.getCoordinates()[xCounter][yCounter]; 
				counter++;
			}
		}
		this.setArrOfBlanks(outputArr); 
	}
	 */
	
	public void printChessBoard(){System.out.println(this.toString());}
	
	@Override
	public String toString(){ 
	//Not sure if its better to save the string formatted as I want it to print or to save it as a flat string of numbers.  Same follows for the toString fxn for Coordinate. 
		String resultString = ""; 
		for (int xCounter = 0; xCounter < 8; xCounter++){
			Arrays.deepToString(this.getArrOfBlanks()[xCounter]);
			resultString = resultString + Arrays.deepToString(this.getArrOfBlanks()[xCounter]) + "\n";
		}
		return resultString; 
	}
	
	
	/* 
	@Override
	public ChessBoard clone(){
		//Whenever you make a sudokuboard from input coordinates, it clones all the coordinates and makes a board from there.  So my cloner just uses the SudokuBoard(coordinates[][]) constructor.  
		ChessBoard outputChessBoard = new ChessBoard(this.getCoordinates()); 
		return outputChessBoard;
	}		
	 */
	
}
		
		