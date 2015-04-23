package Ferry;

import java.util.ArrayList;

public abstract class Vehicle {
	private ArrayList<Passenger> passengers = new ArrayList<Passenger>();
	private int space;
	private int fee;
	
	public Vehicle(ArrayList<Passenger> p, int s, int staticFee, int feePerPass){
		if(p.size() >0){
			for(int i = 0; i < p.size(); i++){
				this.passengers.add(p.get(i));
			}
			this.space = s;
			this.fee = setFee(staticFee, feePerPass);
		}
		else{
			System.out.println("The vehicle has too many passengers. Try again.");
			System.out.println("");
		}
	}
	
	private int setFee(int staticFee, int feePerPassenger){
		return staticFee + (feePerPassenger *this.passengers.size());
	}
	
	public String toString(){
		return "Passengers: "+passengers.size()+" Space: "+space+" Fee: "+fee;
	}
	
	public int getFee(){
		return fee;
	}
	
	public int getPassengers(){
		return passengers.size();
	}
	
	public int getSpace(){
		return space;
	}
	
}
