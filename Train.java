/**
 * Name: Sharon Guan
 * SBU ID: 114430436
 * Email: sharon.guan@stonybrook.edu
 * Recitation: R01
 */
import jdk.nashorn.api.scripting.ScriptObjectMirror;

import java.util.ArrayList;

public class Train {
    private ArrayList<Station> train;
    private PassengerQueue embarkingFirst;
    private PassengerQueue embarkingSecond;
    private int firstCapacity;
    private int secondCapacity;
    private int timeUntilNextArrival;
    private ArrayList<String> stationName;
    private String trainPrint;
    private int firstLeft;
    private int secondLeft;


    /**
     * this is the constructor of train
     * takes in the capacity for both first and second class
     * @param firstCapacity
     * @param secondCapacity
     * takes in time until next arrival
     * @param timeUntilNextArrival
     * passes in all the station because each train has to go to four stations
     * @param huntington
     * @param syossett
     * @param hicksville
     * @param mineola
     */

    public Train(int firstCapacity, int secondCapacity, int timeUntilNextArrival,Station huntington,
                 Station syossett, Station hicksville, Station mineola) {
        train = new ArrayList<Station>();
        train.add(huntington);
        train.add(syossett);
        train.add(hicksville);
        train.add(mineola);

        stationName= new ArrayList<String>();
        stationName.add("Huntington");
        stationName.add("Syossett");
        stationName.add("Hicksville");
        stationName.add("Mineola");

        trainPrint = "";

        this.firstCapacity = firstCapacity;
        this.secondCapacity = secondCapacity;
        this.timeUntilNextArrival = timeUntilNextArrival;
        embarkingFirst = new PassengerQueue();
        embarkingSecond = new PassengerQueue();

        this.firstLeft = 0;
        this.secondLeft = 0;


    }

    /**
     * if the train is full, it will not pick up any more passengers
     * else, it will pick up passengers and dequeue them from the station
     */
    public void simulateTimeStep() {
        if(train.isEmpty() || ((embarkingFirst.size()) == firstCapacity) && (embarkingSecond.size() == secondCapacity)){
            trainPrint = " has stopped picking up passengers.";
        }
        else {

            if (timeUntilNextArrival == 0) {

                trainPrint = " has arrived at " + stationName.get(0) + ", there are " + embarkingFirst.size() + " passengers in first class and " +
                        embarkingSecond.size() + " passengers in the second class";

                int firstWaiting = train.get(0).getFirstClass().size();
                int firstServed = embarkingFirst.size();
                int firstFree = firstCapacity - firstServed;


                int secondWaiting = train.get(0).getSecondClass().size();
                int secondServed = embarkingSecond.size();
                int secondFree = secondCapacity - secondServed;


                //this entire if/else statement handles the first class passengers that want to board the train
                //if the first class passengers waiting to board the train is less than or equal to the free space4
                // left in the first class of the train, they will all board
                if (firstWaiting <= firstFree) {

                    for (int i = 0; i < firstWaiting; i++) {
                        Passenger p = train.get(0).getFirstClass().peek();
                        embarkingFirst.enqueue(p);
                        train.get(0).getFirstClass().dequeue();

                    }
                }
                //if the first class waiting to board is greater than the free space available for first class on the train BUT
                // there is free space in the second class for first class passengers waiting to board,
                // they will fill up the first class and second class in the train
                else if (firstWaiting - firstFree <= secondFree) {
                    for (int i = 0; i < firstFree; i++) {
                        Passenger p = train.get(0).getFirstClass().peek();
                        embarkingFirst.enqueue(p);
                        train.get(0).getFirstClass().dequeue();
                    }

                    for (int j = 0; j < firstWaiting - firstFree; j++) {
                        Passenger g = train.get(0).getFirstClass().peek();
                        embarkingSecond.add(g);
                        train.get(0).getFirstClass().dequeue();

                    }
                    secondFree -= firstWaiting - firstFree;
                } else {
                    //this case is where there are more first class passengers boarding than there is free space of both
                    //first and second class. In this case, they will try to fill up as much free space there is and keep record
                    //of how many first class passengers are left without boarding
                    for (int i = 0; i < firstFree; i++) {
                        Passenger x = train.get(0).getFirstClass().peek();
                        embarkingFirst.enqueue(x);
                        train.get(0).getFirstClass().dequeue();
                    }
                    for (int j = 0; j < secondFree; j++) {
                        Passenger y = train.get(0).getFirstClass().peek();
                        embarkingSecond.add(y);
                        train.get(0).getFirstClass().dequeue();

                    }
                    secondFree = 0;
                    this.firstLeft = firstWaiting - firstFree - secondFree;
                }


                //this if/else statement handles the second class after it has just handled the first class passengers
                //if this second class passengers waiting to get on board at the station is less than or equal to the
                //free space available in second class of the train, they will all board
                if (secondWaiting <= secondFree) {

                    for (int i = 0; i < secondWaiting; i++) {
                        Passenger s = train.get(0).getSecondClass().peek();
                        embarkingSecond.enqueue(s);
                        train.get(0).getSecondClass().dequeue();
                    }
                }
                //if the number of second class passengers waiting to board is greater than the second class free space available
                //in the train, then they will board as much as they can and leave the rest at the station
                else {
                    for (int j = 0; j < secondFree; j++) {
                        Passenger w = train.get(0).getSecondClass().peek();
                        embarkingSecond.enqueue(w);
                        train.get(0).getSecondClass().dequeue();
                    }
                    this.secondLeft = secondWaiting - secondFree;
                }
                if(embarkingFirst.size() == firstCapacity) {
                    trainPrint += "\nEmbarking first class: None";
                }
                else{
                    trainPrint += "\nEmbarking first class: " + embarkingFirst.toString();
                }

                if(embarkingSecond.size()==0){
                    trainPrint += "\nEmbarking second class: None ";
                }
                else {
                    trainPrint += "\nEmbarking second class: " + embarkingSecond.toString();
                }


                stationName.remove(0);
                train.remove(0);
                timeUntilNextArrival = 4;

            } else {
                trainPrint = " will arrive at " + stationName.get(0) + " in " + timeUntilNextArrival + " minutes";
                timeUntilNextArrival--;
            }
        }

    }

    /**
    gets the print of the train depending on whether it is moving or at a station
     */
    public String getTrainPrint(){
        return trainPrint;
    }

    /**
     * gets the total amount of people left over
     */
    public int getFirstLeft(){
        return firstLeft;
    }

    /**
     * gets the total amount of second class people left over
     * @return
     */
    public int getSecondLeft(){
        return secondLeft;
    }

    /**
     * gets the number of first class people on board
     * @return
     */
    public int firstBoard(){
        return embarkingFirst.size();
    }

    /**
     * gets the total number of second class people on board
     * @return
     */
    public int secondBoard(){
        return embarkingSecond.size();
    }

    /**
     * gets the number of people embarking in first class
     * @return
     */
    public PassengerQueue getEmbarkingFirst() {
        return embarkingFirst;
    }

    /**
     * gets the number of people embarking in second class
     * @return
     */
    public PassengerQueue getEmbarkingSecond(){
        return embarkingSecond;
    }

    /**
     * gets the train
     * @return
     */
    public ArrayList<Station> getTrain(){
        return train;
    }

}

