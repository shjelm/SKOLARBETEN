package Fraction;

public class FractionMain {
	//Test for Fraction
	public static void main(String[] args) throws Exception {
		Fraction frac1 = new Fraction(1,2);
		Fraction frac2 = new Fraction(3,4);
		Fraction negFrac = new Fraction (-2,5);
		Fraction eqFrac = new Fraction (4,8);
		
		System.out.println(frac1.toString()); // =>1/2
		System.out.println(negFrac.toString());// =>-2/5
		
		System.out.println(frac1.getNumerator()); // =>1
		System.out.println(frac1.getDenominator()); // =>2
		
		System.out.println(frac1.isNegative()); // => false!
		System.out.println(negFrac.isNegative()); // => true!
		
		System.out.println(frac1.add(frac1, frac2)); // => 10/8
		System.out.println(frac1.subtract(frac1, frac2)); // => -2/8
		System.out.println(frac1.multiply(frac1, frac2)); // => 3/8
		System.out.println(frac1.divide(frac1, frac2)); // => 4/6
		
		System.out.println(frac1.isEqualTo(frac1, frac2)); // false
		System.out.println(frac1.isEqualTo(frac1, eqFrac)); // true		

	}

}
