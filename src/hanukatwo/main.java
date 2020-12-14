package hanukatwo;

import java.util.Arrays;


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
		int[][] total = new int[n][3];
		int[] gushim = new int[n]; // clusters
		int[] optTime = new int[n]; // Recommended time

		//~~~~~~~~~~~~~~~ creating cluster arr ~~~~~~~~~~~~
		total[0][0]=time[0];
		int ind = 0;
		total[ind][1]++;
		for (int i = 1; i < time.length; i++) {
			if(total[ind][0] == time[i]){

				total[ind][1]++;}
			else {				

				ind++;
				total[ind][0]= time[i];
				total[ind][1]++;

			}
		}

		//~~~~~~~~~~~~~~~ creating optimal time arr ~~~~~~~~~~~~
		total[0][2]=1;
		int num = total[0][1] ;
		for (int i = 1; i < total.length; i++) {
			if(total[i][1] > 0 ) {
				total[i][2]=time[num] - total[i][1]/2;
				num = num + total[i][1];
			}

		}
		System.out.println("gushim: "+Arrays.toString(gushim));
		System.out.println("time: "+Arrays.toString(time));
		System.out.println("op: "+Arrays.toString(optTime));
		System.out.println("c: ");
		for (int[] i : total) {
			System.out.println(" "+Arrays.toString(i));
		}

			
			
			//~~~~~~~~~~~~~~~ finding 
			for (int i = 0; i < gushim.length - 1; i++) {
				if(total[i][1] + total[i][2] > total[i+1][2]) {
					boolean flag = true;
					int j = i;
					int[] cluster = new int[n];
					for (int k = 0; k < total.length - 1; k++) {
						cluster[k] = total[j][1];
						if(total[i][1] + total[i][2] < total[i+1][2]) {
							i = j + 1;
							break;
						}
						j++;
					}
					
				}
				else {
					if(total[i][1] == 2)
						yak = yak + 1;
					if(total[i][1] != 1) {
						if(total[i][1] % 2 == 1) {
							int j = (total[i][1] - 1)/2;
							yak = (int) (yak + (j + Math.pow(j, 2)));
						}  
						if(total[i][1] % 2 == 0) {
							int j = (total[i][1] - 1)/2;
							yak = (int) (yak + (j + Math.pow(j, 2))) - j;
						}
					}
					
				}
			}
			System.out.println(yak);
		}

}

