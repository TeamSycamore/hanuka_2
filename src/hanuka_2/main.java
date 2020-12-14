package hanuka_2;

import java.util.Arrays;
import java.util.Scanner;  // Import the Scanner class
import javafx.util.Pair; 
import java.util.ArrayList; 


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
		Pair<Integer,Integer>[] gushim = new Pair<>[n]; // clusters
		int[] optTime = new int[n]; // Recommended time
		
		//~~~~~~~~~~~~~~~ creating cluster arr ~~~~~~~~~~~~
		int curr = time[0];
		int ind = 0;
		gushim[ind]++;
		for (int i = 1; i < time.length; i++) {
			if(curr == time[i])
				gushim[ind]++;
			else {
				curr = time[i];
				ind++;
				gushim[ind]++;
			}
		}
		
		//~~~~~~~~~~~~~~~ creating optimal time arr ~~~~~~~~~~~~
		optTime[0] = 1;
		int num = gushim[0] ;
		for (int i = 1; i < gushim.length; i++) {
			if(gushim[i] > 0 ) {
				optTime[i] = time[num] - gushim[i]/2;
				num = num + gushim[i];
			}
			
		}
//		for (int element: optTime) {
//            System.out.println(element);
//        }
		
		//~~~~~~~~~~~~~~~ finding 
		for (int i = 0; i < gushim.length - 1; i++) {
			if(gushim[i] + optTime[i] > optTime[i+1]) {
				boolean flag = true;
				int j = i;
				int[] cluster = new int[n];
				for (int k = 0; k < gushim.length - 1; k++) {
					cluster[k] = gushim[j];
					if(gushim[i] + optTime[i] < optTime[i+1]) {
						i = j + 1;
						break;
					}
					j++;
				}
				
			}
			else {
				if(gushim[i] == 2)
					yak = yak + 1;
				if(gushim[i] != 1) {
					if(gushim[i] % 2 == 1) {
						int j = (gushim[i] - 1)/2;
						yak = (int) (yak + (j + Math.pow(j, 2)));
					}  
					if(gushim[i] % 2 == 0) {
						int j = (gushim[i] - 1)/2;
						yak = (int) (yak + (j + Math.pow(j, 2))) - j;
					}
				}
				
			}
		}
		System.out.println(yak);
	}

}
