import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;

public class BacktrackerTester{
	private ChessBoard testChessBoard; 
	private Blank[] blanksForBacktracker;
	private ArrayList<String> arrayListForBacktracker;
	
	@Before
	public void setUp(){
		this.testChessBoard = new ChessBoard();
		
		this.blanksForBacktracker = testChessBoard.getArrOfBlanks();
		
		this.arrayListForBacktracker = new ArrayList<String>();
		for (int counter = 0; counter < 8; counter++){
			arrayListForBacktracker.add(counter);
		System.out.println(this.testChessBoard.toString()); 
	}

	@Test
	public void testBacktracker(){	
		try{
			Backtracker bt = new Backtracker(blanksForBacktracker, arrayListForBacktracker, testChessBoard);
			Coordinate[] ans = (Coordinate[]) bt.runBacktracker();
			testChessBoard.printChessBoard();
		}
		catch(UnsolveableException e) {
			System.out.println(e.getMessage()); 
		}
		 
	}
	
}	

//javac -cp .;C:\junit\junit-4.10.jar BacktrackerTester.java
//java -cp .;C:\junit\junit-4.10.jar org.junit.runner.JUnitCore BacktrackerTester
