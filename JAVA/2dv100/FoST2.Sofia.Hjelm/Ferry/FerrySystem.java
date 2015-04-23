package Ferry;

import java.util.ArrayList;
import java.util.Iterator;

public class FerrySystem implements Ferry {
	private final static int MAX_PASSENGERS = 200;
	private final static int MAX_SPACE_IN_BICYCLES = 200;
	
	private int space; 
	private int passengers;
	private int fee;
	private int numberOfVehicles;
	
	private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	

	@Override
	public int countPassengers() {
		return passengers;
	}

	@Override
	public int countVehicleSpace() {
		return space;
	}

	@Override
	public int countMoney() {
		return fee;
	}

	@Override
	public Iterator iterator() {
		return new FerryIterator();
	}

	@Override
	public void embark(Vehicle v) {
		vehicles.add(v);
		passengers += v.getPassengers();
		space += v.getSpace();
		fee += v.getFee();
		numberOfVehicles++;
	}

	@Override
	public void embark(Passenger p) {
		passengers += p.getPassenger();		
		fee += p.getFee();
	}

	@Override
	public void disembark() {
		space = 0;
		passengers = 0;		
		numberOfVehicles = 0;
	}

	@Override
	public boolean hasSpaceFor(Vehicle v) {
		if(space + v.getSpace() <= MAX_SPACE_IN_BICYCLES && passengers + v.getPassengers() <= MAX_PASSENGERS){
			return true;
		}
		return false;
	}

	@Override
	public boolean hasRoomFor(Passenger p) {
		if(passengers + p.getPassenger() <= MAX_PASSENGERS){
			return true;
		}
		return false;
	}
	
	@Override
	public String toString(){
		return "Number of vehicles: "+numberOfVehicles+"\nSpace used: "+countVehicleSpace()+"\nNumber of passengers: "
				+countPassengers()+"\nMoney earned: "+countMoney();
		
	}
	
	class FerryIterator implements Iterator<Vehicle> {
		private int count = 0;
		
		public Vehicle next() {
			Vehicle []veh = new Vehicle[vehicles.size()];
			vehicles.toArray(veh);
			return veh[count++];
			}
		
		public boolean hasNext() {return count<numberOfVehicles;}
		
		public void remove() {
			throw new RuntimeException("remove() is not implemented");
		}
	}

}
