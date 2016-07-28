package testleaf;

public class Week1_Fibnocci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int n1=0, n2=1, num;

System.out.print(n1+" "+n2);


for(int i=0;i<100;i++)
{
	
num=n1+n2;

System.out.println(num+ " ");


n1=n2;
n2=num;
	}
}

	}


