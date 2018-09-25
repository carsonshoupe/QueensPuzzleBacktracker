class Queen{
	//Instance Variables: 
	private int queenID;
	private Coordinate location;
	
	//Constructors:
	Queen(int ID){
		this.queenID = ID; 
	}
	
	//Methods:
	public int getQueenID(){return this.queenID;}
	public void setQueenID(int ID){this.queenID = ID;}
	
	public Coordinate getQueenLocation(){return this.location;}
	public void setQueenLocation(Coordinate inputCoordinate){this.location = inputCoordinate;}
	
	@Override
	public String toString(){
		String outputString = "Q" + queenID; 
		return outputString;
	}
	
	
	
	
	
}