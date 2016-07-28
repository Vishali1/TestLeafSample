package javaTutorials;

public class Constructor_Private {
	
	//Class Member Variables & Fields
    //Private variables  
	
private String sModel;
private int iMake;
private int iGear;
int iHighestSpeed;
String sColor;
boolean bLeftHandDrive;
String sTransmission;
int iTyres;
int iDoors;

//Default values set in Constructor

public Constructor_Private()
{
	sModel= "Camry";
	iMake= 2013;
	iGear=5;
}

public void DisplayCharacteristics()
{
	System.out.println("Model of the Car: " +  sModel);
	System.out.println("Number of gears in the Car: " +  iGear);
	System.out.println("Max speed of the Car: " +  iHighestSpeed);
	System.out.println("Color of the Car: " +  sColor);
	System.out.println("Make of the Car: " +  iMake);
	System.out.println("Transmission of the Car: " +  sTransmission);

}
	public static void main(String[] args) {
		
		
		//Use the Constructor_Private keyword to declare Constructor_Private Class variable
 Constructor_Private Renault= new Constructor_Private();
 Renault.iDoors = 4;
	Renault.iHighestSpeed = 200;
	Renault.iTyres = 4;
	Renault.sColor = "Black";
	Renault.sTransmission = "Manual";
	Renault.bLeftHandDrive = true;

	//Using Car class method
	Renault.DisplayCharacteristics();

	}

}
