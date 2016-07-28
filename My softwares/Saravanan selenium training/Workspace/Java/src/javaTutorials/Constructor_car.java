package javaTutorials;

public class Constructor_car {
	
	int iGear;
	int iMake;
	int iTyres;
	int iDoors;
	String sModel;
	String sTransmission;
	String sColor;
	
	public Constructor_car()
	{
		iGear=5;
		iMake=2013;
		sModel="Renault";	
	}
	
	public void DisplayCharacteristcis()
	{
		System.out.println("Model of a Car " +sModel);
		System.out.println("Make of the Car " +iMake);
		System.out.println("No of Doors of a Car " +iDoors);
		System.out.println("No of Gears of a Car " +iGear);
		System.out.println("No of tyres of a Car " +iTyres);
		System.out.println("Transmission of a car " +sTransmission);
		System.out.println("Color of a Car " +sColor);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Constructor_car Renault=new Constructor_car();
		
		Renault.iDoors=4;
		Renault.iTyres=4;
		Renault.sColor="Yellow";
		Renault.sTransmission="Manual";
Renault.DisplayCharacteristcis();
	}

}
