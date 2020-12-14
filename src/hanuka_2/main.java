package hanuka_2;

import java.util.Arrays;
import java.util.Scanner; 


public class main {

	public static void main(String[] args) {


		//		 Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		//		 System.out.println("Enter username");
		//
		//		 String userName = myObj.nextLine();  // Read user input
		//
		//		 System.out.println("Username is: " + userName);  // Output user input
		int[] time = {1,2,2,4,5,2,5};
		hanuka2(7,time);
	}

	public static void hanuka2(int n, int[] time) {
		int yak = 0;
		Arrays.sort(time);
		int[][] cluser = new int[n][3];
		int[] gushim = new int[n]; // clusters
		int[] optTime = new int[n]; // Recommended time

		//~~~~~~~~~~~~~~~ creating cluster arr ~~~~~~~~~~~~
		cluser[0][0]=time[0];
		int ind = 0;
		cluser[ind][1]++;
		for (int i = 1; i < time.length; i++) {
			if(cluser[ind][0] == time[i]){

				cluser[ind][1]++;}
			else {				

				ind++;
				cluser[ind][0]= time[i];
				cluser[ind][1]++;

			}
		}

		//~~~~~~~~~~~~~~~ creating optimal time arr ~~~~~~~~~~~~
		cluser[0][2]=1;
		int num = cluser[0][1] ;
		for (int i = 1; i < cluser.length; i++) {
			if(cluser[i][1] > 0 ) {
				cluser[i][2]=time[num] - cluser[i][1]/2;
				num = num + cluser[i][1];
			}

		}
		System.out.println("gushim: "+Arrays.toString(gushim));
		System.out.println("time: "+Arrays.toString(time));
		System.out.println("op: "+Arrays.toString(optTime));
		System.out.println("c: ");
		for (int[] i : cluser) {
			System.out.println(" "+Arrays.toString(i));
		}

	}
	//		for (int element: optTime) {
	//            System.out.println(element);
	//        }

	//		
	//		
	//		//~~~~~~~~~~~~~~~ finding 
	//		for (int i = 0; i < gushim.length - 1; i++) {
	//			if(gushim[i] + optTime[i] > optTime[i+1]) {
	//				boolean flag = true;
	//				int j = i;
	//				int[] cluster = new int[n];
	//				for (int k = 0; k < gushim.length - 1; k++) {
	//					cluster[k] = gushim[j];
	//					if(gushim[i] + optTime[i] < optTime[i+1]) {
	//						i = j + 1;
	//						break;
	//					}
	//					j++;
	//				}
	//				
	//			}
	//			else {
	//				if(gushim[i] == 2)
	//					yak = yak + 1;
	//				if(gushim[i] != 1) {
	//					if(gushim[i] % 2 == 1) {
	//						int j = (gushim[i] - 1)/2;
	//						yak = (int) (yak + (j + Math.pow(j, 2)));
	//					}  
	//					if(gushim[i] % 2 == 0) {
	//						int j = (gushim[i] - 1)/2;
	//						yak = (int) (yak + (j + Math.pow(j, 2))) - j;
	//					}
	//				}
	//				
	//			}
	//		}
	//		System.out.println(yak);
	//	}

}

