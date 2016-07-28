package javabasics;

public class Returning_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String aMake[]= ReturnArray();
for(int i=0;i<=aMake.length-1;i++)
	System.out.println("Print all the values of an array----->" +aMake[i]);
	}
public static String[] ReturnArray()
{
String[] aArray={"BMW","AUDI","TOYOTA","SUZUKI","HONDA"};
return aArray;
}
}
