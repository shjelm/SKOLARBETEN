package Fraction;

public class Fraction {
	private int n = 0;
	private int d = 0;
	
	//Constructor, dIn != 0
	public Fraction(int nIn, int dIn) throws Exception{
		n = nIn;
		if(dIn != 0){
			d = dIn;
		}
		else{
			throw new Exception("The denominator must not be 0");
		}
	}
	
	public int getNumerator(){
		return n;
	}
	
	public int getDenominator(){
		return d;
	}
	
	public boolean isNegative(){
		boolean isNeg = false;
		
		if(n < 0 || d <0){
			isNeg = true;
		}
		return isNeg;
	}
	
	public Fraction add(Fraction frac1, Fraction frac2) throws Exception{
		int x = 0, y = 0;
		if(frac1.d != 0 || frac2.d != 0){
			x = frac1.n*frac2.d + frac2.n * frac1.d;
			y = frac1.d*frac2.d;
		}
		else{
			throw new Exception("D must not be equal to 0");
		}
		return new Fraction(x,y);
	}
	
	public Fraction subtract(Fraction frac1, Fraction frac2) throws Exception{
		int x = 0, y = 0;
		if(frac1.d != 0 || frac2.d != 0){
			x = frac1.n* frac2.d - frac2.n *frac1.d;
			y = frac1.d * frac2.d;
		}
		else{
			throw new Exception("D must not be equal to 0");
		}
		return new Fraction(x, y);
	}
	
	public Fraction divide(Fraction frac1, Fraction frac2) throws Exception{
		int x = 0, y = 0;
		if(frac1.d != 0 || frac2.d != 0){
			x = frac1.n*frac2.d;
			y =frac1.d*frac2.n;
		}
		else{
			throw new Exception("D must not be equal to 0");
		}
		return new Fraction(x,y);
	}
	
	public Fraction multiply(Fraction frac1, Fraction frac2) throws Exception{
		int x = 0, y = 0;
		if(frac1.d != 0 || frac2.d != 0){
			x = frac1.n*frac2.n;
			y = frac1.d*frac2.d;
		}
		else{
			throw new Exception("D must not be equal to 0");
		}
		return new Fraction(x, y);
	}
	
	public boolean isEqualTo(Fraction frac1, Fraction frac2){		
		double x = (double)frac1.n/(double)frac1.d;
		double y = (double)frac2.n/(double)frac2.d;
		
		if(x==y){
			return true;
		}		
		return false;
	}
	
	public String toString(){
		return n+"/"+d;
	}	

}
