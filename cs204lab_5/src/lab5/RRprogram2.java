package lab5;
import java.io.*;
import java.util.*;

public class RRprogram2 {
    public static void main(String[] args) throws IOException {
        try {
            Scanner sc = new Scanner(new File(args[0]));
            String number = sc.nextLine();
            int n = Integer.parseInt(number);
            System.out.println("the number of process is "+n);
            String[] p_id = new String[n];
            int[] arrival = new int[n];
            int[] Priority = new int[n];
            int[] process = new int[n];
            int[] cmp_time = new int[n];
            float[] iotime = new float[n];
            float[] iowait = new float[n];
            for (int i = 0; i < n; i++) {
                String current = sc.nextLine(), temp = " ";
                int count = 0;
                for (int j = 0; j < current.length(); j++) {
                    if (current.charAt(j) == '-') {
                        if (count == 0) {
                            p_id[i] = temp;
                        } else if (count == 1) {
                            arrival[i] = Integer.parseInt(temp);
                        } else if (count == 2) {
                            process[i] = Integer.parseInt(temp);
                        } else if (count == 3) {
                            iotime[i] = Float.parseFloat(temp);
                        } else if (count == 4) {
                            iowait[i] = Float.parseFloat(temp);
                        } else if (count == 5) {
                            Priority[i] = Integer.parseInt(temp);
                        }else {
                            continue;
                        }
                        temp = "";
                        count++;
                    } else {
                        temp += current.charAt(j);
                    }}}
            //input of the data is complete now the main algorithm
            
            int time = 0, time_quantam = 4;

            while (true) {
                boolean val = true;
                for (int i = 0; i < n; i++) {
                    if (process[i] > 0) {
                        val = false;
                        if (process[i] > time_quantam && arrival[i] <= time) {
                            process[i] -= time_quantam;
                            time += time_quantam;
                        } else if (process[i] <= time_quantam) {
                            time += process[i];
                            process[i] = 0;
                            cmp_time[i] = time;
                        }}}
                if (val == true)
                    break;
            }
            float[] tat_time = new float[n];
            float[] wait_time = new float[n];
            float total_wait = 0, total_tat = 0;
            for (int i = 0; i < n; i++) {
                tat_time[i] = (cmp_time[i] - arrival[i]) + iowait[i];
                wait_time[i] = (tat_time[i] - process[i]) - iotime[i];
                total_wait += wait_time[i];
                total_tat += tat_time[i];
                System.out.println("Turn Around and Wait time for process : " + p_id[i] + " is " + tat_time[i] + " and "+ wait_time[i]);
            }
            System.out.println("\nTotal Turn Around time : " + total_tat / (float) n);
            System.out.println("Total Waiting Around time : " + total_wait / (float) n);
            } catch (Exception e) {
            System.out.println("\n\nFILE NOT FOUND\n\n");
        }
    }
}
