package main;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Game implements MouseListener{
	private Bord myBord = new Bord();
	private Frame myFrame = new Frame("Reversi", myBord);
	private int precedence;
	private Player player;
	private AI enemy, enemy2;
	private int turn = 1;
	
	public void Start(){
		init();
		setPrecedence(); //先行を決める
		createPlayer(); //プレイヤー作成
		createAI(); //敵作成
		
		
		while(true){
			enemy.put();
			myFrame.repaint();
			if (!myBord.checkEnd()){
				break;
			}
			try{
				Thread.sleep(150);
			}catch(InterruptedException a){};
			enemy2.put();
			myFrame.repaint();
			if (!myBord.checkEnd()){
				break;
			}
		}
		/*if (turn % 2 != player.getPrecedence()){
			enemy.put();
			myFrame.repainting();
			turn++;
		}*/
	}
	
	private void createPlayer(){
		if (precedence == 0){
			System.out.println("Player is white.");
			System.out.println("後行");
			player = new Player("player1", myBord, Bord.WHITE, precedence);
		}else{
			System.out.println("Player is black.");
			System.out.println("先行");
			player = new Player("player1", myBord, Bord.BLACK, precedence);
		}
	}
	
	private void createAI(){
		if (precedence == 0){
			enemy = new AI("enemy1", myBord, Bord.BLACK);
			enemy2 = new AI("enemy2", myBord, Bord.WHITE);
		}else{
			enemy = new AI("enemy1", myBord, Bord.WHITE);
			enemy2 = new AI("enemy2", myBord, Bord.BLACK);
		}
	}
	
	private void init(){
		myFrame.addMouseListener(this);
	}
	
	public void setPrecedence(){
		Random rnd = new Random();
		precedence = rnd.nextInt(2);
	}
	
	public void mouseClicked(MouseEvent e){
		Point point = e.getPoint();
		if (turn % 2 == player.getPrecedence()){
			System.out.println(point.x / 50 + ", " + (point.y - 26) / 50);
			if (player.put(point.x / 50, (point.y - 26) / 50)){
				myFrame.repaint();
				turn++;
				try{
					Thread.sleep(50);
				}catch(InterruptedException a){}
				enemy.put();
				myFrame.repaint();
				turn++;
			}
		}
	 }

	  public void mouseEntered(MouseEvent e){}
	  public void mouseExited(MouseEvent e){}
	  public void mousePressed(MouseEvent e){}
	  public void mouseReleased(MouseEvent e){}
}
