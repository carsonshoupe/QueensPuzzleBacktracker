class ChessRow extends Blank<String []>{
	//Instance Variables: 
	protected int rowLength; 
	protected int queenLocation;
	
	
	//Constructors: 
	ChessRow(int rowLength){
		this.rowLength = rowLength;
		value = new String[rowLength]; 
		this.value[0] = "Q";
		for (int counter = 1; counter < this.rowLength; counter ++){
			this.value[counter] = "_"; 
		}
		this.queenLocation = 0; 
	}
	
	//Methods:
	public String [] getRow(){return this.value;}
	public void setRow(String inputRow){this.value = inputRow;}
	public int getQueenLocation(){return this.queenLocation;}
	public void setQueenLocation(int inputQueenLocation){this.queenLocation = inputQueenLocation;}
	
	public int findQueen(){
		for (int counter = 0; counter < this.rowLength; counter++){
			if (this.value[counter].equals("Q")){
				return counter;
			}
		}
		return -1; 
	}
	
}