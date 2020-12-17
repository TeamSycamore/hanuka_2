package hanuka_two;

import java.util.Arrays;
import java.util.ArrayList;

public class machine {

    class Gush {
        int num;
        int len;
        int opt;

        Gush(int num, int len, int opt) {
            this.num = num;
            this.len = len;
            this.opt = opt;
        }

        public String getall() {
            return (Integer.toString(this.num) + " " + Integer.toString(this.len) + " " + Integer.toString(this.opt));
        }

    }

    Gush[] gushim;

    machine(int time[]) {
        ArrayList<Gush> G = new ArrayList<Gush>();
        Arrays.sort(time);
        int[][] total = new int[time.length][3];// time need to get ready // how many with the same time // recommended
                                                // time

        // ~~~~~~~~~~~~~~~ creating cluster arr ~~~~~~~~~~~~
        total[0][0] = time[0];
        int ind = 0;
        total[ind][1]++;
        for (int i = 1; i < time.length; i++) {
            if (total[ind][0] == time[i]) {

                total[ind][1]++;
            } else {

                ind++;
                total[ind][0] = time[i];
                total[ind][1]++;

            }
        }

        // ~~~~~~~~~~~~~~~ creating optimal time arr ~~~~~~~~~~~~
        total[0][2] = 1;
        int num = total[0][1];
        for (int i = 1; i < total.length; i++) {
            if (total[i][1] > 0) {
                total[i][2] = time[num] - total[i][1] / 2;
                num = num + total[i][1];
            }

        }
        for (int[] is : total) {
            if (is[1] == 0)
                break;
            G.add(new Gush(is[0], is[1], is[2]));
        }

        this.gushim = new Gush[G.size()];
        for (int j = 0; j < G.size(); j++) {
            this.gushim[j] = G.get(j);
        }
        System.out.println("num | len |opt");
        for (Gush is : this.gushim) {
            System.out.println(is.getall());
        }

    }

    public int getlen() {

        return this.gushim.length - 1;
    }
    public int caculate(int[] time) {
        int t=1;
        int yak=0;
        for (int i : time) {
            yak+=Math.abs(i-t);
            t++;
        }
     return yak;   
    }
}