package main;

public class Ant {
	private int location;// 蚂蚁的位置，每种情况开始走之前要初始化位置
	private boolean isLeft = true;// 默认左
	private boolean isDown = false;// 在杆上

	private static int velocity;// 蚂蚁速度
	private static int num;// 蚂蚁数目
	private static int numOfDown;// 记录每种情况有多少只蚂蚁已经离开
	private static int length;// 标记细杆的长度
	private static double time;// 记录每种情况走的时间

	public Ant(int location) {// 构造函数
		this.location = location;
	}

	public void step(int i) {// 蚂蚁怎样走
		if (!isDown) {// 判断蚂蚁是否在杆上
			if (isLeft) {
				location -= i;
			} else {
				location += i;
			}
			if (location <= 0 || location >= length) {// 判断蚂蚁是否离开杆
				isDown = true;// 标记已不在细杆上
				numOfDown++;// 离开的蚂蚁数量加1
			}
		}
	}

	public static void setNum(int num) {// 设置蚂蚁总数
		Ant.num = num;
	}

	public int getLocation() {// 获得蚂蚁位置，是否碰头或者撞头
		return location;
	}

	public void setLocation(int location) {// 每种情况初始化蚂蚁的位置
		this.location = location;
	}

	public boolean isLeft() {
		return isLeft;
	}

	public void setLeft(boolean isLeft) {// 转向
		this.isLeft = isLeft;
	}

	public boolean isIsDown() {// 判断蚂蚁是否掉落
		return isDown;
	}

	public void setIsDown(boolean isDown) {
		this.isDown = isDown;
	}

	public static boolean isOver() {// 判断蚂蚁是否全部离开细杆
		return numOfDown == num;
	}

	public static void setNumOfDown(int numOfDown) {// 初始化离杆蚂蚁的数量
		Ant.numOfDown = numOfDown;
	}

	public static void setTime(double time) {// 初始化每种情况的时间
		Ant.time = time;
	}

	public static double getTime() {
		return time;
	}

	public void turnAround() {// 撞头或碰头时的转向
		isLeft = !isLeft;
	}

	public static void timeGo() {
		time += 1.0 / velocity;
	}

	public static int getVelocity() {
		return velocity;
	}

	public static void setVelocity(int v) {
		Ant.velocity = v;
	}

	public static void setRIGHT_END(int l) {
		Ant.length = l;
	}
}
