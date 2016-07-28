package javaprograms;

public class Odd_Even_Numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int i;
		
		for(i=1;i<=100;i++)
		{
		
	if(i%2==0)
	{
		System.out.println("Even number " +i);
	}

		else if( i%2!= 0)
		{
			System.out.println("Odd number " +i);
		}
		else
		{
			System.out.println("Number is not Even/Odd");
		}
}

	}

}

