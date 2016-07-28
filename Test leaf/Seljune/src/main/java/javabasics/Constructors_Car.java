package javabasics;
public class Constructors_Car {
	//Class Member Variables & Fields
	String sModel;
    int iGear;
    int iHighestSpeed;
    String sColor;
    int iMake;
    boolean bLeftHandDrive;
    String sTransmission;
    int iTyres;
    int iDoors;
 
    //Constructor with values passed
    public Constructors_Car(String Model, int Make,boolean LeftHandDrive ){
    	sModel = Model;
    	iMake = Make;
    	bLeftHandDrive = LeftHandDrive;
    }
 
    //Method
    public void DisplayCharacterstics(){
    	System.out.println("Model of the Car: " +  sModel);
    	System.out.println("Number of gears in the Car: " +  iGear);
    	System.out.println("Max speed of the Car: " +  iHighestSpeed);
    	System.out.println("Color of the Car: " +  sColor);
    	System.out.println("Make of the Car: " +  iMake);
    	System.out.println("Transmission of the Car: " +  sTransmission);
 
    }
 
public static void main(String[] args)
{
	
//Use the Car keyword to declare Car Class variable
//Passing values to the constructor
	Constructors_Car Toyota = new Constructors_Car("Camry",2014,true);

Toyota.iDoors = 4;
Toyota.iGear = 5;
Toyota.iHighestSpeed = 200;
Toyota.iTyres = 4;
Toyota.sColor = "Black";
Toyota.sTransmission = "Manual";

//Using Car class method
Toyota.DisplayCharacterstics();
}

}
