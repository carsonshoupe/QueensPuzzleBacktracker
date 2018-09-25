import java.util.Arrays;

abstract class Backtracker<V>{
	//Instance Variables: 
	protected Blank[] blanks; 
	protected V[] checkValues; 
	protected BacktrackableObject board; 
		
	
	//Methods:
	public Blank[] getBlanks(){return this.blanks;}
	public V[] getCheckValues(){return this.checkValues;}
	public BacktrackableObject getBoard(){return this.board;}
	public void setBlanks(Blank[] inputBlanks){this.blanks = inputBlanks;}
	public void setCheckValues(V[] inputCheckValues){this.checkValues = inputCheckValues;}
	public void setBacktrackableObject(BacktrackableObject inputBoard){this.board = inputBoard;} 
	
	public abstract boolean checkValueAtBlank(V checkValue, Blank inputBlank);
	//give checkValueAtBlank a value and a blank, and it tells you whether that value meets the conditions you provide it. 
	
	public Blank[] runBacktracker() throws UnsolveableException{
		int blankTracker = 0; 
		while (blankTracker < blanks.length){
			System.out.println(blanks[blankTracker].toString());
			if (blankTracker == -1){ //Quick exception check//
				throw new UnsolveableException("There is no combination of values that makes this board work.");
			}				
			
			if (findWorkingValueForBlank(blanks[blankTracker]) == true){
				blankTracker++;
			}
			else{
				blanks[blankTracker].setValue(null); 
				blankTracker--; 
			}
		}
		return this.blanks; 
	}
	
	public boolean findWorkingValueForBlank(Blank inputBlank){
		//Finds and sets a working value for a blank
		int checkValuesIndex = -1; 
		if (inputBlank.getValue() == null){
			checkValuesIndex = 0; 
		}
		else{
			for (int finder = 0; finder<checkValues.length; finder++){
				if (checkValues[finder].equals(inputBlank.getValue())){
					checkValuesIndex = finder; 
				}
			}
		}
		
		while (checkValuesIndex < this.checkValues.length){
			//System.out.println("checkValuesIndex: " + checkValuesIndex);
			//System.out.println("checkValue: " + checkValues[checkValuesIndex]);
			if (checkValueAtBlank(checkValues[checkValuesIndex], inputBlank) == true){
				inputBlank.setValue(checkValues[checkValuesIndex]); 
				return true; 
			}
			else{
				checkValuesIndex++;
			}
		}
		return false;
	}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
				