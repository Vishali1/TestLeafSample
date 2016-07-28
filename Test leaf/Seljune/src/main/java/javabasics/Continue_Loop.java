package javabasics;

public class Continue_Loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int i;
for(i=0;i<=10;i++)
{
	
	
	if(i==5)
	
		continue;

	System.out.println("Count is " +i);
}

for (i=0;i<=5;i++)
{
	if(i==5)
	System.out.println("The skipped value of i is  " +i);	
	continue;
	}

}
}
