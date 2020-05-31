import java.util.*;

public class Ladder {
	public static void main(String args[]) {
		String[][] ladderArray;
		String[] lineShape = new String[] {"¦¢", "-", "¦©", "¦§"};
		String[] player = new String[] {"1", "2", "3", "4", "5"};
		String[] result = new String[] {"A", "B", "C", "D", "E"};
		int spc = 4;
		int i,k,j;
		int lineNum;
		while (true) {
			double a = Math.random();
			if (a>=0.5) {
				lineNum = (int) (a*30);
				break;
		}}
		
		
		ladderArray = new String[lineNum][5*spc];
		for (i=0; i<lineNum; i++) {
			for (k=0; k< 5*spc;k++) {
				if (k%4==0) 
					ladderArray[i][k] =lineShape[0];
				
				else
					ladderArray[i][k] = " ";
			}
		}		
		int[] chkLine = new int[5];
		
		for (i=1; i<ladderArray.length-1;i++) {
			for (k=0; k<4; k++) {
				
				if ((int)(Math.random()*2)==0) {
					if (chkLine[k]<ladderArray.length) {
						if (ladderArray[i][k*spc].equals(lineShape[0]) && ladderArray[i][k*spc+spc].equals(lineShape[0])) {
							ladderArray[i][k*spc] = lineShape[3];
							for (j=1; j<spc+1;j++) {
								if (j<spc) 
									ladderArray[i][k*spc+j] = lineShape[1];
								else
									ladderArray[i][k*spc+j] = lineShape[2];	
							}
							chkLine[k] += 1;
							lineNum -= 1;
						}
						else
							chkLine[k] += 0;
					}
				}
			}
			
			if (i == ladderArray.length-2) {
				for (j=0; j<4; j++) {
					if(chkLine[j]<3 || lineNum >0) {
						i =1;
						break;
					}
				}					
			}
			
		}	
		for (i=0; i<5*spc; i += spc) {
			int a = 0, b = i;
			for (k=0; k<ladderArray.length; k++) {
				if (ladderArray[a][b].equals(lineShape[3])) {
					b += spc;
					}
				else if (ladderArray[a][b].equals(lineShape[2])) {
					b -= spc;
					}
				a += 1;
			}
			System.out.println(player[i/spc]+"ÀÇ°á°ú:" + result[b/spc]);
		}
		System.out.printf("\n\n");
		for (String str:player){
			System.out.print(str+"   ");
		}
		System.out.println();
		for (int w=0; w<ladderArray.length; w++) {
			for (k=0; k<5*spc; k++)
				System.out.print(ladderArray[w][k]);
			System.out.println();
		}
		for (String str:result)
			System.out.print(str+"   ");
		
		
		  
	}		
}
