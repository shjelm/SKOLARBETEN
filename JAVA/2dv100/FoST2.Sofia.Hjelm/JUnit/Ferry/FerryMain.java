package Ferry;

public class FerryMain {

	public static void main(String[] args) {
		FerrySystem ferry = new FerrySystem();
		
		Vehicle bus = new Bus(12);
		Vehicle bicycle = new Bicycle();
		Vehicle car = new Car(2);
		Vehicle lorry = new Lorry(1);
		
		Passenger pass = new Passenger();
		
		for(int i = 0; i <4; i++){
			if(ferry.hasSpaceFor(bus)){
				ferry.embark(bus);
			}
			if(ferry.hasSpaceFor(bicycle)){
				ferry.embark(bicycle);
			}
			if(ferry.hasSpaceFor(car)){
				ferry.embark(car);
			}
			if(ferry.hasSpaceFor(lorry)){
				ferry.embark(lorry);
			}
			for(int x = 0; x < 2; x++){
				if(ferry.hasRoomFor(pass)){
					ferry.embark(pass);
				}
				else{
					System.out.println("The ferry is full. You can't enter!");
					break;
				}
			}
		}
		System.out.println(ferry.toString());
		
		System.out.println("====DISEMBARK====");
		ferry.disembark();
		System.out.println(ferry.toString());
		
		System.out.println("====EMBARK====");
		for(int i = 0; i <6; i++){
			if(ferry.hasSpaceFor(bus)){
				ferry.embark(bus);
			}
			if(ferry.hasSpaceFor(bicycle)){
				ferry.embark(bicycle);
			}
			if(ferry.hasSpaceFor(car)){
				ferry.embark(car);
			}
			if(ferry.hasSpaceFor(lorry)){
				ferry.embark(lorry);
			}
			for(int x = 0; x < 15; x++){
				if(ferry.hasRoomFor(pass)){
					ferry.embark(pass);
				}
				else{
					System.out.println("FULLT");
					break;
				}
			}
		}
		
		System.out.println(ferry.toString());
	}
}
