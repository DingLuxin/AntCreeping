package main;
import javax.swing.*;

import java.awt.*;

import static java.lang.Math.pow;

public class PlayRoom {
	private static int getMaxState = 0;  //记录最大时间蚂蚁的方向
	private static int getMinState = 0;  //记录最小时间蚂蚁的方向
	private static double minTime = 0.0; //记录最短用时
	private static double maxTime = 0.0; //记录最长用时
	


	public boolean[][] buildDirections(Ant[] ant) {
		int countState = (int) pow(2,ant.length);
		boolean[][]  states= new boolean[countState][ant.length];
		for (int i = 0; i < countState; i++) { // 标记每种情况蚂蚁的朝向
			for (int j = 0; j < ant.length; j++) {
				states[i][j] = ((i & (1 << j)) == 0);
			}
		}
		return states;
	}

	public void playGames(int speed, int[] location, Trunk mytrunk) {
		getMaxState = 0;
		getMinState = 0;

		CreepingGame creep = new CreepingGame();

		Ant[] ants = new Ant[location.length];
		Ant.setNum(location.length);
		Ant.setVelocity(speed);
		Ant.setRIGHT_END(mytrunk.getLength());

		for (int i = 0; i < location.length; i++) {
			ants[i] = new Ant(location[i]);
		}
		boolean[][] states = buildDirections(ants); // 初始化所有情况的方向
		double[] recordTime = new double[states.length]; // 记录每种情况的时间
		for (int s = 0; s < states.length; s++) {
			recordTime[s] = 0.0;
		}

		for (int i = 0; i < states.length; i++) { //执行一遍所有的情况
			Ant.setTime(0.0);
			Ant.setNumOfDown(0);

			for (int j = 0; j < ants.length; j++) {
				ants[j].setLocation(location[j]);
				ants[j].setLeft(states[i][j]);
				ants[j].setIsDown(false);
			}

			creep.playGame(ants);
			recordTime[i] = Ant.getTime();  //将每次情况的用时存在数组里
		}
		double tem1 = recordTime[0]; 
		double tem2 = recordTime[0];
		for (int s = 0; s < states.length; s++) {  //判断最大最小时间
			if (recordTime[s] < tem1) {
				tem1 = recordTime[s];
				getMinState = s;   
			}
			if (recordTime[s] > tem2) {
				tem2 = recordTime[s];
				getMaxState = s;  
			}
		}
		minTime=tem1;
		maxTime=tem2;
	}

    
	public double returnMax() {
		return (double)Math.round(maxTime*100)/100;
	}

	public double returnMin() {	 
		return (double)Math.round(minTime*100)/100;
	}

	public static void main(String[] args) {
		PlayRoom pr = new PlayRoom();
		Trunk mytrunk = new Trunk(300);
		int[] location = {30,80,110,160,250};		
		pr.playGames(5, location, mytrunk);
		System.out.println(pr.returnMax());
		System.out.println(pr.returnMin());
	}

}
