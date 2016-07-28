package javabasics;

public class Break_Loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int i;

for(i=0;i<=10;i++)
{

	if(i==6)
	{
		break;
	}
	System.out.println("Count is " +i);
	}
System.out.println("You have exited the loop");
	}

}
