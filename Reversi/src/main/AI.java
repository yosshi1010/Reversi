package main;

public class AI {
	private Bord myBord;
	private int myColor;
	private String myName;
	AI(String name, Bord bord, int color){
		myBord = bord;
		myColor = color;
		myName = name;
	}
	
	public void put(){
		System.out.println("敵が打ちます");
		for (int i = 0; i < 8; i++){
			for (int j = 0; j < 8; j++){
				if (myBord.put(i, j, myColor)){
					System.out.println("打ち終わりました");
					return;
				}
			}
		}
	}
	
	public void pass(){
		
	}
}