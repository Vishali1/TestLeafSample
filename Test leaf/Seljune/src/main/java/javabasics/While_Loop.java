package javabasics;

public class While_Loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int Count=0;
while(Count<25)
{
	Count=Count+5;
	System.out.println("Count is  "  +Count);
	}

int uncount=25;
System.out.println("<==== Next Count ====>");
while(uncount<25)
{
	uncount=uncount+5;

	System.out.println("Uncount is not printed, it exits the while loop" + uncount);
}
	}

}
