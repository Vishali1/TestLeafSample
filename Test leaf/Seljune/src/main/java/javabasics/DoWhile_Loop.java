package javabasics;

public class DoWhile_Loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int count=0;
do
{

	count=count+5;
	System.out.println("Count---->" +count);
}
while(count<25);

int CountOnce=25;

System.out.println("<----Next count---->");
do
{
	CountOnce=CountOnce+5;
	System.out.println("CountOnce is ---->" +CountOnce);
}

while(CountOnce<25);

}
	
}


