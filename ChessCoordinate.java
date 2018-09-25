import java.lang.Integer;
import java.lang.Number;

class Coordinate extends Blank<Queen>{
	//Instance Variables:
	private int xCoordinate;
	private int yCoordinate;

	
	//Constructors:
	Coordinate(int x, int y){
		this.xCoordinate = x; 
		this.yCoordinate = y; 
		this.value = null;
	}
	
	//Methods:
	public int getXCoordinate(){return this.xCoordinate;} 
	public int getYCoordinate(){return this.yCoordinate;} 
	
	public void setXCoordinate(int newX){this.xCoordinate = newX;}
	public void setYCoordinate(int newY){this.yCoordinate = newY;}

	
	@Override
	public boolean equals(Object o){
		if (!(o instanceof Coordinate)){
			return false;
		}
		
		Coordinate anotherCoordinate = (Coordinate) o;
		
		if (this.getXCoordinate() == anotherCoordinate.getXCoordinate() && this.getYCoordinate() == anotherCoordinate.getYCoordinate()){
			return true;
		}
		else{
			return false;
		}
	}
	
	@Override
	public Coordinate clone(){
		Coordinate outputCoordinate = new Coordinate(this.getXCoordinate(), this.getYCoordinate()); 
		outputCoordinate.setValue(this.getValue());  
		return outputCoordinate;
	}
	
	@Override
	public String toString(){
		String resultString = " \nCoordinate: (" + getXCoordinate() + ", " + getYCoordinate() + ")\n" +  "Value at Coordinate: " + getValue() + "\n";
		
		return resultString; 
	}
	
	public void printCoordinate(){System.out.println(this.toString());}
	
	@Override
	public boolean checkValueAtBlank(Queen checkValue, BacktrackableObject inputBacktrackableObject){ //Only accepts SudokuBoards
		ChessBoard inputBoard = (ChessBoard) inputBacktrackableObject;
		
		if (checkXRow(checkValue, inputBoard) && checkYRow(checkValue, inputBoard) && checkDiagonal(checkValue, inputBoard) == true){
			return true; 
		}
		return false; 
	}
		
	public boolean checkXRow(Queen checkValue, ChessBoard inputBoard){
		int xCoordinate = this.getXCoordinate(); 
		Coordinate[][] chessBoardCoordinates = inputBoard.getCoordinates(); 
		
		for (int yCounter = 0; yCounter < 8; yCounter++){
			int currentValue; 
			if (chessBoardCoordinates[xCoordinate-1][yCounter].getValue() == null){
				continue; 
			}
			if (chessBoardCoordinates[xCoordinate-1][yCounter].equals(this)){
				continue;
			}
			if (chessBoardCoordinates[xCoordinate-1][yCounter].getValue() == checkValue){
				return false; 
			}
		}
		return true; 
	}
	
	public boolean checkYRow(Queen checkValue, ChessBoard inputBoard){
		int yCoordinate = this.getYCoordinate(); 
		Coordinate[][] chessBoardCoordinates = inputBoard.getCoordinates(); 
		
		for (int xCounter = 0; xCounter < 8; xCounter++){ 
			if (chessBoardCoordinates[xCounter][yCoordinate-1].getValue() == null){
				continue;
			}
			if (chessBoardCoordinates[xCounter][yCoordinate-1].equals(this)){
				continue;
			}
			if (chessBoardCoordinates[xCounter][yCoordinate-1].getValue() == checkValue){
				return false;
			}
		}
		return true; 
	}
	
	public boolean checkDiagonal(Queen checkValue, ChessBoard inputBoard){
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
}
		
		
		
		
		
		
		
		
		
		
		
		