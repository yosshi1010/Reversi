package main;

public class Player{
	private String myName = "player1";
	private Bord myBord;
	private int myColor;
	private int precedence;
	
	Player(String name, Bord bord, int color, int pre){
		myName = name;
		myColor = color;
		myBord = bord;
		precedence = pre;
	}
	
	public boolean put(int x, int y){
		return myBord.put(x, y, myColor);
	}
	
	public int getPrecedence(){
		return precedence;
	}
	
	public void pass(){
		
	}
}
