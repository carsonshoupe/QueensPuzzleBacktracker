import java.util.Arrays;

class ChessRow extends Blank<Integer>{
	//Instance Variables: 
	protected int rowLength; 
	protected int columnNum; 
	
	
	//Constructors: 
	ChessRow(int rowLength, int columnNum){
		this.rowLength = rowLength;
		this.columnNum = columnNum; 
	}
	
	//Methods:
	public int getRowLength(){return this.rowLength;}
	public void setRowLength(int rowLength){this.rowLength = rowLength;}
	public Integer getQueenLocation(){return this.value;}
	public void setQueenLocation(int inputQueenLocation){this.value = inputQueenLocation;}
	public int getColumnNum(){return this.columnNum;}
	public void setColumnNum(int columnNum){this.columnNum = columnNum;}
	
	@Override
	public String toString(){
		if (value == null){
			String returnString = ""; 
			for (int counter = 0; counter < rowLength; counter++){
				returnString = returnString + "_ "; 
			}
			returnString = returnString + "\n";
			return returnString; 
		}
		else{
			String returnString = ""; 
			for (int counter = 0; counter < this.rowLength; counter++){
				if (counter == this.value){
					returnString = returnString + "Q ";
				}
				else{
					returnString = returnString + "_ ";
				}
			}
			returnString = returnString + "\n"; 
			return returnString;
		}
	}
	
}