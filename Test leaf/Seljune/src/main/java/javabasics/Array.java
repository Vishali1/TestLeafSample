package javabasics;

public class Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String[] aMake= {"BMW","AUDI","TOYOTA","SUZUKI","HONDA"};

//This is to store the size of the Array
int iLength= aMake.length;
System.out.println("Length of an array----->" +iLength);

//This is to access the first element of an array directly with it's position
String sBMW= aMake[0];
System.out.println("The first value of an array----->" +sBMW);

//This is to access the last element of an Array
String sHonda= aMake[iLength-1];
System.out.println("The Last value of an array----->" +sHonda);


//This is to print all the element values of an Array
for(int i=0;i<=iLength-1;i++)
{
	System.out.println("The values in the array----->" +aMake[i]);
}
	}
}

