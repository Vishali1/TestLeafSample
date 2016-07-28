package javabasics;

public class For_loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int increment;
		
		
		System.out.println("<-----First count----->");
		for(increment=0;increment<=5;increment++)
		{
			System.out.println("Count is " +increment);
		}
		System.out.println("<-----Second count----->");
		
		int Decrement;
		for(Decrement=5;Decrement>=0;Decrement--);
		{
			System.out.println("Count is " +Decrement);
		
		}
		System.out.println("<-----Third count----->");
		for(increment=0; increment<=5; increment+=2)
		{
			System.out.println("Count is " +increment);
			
		}
	}
	

}
