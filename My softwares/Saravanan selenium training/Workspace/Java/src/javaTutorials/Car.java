package javaTutorials;

public class Car {
	
	//Class Member Variables & Fields
	String sModel;
	int iGear;
	int iHighestSpeed;
	int iDoors;
	int iMake;
	int iTyres;
	String sColor;
	String sTransmission;
	boolean bLeftHandDrive;
	
	public Car(String Model, int Make, boolean LeftHandDrive)
	{
	sModel= Model;
	iMake= Make;
	bLeftHandDrive= LeftHandDrive;
	}
	
	
	public void DisplayCharacteristics()
	{
	System.out.println("Model of the Car: " +  sModel);
	System.out.println("Number of gears in the Car: " +  iGear);
	System.out.println("Max speed of the Car: " +  iHighestSpeed);
	System.out.println("Color of the Car: " +  sColor);
	System.out.println("Make of the Car: " +  iMake);
	System.out.println("Transmission of the Car: " +  sTransmission);
	System.out.println("No of Tyres: " +  iTyres);
	}
	public static void main(String[] args) {
		
		Car Toyota= new Car("Renault",2013,true);
		
		Toyota.iDoors=4;
		Toyota.iGear=5;
		Toyota.iHighestSpeed=500;
		Toyota.iTyres=4;
		Toyota.sTransmission="Manual";
		Toyota.sColor="Green";
		

		//Using Car class method
				
		Toyota.DisplayCharacteristics();
		
			
		}
	}


