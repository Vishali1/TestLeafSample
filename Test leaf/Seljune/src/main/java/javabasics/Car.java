package javabasics;

public class Car {
	
	String sModel;
	int iGear;
	int iHighestSpeed;
	String sColor;
	int iMake;
	boolean bLeftHandDrive;
	String sTransmission;
	int iTyres;
	int iDoors;
	
	public void DisplayCharacteristics()
	{
		System.out.println("Model of a car: " +sModel);
		System.out.println("Gear of a car: " +iGear);
		System.out.println("Highest speed of the car: " +iHighestSpeed);
		System.out.println("Color of the car: " +sColor);
		System.out.println("Make of the car: " +iMake);
		System.out.println("Transmission of the car: " +sTransmission);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car Toyota = new Car();
		 
		Toyota.bLeftHandDrive = true;
		Toyota.iDoors = 4;
		Toyota.iGear = 5;
		Toyota.iHighestSpeed = 200;
		Toyota.iMake = 2014;
		Toyota.iTyres = 4;
		Toyota.sColor = "Black";
		Toyota.sTransmission = "Manual";
		Toyota.sModel = "Camry";
 
		//Using Car class method
		Toyota.DisplayCharacteristics();

	}

}
