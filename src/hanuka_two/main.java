package hanuka_two;

import java.util.Arrays;

import hanuka_two.machine.Gush;

//import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		// Scanner myObj = new Scanner(System.in); // Create a Scanner object
		// System.out.println("Enter username");
		//
		// String userName = myObj.nextLine(); // Read user input
		//
		// System.out.println("Username is: " + userName); // Output user input
		// int[] time = { 1, 2, 2, 4, 5, 2, 5, 5 };
		int[] time = { 8, 9, 6, 8, 8, 5, 3, 9, 7 };
		hanuka2(time);
	}

	public static void hanuka2(int[] time) {
		// int yak = 0;
		machine machine = new machine(time);
		// Gush[] cluster = new Gush[time.length];
		int k = 0;
		for (int i = 0; i < machine.getlen(); i++) {

			// + machine.gushim[i + 1].opt) {);
			// if (machine.gushim[i].len + machine.gushim[i].opt > machine.gushim[i + 1].len
			// + machine.gushim[i + 1].opt) {
			// cluster[k] = machine.gushim[i];
			// k++;

			// } else {
			// if (machine.gushim[i].len == 2)
			// yak = yak + 1;
			// if (machine.gushim[i].len != 1) {
			// if (machine.gushim[i].len % 2 == 1) {
			// int j = (machine.gushim[i].len - 1) / 2;
			// yak += (int) ((j + Math.pow(j, 2)));
			// }
			// if (machine.gushim[i].len % 2 == 0) {
			// int j = (machine.gushim[i].len - 1) / 2;
			// yak += (int) ((j + Math.pow(j, 2))) - j;
			// }
			// }

			// }
		}
		// System.out.println(yak);
		
		System.out.println(machine.caculate(time));

		// int n = time.length;
		// int yak = 0;
		// Arrays.sort(time);
		// int[][] total = new int[n][3];// time need to get ready // how many with the
		// same time // recommended time

		// // ~~~~~~~~~~~~~~~ creating cluster arr ~~~~~~~~~~~~
		// total[0][0] = time[0];
		// int ind = 0;
		// total[ind][1]++;
		// for (int i = 1; i < time.length; i++) {
		// if (total[ind][0] == time[i]) {

		// total[ind][1]++;
		// } else {

		// ind++;
		// total[ind][0] = time[i];
		// total[ind][1]++;

		// }
		// }

		// // ~~~~~~~~~~~~~~~ creating optimal time arr ~~~~~~~~~~~~
		// total[0][2] = 1;
		// int num = total[0][1];
		// for (int i = 1; i < total.length; i++) {
		// if (total[i][1] > 0) {
		// total[i][2] = time[num] - total[i][1] / 2;
		// num = num + total[i][1];
		// }

		// }
		// System.out.println("time: " + Arrays.toString(time));
		// System.out.println("c: ");
		// for (int[] i : total) {
		// System.out.println(" " + Arrays.toString(i));
		// }

		// ~~~~~~~~~~~~~~~ finding path ~~~~~~~~~~~~~~~

	}

}
