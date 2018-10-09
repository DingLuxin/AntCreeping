package main;
public class CreepingGame {

	void playGame(Ant[] ants) {

		while (!Ant.isOver()) {
			Ant.timeGo();			
			for (int i = 0; i < ants.length; i++) {
				ants[i].step(1);
			}			
			changeDirection(ants);
		}
	}
	
	void changeDirection(Ant[] ants) {
		for (int j = 0; j < ants.length - 1; j++) {
			// 碰头只可能发生在左边那只向右，右边向左的情况---且都在杆上
			if (!ants[j].isLeft() && ants[j + 1].isLeft() && !ants[j].isIsDown() && !ants[j + 1].isIsDown()) {
				// 根据位置判断：碰头撞头
				// 1刚好相碰--换方向
				if (ants[j].getLocation() == ants[j + 1].getLocation()) {
					ants[j].turnAround();
					ants[j + 1].turnAround();
				}
				// 2在中间相碰--回退一步且换方向
				if (ants[j].getLocation() > ants[j + 1].getLocation()) {
					ants[j].step(-1);
					ants[j + 1].step(-1);
					ants[j].turnAround();
					ants[j + 1].turnAround();
				}
			}		
		}
	}


}
