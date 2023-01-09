/**
 * Name: Sharon Guan
 * SBU ID: 114430436
 * Email: sharon.guan@stonybrook.edu
 * Recitation: R01
 */
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
public class LIRRSimulation {

    public static void main(String[] args) {

        int currentTime = 0;
        int passengerCount = 0;

        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the LIRR Simulator, Leaving Irate Riders Regularly");

        System.out.println("\nHuntington:");
        System.out.println("Please enter first class arrival probability: ");
        double huntingtonFirstProb = input.nextDouble();
        System.out.println("Please enter second class arrival probability: ");
        double huntingtonSecondProb = input.nextDouble();
        Station huntington = new Station(huntingtonFirstProb, huntingtonSecondProb, 0);
        ArrayList<Integer> huntingtonWaitTime = new ArrayList<Integer>();

        System.out.println("\nSyosset:");
        System.out.println("Please enter first class arrival probability:");
        double syossetFirstProb = input.nextDouble();
        System.out.println("Please enter second class arrival probability:");
        double syossetSecondProb = input.nextDouble();
        Station syosset = new Station(syossetFirstProb, syossetSecondProb, 0);
        ArrayList<Integer> syossetWaitTime = new ArrayList<Integer>();

        System.out.println("\nHicksville:");
        System.out.println("Please enter first class arrival probability:");
        double hicksvilleFirstProb = input.nextDouble();
        System.out.println("Please enter second clss arrival probability:");
        double hicksvilleSecondProb = input.nextDouble();
        Station hicksville = new Station(hicksvilleFirstProb, hicksvilleSecondProb, 0);
        ArrayList<Integer> hicksvilleWaitTime = new ArrayList<Integer>();

        System.out.println("\nMineola:");
        System.out.println("Please enter the first class arrival probability:");
        double mineolaFirstProb = input.nextDouble();
        System.out.println("Please enter the second class arrival probability:");
        double mineolaSecondProb = input.nextDouble();
        Station mineola = new Station(mineolaFirstProb, mineolaSecondProb, 0);
        ArrayList<Integer> mineolaWaitTime = new ArrayList<Integer>();

        System.out.println("Please enter first class capacity:");
        int firstCapacity = input.nextInt();
        System.out.println("Please enter second class capacity:");
        int secondCapacity = input.nextInt();
        System.out.println("Please enter number of trains: ");
        int numTrains = input.nextInt();


        int trainTime = 0;
        Train[] trains = new Train[numTrains];
        for (int i = 0; i < numTrains; i++) {
            Train newTrain = new Train(firstCapacity, secondCapacity, trainTime, huntington, syosset, hicksville,mineola);
            trains[i] = newTrain;
            trainTime += 5;
        }

        System.out.println("Please enter last arrival time of passengers: ");
        int lastTime = input.nextInt();

        if(lastTime%5 == 0)
        if (lastTime > trainTime) {
            System.out.println("No trains will pick up passengers after the last train time. Try again.");
        }
        else {
            System.out.println("Begin simulation:");

            while (currentTime <= lastTime) {

                System.out.println("\nTime:" + currentTime);
                System.out.println("Station Overview: ");

                System.out.println("\nHuntington: ");
                huntington.setPassengerCount(passengerCount);
                huntington.setTime(currentTime);
                huntington.simulateTimestep();
                passengerCount = huntington.getPassengerCount();

                System.out.println("\nSyosset:");
                syosset.setPassengerCount(passengerCount);
                syosset.setTime(currentTime);
                syosset.simulateTimestep();
                passengerCount = syosset.getPassengerCount();

                System.out.println("\nHicksville:");
                hicksville.setPassengerCount(passengerCount);
                hicksville.setTime(currentTime);
                hicksville.simulateTimestep();
                passengerCount = hicksville.getPassengerCount();

                System.out.println("\nMineola:");
                mineola.setPassengerCount(passengerCount);
                mineola.setTime(currentTime);
                mineola.simulateTimestep();
                passengerCount = mineola.getPassengerCount();


                System.out.println("\nTrains:");


            for(int j = 0; j<trains.length;j++){
                trains[j].simulateTimeStep();
            }
            for(int k =0; k<trains.length; k++){
                System.out.println("\nTrain "+(k+1)+ trains[k].getTrainPrint());
            }

                currentTime++;
            }

            huntington.setFirstArrival(0);
            huntington.setSecondArrival(0);
            syosset.setFirstArrival(0);
            syosset.setSecondArrival(0);
            hicksville.setFirstArrival(0);
            hicksville.setSecondArrival(0);
            mineola.setFirstArrival(0);
            mineola.setSecondArrival(0);

            while(currentTime<= trainTime){
                System.out.println("\nTime:" + currentTime);
                System.out.println("Station Overview: ");

                System.out.println("\nHuntington: ");
                huntington.setPassengerCount(passengerCount);
                huntington.setTime(currentTime);
                huntington.simulateTimestep();
                passengerCount = huntington.getPassengerCount();

                System.out.println("\nSyosset:");
                syosset.setPassengerCount(passengerCount);
                syosset.setTime(currentTime);
                syosset.simulateTimestep();
                passengerCount = syosset.getPassengerCount();

                System.out.println("\nHicksville:");
                hicksville.setPassengerCount(passengerCount);
                hicksville.setTime(currentTime);
                hicksville.simulateTimestep();
                passengerCount = hicksville.getPassengerCount();

                System.out.println("\nMineola:");
                mineola.setPassengerCount(passengerCount);
                mineola.setTime(currentTime);
                mineola.simulateTimestep();
                passengerCount = mineola.getPassengerCount();


                System.out.println("\nTrains:");


                for(int j = 0; j<trains.length;j++){
                    trains[j].simulateTimeStep();
                }
                for(int k =0; k<trains.length; k++){
                    System.out.println("\nTrain "+(k+1)+ trains[k].getTrainPrint());
                }

                currentTime++;
            }



            System.out.println("\n\nAt the end of the simulation:");
            int totalServed = 0;
            int firstLeft = 0;
            int secondLeft =0;
            for(int z=0; z<trains.length;z++){
                totalServed += trains[z].firstBoard() + trains[z].secondBoard();
                firstLeft+= trains[z].getFirstLeft();
                secondLeft+=trains[z].getSecondLeft();
            }
            System.out.println("A total of "+totalServed+" passengers were served, "+
                    firstLeft+ " first class passengers were left without a seat, "+
                    secondLeft+" second class passengers were left without a seat.");



            System.out.println("At Huntington __ first class passengers were served with an average wait time of ___" +
                    "and __ second passengers were served with an average wait time of __." +
                            "__ first class passengers and __ second class passengers were left without a seat.");

            System.out.println("At Syosset __ first class passengers were served with an average wait time of ___" +
                    "and __ second passengers were served with an average wait time of __." +
                    "__ first class passengers and __ second class passengers were left without a seat.");

            System.out.println("At Hicksville __ first class passengers were served with an average wait time of ___" +
                    "and __ second passengers were served with an average wait time of __." +
                    "__ first class passengers and __ second class passengers were left without a seat.");

            System.out.println("At Mineola __ first class passengers were served with an average wait time of ___" +
                    "and __ second passengers were served with an average wait time of __." +
                    "__ first class passengers and __ second class passengers were left without a seat.");







        }
    }


}
