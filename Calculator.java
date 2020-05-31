import java.util.*;

public class Calculator {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input X: ");
		String inputX = sc.nextLine();
		System.out.println("Input Y: ");
		String inputY = sc.nextLine();
		String temp;
		if (inputX.charAt(0) == '-' && inputY.charAt(0)=='-') { // 모두 음수
			inputX = inputX.substring(1,inputX.length());
			inputY = inputY.substring(1,inputY.length());
			if (inputX.length()<inputY.length()) { //inputX 길이 < inputY 길이
				temp=inputX;
				inputX = inputY;
				inputY = temp;
				System.out.print("X+Y = -" );
				add(inputX, inputY);
				System.out.println();
				System.out.print("X-Y = ");
				sub(inputX, inputY);
				System.out.println();
				System.out.print("X*Y = ");
				mult(inputX,inputY);
			} //inputX 길이 < inputY 길이
			else if (inputX.length() == inputY.length()) { // inputX 길이 == input Y길이
				int i=0;
				if (inputX.equals(inputY)) {
					System.out.print("X+Y = -" );
					add(inputX, inputY);
					System.out.println();
					System.out.print("X-Y = 0");
					System.out.println();
					System.out.print("X*Y = ");
					mult(inputX,inputY);
				}
				while (i < inputX.length()) {
					int x = Integer.parseInt(inputX.substring(i, i+1));
					int y = Integer.parseInt(inputY.substring(i, i+1));
					if (x>y) {
						System.out.print("X+Y = -" );
						add(inputX, inputY);
						System.out.println();
						System.out.print("X-Y = -");
						sub(inputX, inputY);
						System.out.println();
						System.out.print("X*Y = ");
						mult(inputX,inputY);
						break;
					}
					else if(x==y)
						i+=1;
					else {
						temp=inputX;
						inputX = inputY;
						inputY = temp;
						System.out.print("X+Y = -" );
						add(inputX, inputY);
						System.out.println();
						System.out.print("X-Y = ");
						sub(inputX, inputY);
						System.out.println();
						System.out.print("X*Y = ");
						mult(inputX,inputY);
						break;
					}		
				}
			}// inputX 길이 == input Y길이
			else {
				System.out.print("X+Y = -" );
				add(inputX, inputY);
				System.out.println();
				System.out.print("X-Y = -");
				sub(inputX, inputY);
				System.out.println();
				System.out.print("X*Y = ");
				mult(inputX, inputY);
			}// inputX길이 > inputY 길이			
		}// 모두 음수
		else if (inputX.charAt(0) != '-' && inputY.charAt(0) == '-') { // X: 양수 / Y: 음수
			inputY = inputY.substring(1,inputY.length());
			if (inputX.length()<inputY.length()) {
				temp=inputX;
				inputX = inputY;
				inputY = temp;
				System.out.print("X+Y = -" );
				sub(inputX, inputY);
				System.out.println();
				System.out.print("X-Y = ");
				add(inputX, inputY);
				System.out.println();
				System.out.print("X*Y = -");
				mult(inputX,inputY);
			} //inputX 길이 < inputY 길이
			else if (inputX.length() == inputY.length()) {
				int i=0;
				if (inputX.equals(inputY)) {
					System.out.print("X+Y = 0" );
					System.out.println();
					System.out.print("X-Y = ");
					add(inputX,inputY);
					System.out.println();
					System.out.print("X*Y = -");
					mult(inputX,inputY);
				}
				while (i < inputX.length()) {
					int x = Integer.parseInt(inputX.substring(i, i+1));
					int y = Integer.parseInt(inputY.substring(i, i+1));
					if (x>y) {
						System.out.print("X+Y = " );
						sub(inputX, inputY);
						System.out.println();
						System.out.print("X-Y = ");
						add(inputX, inputY);
						System.out.println();
						System.out.print("X*Y = -");
						mult(inputX,inputY);
						
						break;
					}
					else if(x==y)
						i+=1;
					else {
						temp=inputX;
						inputX = inputY;
						inputY = temp;
						System.out.print("X+Y = -" );
						sub(inputX, inputY);
						System.out.println();
						System.out.print("X-Y = ");
						add(inputX, inputY);
						System.out.println();
						System.out.print("X*Y = -");
						mult(inputX,inputY);
						break;
					}		
				}
			}// inputX길이 == inputY길이
			else {
				System.out.print("X+Y = " );
				sub(inputX, inputY);
				System.out.println();
				System.out.print("X-Y = ");
				add(inputX, inputY);
				System.out.println();
				System.out.print("X*Y = -");
				mult(inputX, inputY);
			}// inputX길이 > inputY 길이
			
		}// X: 양수 / Y: 음수
		else if (inputX.charAt(0) == '-' && inputY.charAt(0) != '-'){ // X : 음수 / Y: 양수
			inputX = inputX.substring(1,inputX.length());
			if (inputX.length()<inputY.length()) {
				temp=inputX;
				inputX = inputY;
				inputY = temp;
				System.out.print("X+Y = " );
				sub(inputX, inputY);
				System.out.println();
				System.out.print("X-Y = -");
				add(inputX, inputY);
				System.out.println();
				System.out.print("X*Y = -");
				mult(inputX,inputY);
			} //inputX 길이 < inputY 길이
			else if (inputX.length() == inputY.length()) {
				int i=0;
				if (inputX.equals(inputY)) {
					System.out.print("X+Y = 0" );
					System.out.println();
					System.out.print("X-Y = -");
					add(inputX, inputY);
					System.out.println();
					System.out.print("X*Y = -");
					mult(inputX,inputY);
				}
				while (i < inputX.length()) {
					int x = Integer.parseInt(inputX.substring(i, i+1));
					int y = Integer.parseInt(inputY.substring(i, i+1));
					if (x>y) {
						System.out.print("X+Y = -" );
						sub(inputX, inputY);
						System.out.println();
						System.out.print("X-Y = -");
						add(inputX, inputY);
						System.out.println();
						System.out.print("X*Y = -");
						mult(inputX,inputY);
						
						break;
					}
					else if(x==y)
						i+=1;
					else {
						temp=inputX;
						inputX = inputY;
						inputY = temp;
						System.out.print("X+Y = " );
						sub(inputX, inputY);
						System.out.println();
						System.out.print("X-Y = -");
						add(inputX, inputY);
						System.out.println();
						System.out.print("X*Y = -");
						mult(inputX,inputY);
						break;
					}		
				}
			}// inputX길이 == inputY길이
			else {
				System.out.print("X+Y = -" );
				sub(inputX, inputY);
				System.out.println();
				System.out.print("X-Y = -");
				add(inputX, inputY);
				System.out.println();
				System.out.print("X*Y = -");
				mult(inputX, inputY);
			}// inputX길이 > inputY 길이
		}// X : 음수 / Y: 양수
		else { // 모두 양수
			if (inputX.length()<inputY.length()) {
				temp=inputX;
				inputX = inputY;
				inputY = temp;
				System.out.print("X+Y = " );
				add(inputX, inputY);
				System.out.println();
				System.out.print("X-Y = -");
				sub(inputX, inputY);
				System.out.println();
				System.out.print("X*Y = ");
				mult(inputX,inputY);
			} //inputX 길이 < inputY 길이
			else if (inputX.length() == inputY.length()) {
				int i=0;
				if (inputX.equals(inputY)) {
					System.out.print("X+Y = " );
					add(inputX, inputY);
					System.out.println();
					System.out.print("X-Y = 0");
					System.out.println();
					System.out.print("X*Y = ");
					mult(inputX,inputY);
				}
				while (i < inputX.length()) {
					int x = Integer.parseInt(inputX.substring(i, i+1));
					int y = Integer.parseInt(inputY.substring(i, i+1));
					if (x>y) {
						System.out.print("X+Y = " );
						add(inputX, inputY);
						System.out.println();
						System.out.print("X-Y = ");
						sub(inputX, inputY);
						System.out.println();
						System.out.print("X*Y = ");
						mult(inputX,inputY);
						
						break;
					}
					else if(x==y)
						i+=1;
					else {
						temp=inputX;
						inputX = inputY;
						inputY = temp;
						System.out.print("X+Y = " );
						add(inputX, inputY);
						System.out.println();
						System.out.print("X-Y = -");
						sub(inputX, inputY);
						System.out.println();
						System.out.print("X*Y = ");
						mult(inputX,inputY);
						break;
					}		
				}
			}// inputX길이 == inputY길이
			else {
				System.out.print("X+Y = " );
				add(inputX, inputY);
				System.out.println();
				System.out.print("X-Y = ");
				sub(inputX, inputY);
				System.out.println();
				System.out.print("X*Y = ");
				mult(inputX, inputY);
			}// inputX길이 > inputY 길이
		}// 두수 모두 양수
		
		
			
		}
	private static void add(String a, String b) {
		int aLength = a.length();
		int bLength = b.length();
		int carry = 0;
		int dif = aLength - bLength;
		int [] result = new int[aLength+1];
		for (int i = aLength-1; i>=aLength-bLength; i--) {
			if (carry != 0) 
					result[i+1] += carry;
			carry = 0;
			result[i+1] += (Integer.parseInt(a.substring(i,i+1))+ Integer.parseInt(b.substring(i-dif,i+1-dif)));
			if (result[i+1] >= 10) {
				result[i+1] -= 10;
				carry = 1;
			}			
		}
		for (int i=aLength-bLength; i>=0; i--) {
			if (carry != 0)
				result[i] += carry;
			carry = 0;
			if (i==0)
				break;
			result[i] += Integer.parseInt(a.substring(i-1,i));
		}
		
		int zD = 0;
		while ((result[zD]==0)==true)
			zD += 1;
		for (int i=zD; i<result.length; i++) {
			System.out.print(result[i]);
		}
			
		
		
	} // add
	private static void sub(String a, String b) {
		int aLength = a.length();
		int bLength = b.length();
		int carry = 0;
		int dif = aLength - bLength;
		int [] adigit = new int [aLength];
		int [] result = new int [aLength];
		for (int i=0; i<aLength; i++) {
			adigit[i]=Integer.parseInt(a.substring(i,i+1));
		}
		for (int i = aLength-1; i>= aLength-bLength; i--) {
			int bDigit = Integer.parseInt(b.substring(i-dif,i+1-dif));
			carry = 0;
			if (adigit[i]-bDigit < 0) {
				int j = i;
				if (adigit[j-1]>0) {
					adigit[j-1] -= 1;
					carry += 10;
					result [i] = carry + adigit[i] - bDigit;
				}
				else {
					adigit[j-1] -=1;
					adigit[j] += 10;
					j--;
					result [i] = adigit[i] - bDigit;
				}
			}
			else
				result [i] = carry + adigit[i] - bDigit;
		}
		for (int i=aLength - bLength-1; i>=0; i--) {
			if (adigit[i]<0 && i!= 0) {
				adigit[i-1] -=1;
				adigit[i] += 10;
			}
			result[i] = adigit[i];
		}
		
		int zD = 0;
		while ((result[zD]==0)==true) {
			
			zD += 1;
		}
			
		for (int i=zD; i<result.length; i++) {
			System.out.print(result[i]);
		}
	}//sub
	private static void mult(String a, String b) {
		int aLength = a.length();
		int bLength = b.length();
		int [] aNum = new int [aLength];
		int [] bNum = new int [bLength];
		int [][] result = new int [bLength][aLength+bLength];
		int [] total = new int[aLength+bLength];
		for (int i=0; i<aLength;i++) {
			aNum[i] = Integer.parseInt(a.substring(i, i+1));
		}
		for (int i=0; i<bLength; i++) {
			bNum[i] = Integer.parseInt(b.substring(i, i+1));
		}
		for (int i=bLength-1; i>=0; i--) {
			for (int k=aLength-1; k>=0; k--) {
				result[bLength-i-1][i+k+1] += aNum[k]*bNum[i];
				if (result[bLength-i-1][i+k+1] >= 10) {
					result[bLength-i-1][i+k] += result[bLength-i-1][i+k+1]/10;
					result[bLength-i-1][i+k+1] %= 10;
				}
			}
		}
		for (int i=aLength+bLength-1; i>=0; i--) {
			for (int k=0; k<bLength; k++) {
				total[i] += result[k][i];
				if (total[i] >= 10) {
					total [i-1] += total[i]/10;
					total[i] %= 10;
				}
			}
		}
		int zD = 0;
		while ((total[zD]==0)==true) {
			
			zD += 1;
		}
			
		for (int i=zD; i<total.length; i++) {
			System.out.print(total[i]);
		}
		
		
	}
}
