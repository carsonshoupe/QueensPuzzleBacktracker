import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;

public class QueensPuzzleBacktrackerTest{
	
	@Test
	public void testQueenPuzzleBacktracker(){
		int howBig = 30;
		ChessBoard testChessBoard = new ChessBoard(howBig); 
		ChessRow[] testArrOfChessRowBlanks = (ChessRow[]) testChessBoard.getArrOfBlanks(); 
		
		Integer[] testArrOfQueenPositions = new Integer[howBig];
		
		for (int counter = 0; counter < howBig; counter++){
			testArrOfQueenPositions[counter] = counter; 
		}
		
		System.out.println(testChessBoard.toString()); 
		
		System.out.println(Arrays.toString(testArrOfQueenPositions)); 
		
		QueensPuzzleBacktracker qpb = new QueensPuzzleBacktracker(testArrOfChessRowBlanks, testArrOfQueenPositions, testChessBoard);
		
		try{
			qpb.runBacktracker(); 
		}
		catch(UnsolveableException e){
			System.out.println(e.getMessage()); 
		}
		
		System.out.println(testChessBoard.toString());
	}	
	
	
	
	
	
	
	
	
	
}

//javac -cp .;C:\junit\junit-4.10.jar QueensPuzzleBacktrackerTest.java
//java -cp .;C:\junit\junit-4.10.jar org.junit.runner.JUnitCore QueensPuzzleBacktrackerTest