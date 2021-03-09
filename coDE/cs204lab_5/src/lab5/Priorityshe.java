package lab5;

import java.util.Scanner;

public class Priorityshe {
	int burstTime[];
	int priority[];
	int arrivalTime[];
	String[] processId;
	int numberOfProcess;

	void getProcessData(Scanner input) 
	{
    System.out.print("Enter the number of Process for Scheduling           : ");
    int inputNumberOfProcess = input.nextInt();
    numberOfProcess = inputNumberOfProcess;
    burstTime = new int[numberOfProcess];
    priority = new int[numberOfProcess];
    arrivalTime = new int[numberOfProcess];
    processId = new String[numberOfProcess];
    String st = "P";
    System.out.println("Enter the burst time   for ");
    for (int i = 0; i < numberOfProcess; i++) 
    {
        processId[i] = st.concat(Integer.toString(i));
        System.out.print("Process - " + (i) + " : ");
        burstTime[i] = input.nextInt();
    }
    System.out.println("Enter the Arrival time   for ");
    for (int i = 0; i < numberOfProcess; i++) 
    {
        processId[i] = st.concat(Integer.toString(i));
        System.out.print("Process - " + (i) + " : ");
        arrivalTime[i] = input.nextInt();
    }
    System.out.println("Enter the Priorty   for ");
    for (int i = 0; i < numberOfProcess; i++) {
        processId[i] = st.concat(Integer.toString(i));
        System.out.print("Process - " + (i) + " : ");
        priority[i] = input.nextInt();
    }
    }


void sortAccordingArrivalTimeAndPriority(int[] at, int[] bt, int[] prt, String[] pid) 
{

    int temp;
    String stemp;
    for (int i = 0; i < numberOfProcess; i++) 
    {

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

                //swapping priority
                temp = prt[j];
                prt[j] = prt[j + 1];
                prt[j + 1] = temp;

                //swapping process identity
                stemp = pid[j];
                pid[j] = pid[j + 1];
                pid[j + 1] = stemp;

            }
            //sorting according to priority when arrival timings are same
            if (at[j] == at[j + 1]) 
            {
                if (prt[j] > prt[j + 1]) 
                {
                    //swapping arrival time
                    temp = at[j];
                    at[j] = at[j + 1];
                    at[j + 1] = temp;

                    //swapping burst time
                    temp = bt[j];
                    bt[j] = bt[j + 1];
                    bt[j + 1] = temp;
                    //swapping priority
                    temp = prt[j];
                    prt[j] = prt[j + 1];
                    prt[j + 1] = temp;
                    //swapping process identity
                    stemp = pid[j];
                    pid[j] = pid[j + 1];
                    pid[j + 1] = stemp;

                }
            }
        }

    }
}

	void priorityAlgorithm() 
	{
    int finishTime[] = new int[numberOfProcess];
    int bt[] = burstTime.clone();
    int at[] = arrivalTime.clone();
    int prt[] = priority.clone();
    String pid[] = processId.clone();
    int waitingTime[] = new int[numberOfProcess];
    int turnAroundTime[] = new int[numberOfProcess];

    sortAccordingArrivalTimeAndPriority(at, bt, prt, pid);
  //calculating waiting & turn-around time for each process
    finishTime[0] = at[0] + bt[0];
    turnAroundTime[0] = finishTime[0] - at[0];
    waitingTime[0] = turnAroundTime[0] - bt[0];

    for (int i = 1; i < numberOfProcess; i++) 
    {
        finishTime[i] = bt[i] + finishTime[i - 1];
        turnAroundTime[i] = finishTime[i] - at[i];
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

    //print on console the order of processes along with their finish time & turn around time
    System.out.println("Priority Scheduling Algorithm : ");
    System.out.format("%16s%16s%16s%16s%16s%16s%16s\n", "ProcessId", "BurstTime", "ArrivalTime", "Priority", "FinishTime", "WaitingTime", "TurnAroundTime");
    for (int i = 0; i < numberOfProcess; i++) {
        System.out.format("%16s%16d%16d%16d%16d%16d%16d\n", pid[i], bt[i], at[i], prt[i], finishTime[i], waitingTime[i], turnAroundTime[i]);
    }

    System.out.format("%80s%16f%16f\n", "Average", averageWaitingTime, averageTurnAroundTime);
         }

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        Priorityshe obj = new Priorityshe();
        obj.getProcessData(input);
        obj.priorityAlgorithm();

	}
}
