package lab5;
import java.util.Scanner;
public class FCFS {
    int processTime[];
    int arrivalTime[];
    String[] processId;
    int numberOfProcess;

    void getProcessData(Scanner input) 
    {
        System.out.print("Enter the number of Process for Scheduling           : ");
        int inputNumberOfProcess = input.nextInt();
        numberOfProcess = inputNumberOfProcess;
        processTime = new int[numberOfProcess];
        arrivalTime = new int[numberOfProcess];
        processId = new String[numberOfProcess];
        String st = "P";
        System.out.println("Enter the arrival time for ");
        for (int i = 0; i < numberOfProcess; i++) 
        {
            processId[i] = st.concat(Integer.toString(i));
            System.out.print(" Process - " + (i) + " : ");
            arrivalTime[i] = input.nextInt();
        }
        System.out.println("Enter the processing time for");
        for (int i = 0; i < numberOfProcess; i++) 
        {
            processId[i] = st.concat(Integer.toString(i));
            System.out.print(" Process - " + (i) + " : ");
            processTime[i] = input.nextInt();
        }
    }

    void sortAccordingArrivalTime(int[] at, int[] bt, String[] pid)
    {
        boolean swapped;
        int temp;
        String stemp;
        for (int i = 0; i < numberOfProcess; i++) 
        {
            swapped = false;
            for (int j = 0; j < numberOfProcess - i - 1; j++) 
            {
                if (at[j] > at[j + 1]) 
                {
                    //swapping arrival time
                    temp = at[j];
                    at[j] = at[j + 1];
                    at[j + 1] = temp;

                    //swapping burst time
                    temp = bt[j];
                    bt[j] = bt[j + 1];
                    bt[j + 1] = temp;

                    //swapping process id
                    stemp = pid[j];
                    pid[j] = pid[j + 1];
                    pid[j + 1] = stemp;

                    //enhanced bubble sort
                    swapped = true;
                }
            }
            if (swapped == false) 
            {
                break;
            }
        }
    }

    void firstComeFirstServeAlgorithm() 
    {
        int brustTime[] = new int[numberOfProcess];
        int bt[] = processTime.clone();
        int at[] = arrivalTime.clone();
        String pid[] = processId.clone();
        int waitingTime[] = new int[numberOfProcess];
        int turnAroundTime[] = new int[numberOfProcess];
        sortAccordingArrivalTime(at, bt, pid);

        //calculating waiting & turn-around time for each process
        brustTime[0] = at[0] + bt[0];
        turnAroundTime[0] = brustTime[0] - at[0];
        waitingTime[0] = turnAroundTime[0] - bt[0];
        for (int i = 1; i < numberOfProcess; i++) 
        {
            brustTime[i] = bt[i] + brustTime[i - 1];
            turnAroundTime[i] = brustTime[i] - at[i];
            waitingTime[i] = turnAroundTime[i] - bt[i];
        }
        float sum = 0;
        for (int n : waitingTime) 
        {
            sum += n;
        }
        float averageWaitingTime = sum / numberOfProcess;

        sum = 0;
        for (int n : turnAroundTime) 
        {
            sum += n;
        }
        float averageTurnAroundTime = sum / numberOfProcess;
        sum = 0;
        for (int n : brustTime) 
        {
            sum += n;
        }
        float averageBrustTime = sum / numberOfProcess;

        //print on console the order of processes scheduled using FirstComeFirstServer Algorithm
        System.out.println("FCFS Scheduling Algorithm : ");
        System.out.format("%16s%16s%16s%16s%16s%16s\n", "ProcessId", "processTime", "ArrivalTime", "brustTime", "WaitingTime", "TurnAroundTime");
        for (int i = 0; i < numberOfProcess; i++) 
        {
            System.out.format("%16s%16d%16d%16d%16d%16d\n", pid[i], bt[i], at[i], brustTime[i], waitingTime[i], turnAroundTime[i]);
        }
        System.out.format("%50s%16f%16f%16f\n", "Average", averageBrustTime, averageWaitingTime, averageTurnAroundTime);
    }

    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        FCFS obj = new FCFS();
        obj.getProcessData(input);
        obj.firstComeFirstServeAlgorithm();
    }
}
