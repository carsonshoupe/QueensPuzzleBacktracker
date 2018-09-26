import java.util.Arrays;

class ChessBoard extends BacktrackableObject{
	//Instance Variables:
	protected int chessBoardSize; 
	
	//Constructors:
	ChessBoard(int chessBoardSize){
		this.chessBoardSize = chessBoardSize; 
		arrOfBlanks = new ChessRow[this.chessBoardSize]; 
		for (int counter = 0; counter < this.chessBoardSize; counter++){
			this.arrOfBlanks[counter] = new ChessRow(chessBoardSize, counter); 
		}
	}
	
	//Methods: 
	public void printChessBoard(){System.out.println(this.toString());}
	
	@Override
	public String toString(){ 
		String resultString = "\n"; 
		for (int xCounter = 0; xCounter < this.chessBoardSize; xCounter++){
			resultString = resultString + this.getArrOfBlanks()[xCounter].toString();
		}
		return resultString; 
	}
}
		
		