package lab5;
import java.io.*;
import java.util.Scanner;

public class RRprogram1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
try {
        System.out.print("\n\nEnter Number of Process : ");
        int n = sc.nextInt();
        FileWriter fw = new FileWriter("test.dat");
        fw.write(Integer.toString(n));
        fw.write("\n");
        for (int i = 0; i < n; i++) {
            System.out.println("\n\nEnter Details For Process " + (i + 1) + " : ");
            System.out.print("Process ID : ");
            String p_id = sc.next();
            System.out.print("Arrival Time : ");
            int ar_time = sc.nextInt();
            System.out.print("Processing Time : ");
            int pr_time = sc.nextInt();
            System.out.print("I/O Interrupts Time : ");
            float io_time = sc.nextFloat();
            System.out.print("Waiting and Processing I/O Time : ");
            float wt_time = sc.nextFloat();
            System.out.print("Priority of the Process : ");
            int prior = sc.nextInt();
            fw.write(p_id);
            fw.write("-");
            fw.write(Integer.toString(ar_time));
            fw.write("-");
            fw.write(Integer.toString(pr_time));
            fw.write("-");
            fw.write(Float.toString(io_time));
            fw.write("-");
            fw.write(Float.toString(wt_time));
            fw.write("-");
            fw.write(Integer.toString(prior));
            fw.write("\n");
        }

        fw.close();
        sc.close();
}catch (Exception e) {
    System.out.println("\n\nFILE NOT created\n\n");
}
System.out.println ("file created");
    }
}
