package Point;

public class Point {
	private int xCoord = 0;
	private int yCoord = 0;
	
	public Point(){
		xCoord = 0;
		yCoord = 0;
	}

	public Point(int x, int y){
		xCoord = x;
		yCoord = y;
	}
	
	//Checks if two points have the same coordinates
	public boolean isEqualTo(Point p2){
		if(xCoord == p2.xCoord && yCoord == p2.yCoord){
			return true;
		}
		return false;
	}
	
	//Computes distance between two points
	public double distanceTo(Point p2){
		double distance = 
				Math.sqrt((xCoord-p2.xCoord)*(xCoord-p2.xCoord) 
						+ (yCoord-p2.yCoord)*(yCoord-p2.yCoord));
		return distance;
	}

	//Moves the point x in x-axis and y in y-axis
	public void move(int x, int y){
		xCoord +=x;
		yCoord +=y;
		
	}
	
	//Moves the point to (x,y)
	public void moveToXY(int x, int y){	
		xCoord = x;
		yCoord = y;
	}
	
	public String toString(){
		return "("+xCoord+","+yCoord+")";
	}
	
	public static void main(String[] args) {
		Point p1 = new Point();
		Point p2 = new Point(3,4);
				
		System.out.println(p1.toString());   // ==> (0,0)
		System.out.println(p2.toString());   // ==> (3,4)
				
		if (p1.isEqualTo(p2))              // False!
			System.out.println("The two points are equal");
				
		double dist = p1.distanceTo(p2);
		System.out.println("Point Distance: "+dist); // ==> 5.0
				
		p2.move(5,-2);         // ==> (8,2)
		p1.moveToXY(8,2);      // ==> (8,2)
				
		if (p1.isEqualTo(p2))              // True!
			System.out.println("The two points are equal");
	}

}
