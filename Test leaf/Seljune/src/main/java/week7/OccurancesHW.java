package week7;

public class OccurancesHW {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

String check = "Amazon Development Center";
		
		// Solution 1
		
		// Find the length of the String :{{length}}
		// Move to each character item :{{charAt[i]}}
		// Check if it has the expected character, if yes -> count ++
		
		int occuranceOfN = 0;
		char[] charArray = check.toCharArray();
		for (char c : charArray) {
			// don't use equals here
			if(c=='n'){
				occuranceOfN ++;
			}
		}		
		
		System.out.println("Occurance of n is :" +occuranceOfN);
		
		
		int occuranceOfM = 0;
		char[] charArrayM = check.toCharArray();
		for (char c : charArrayM) {
			// don't use equals here
			if(c=='m'){
				occuranceOfM ++;
			}
		}		
		
		System.out.println("Occurance of m is :" +occuranceOfM);
		
		
		
	}

}
