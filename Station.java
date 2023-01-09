/**
 * Name: Sharon Guan
 * SBU ID: 114430436
 * Email: sharon.guan@stonybrook.edu
 * Recitation: R01
 */
public class Station {
    private PassengerQueue firstClass;
    private PassengerQueue secondClass;
    private BooleanSource firstArrival;
    private BooleanSource secondArrival;
    private int passengerCount;
    private int time;

    public Station(){
        firstClass = new PassengerQueue();
        secondClass = new PassengerQueue();
    }

    /**
     * constructor method for station
     * takes probability of first class for BooleanSource
     * @param prob1
     * takes probability of second class for BooleanSource
     * @param prob2
     * takes time to keep track of passengers
     * @param time
     */
    public Station(double prob1, double prob2, int time){
        firstArrival = new BooleanSource(prob1);
        secondArrival = new BooleanSource(prob2);

        firstClass = new PassengerQueue();
        secondClass = new PassengerQueue();

        this.passengerCount = 0;
        this.time = time;

    }

    /**
     * if a passenger arrives at the station,
     * it will be enqueued to its belonging class
     */
    public void simulateTimestep(){

        boolean firstCome = firstArrival.occurs();
        boolean secondCome = secondArrival.occurs();

        if(firstCome){
            passengerCount++;
            System.out.println("First class passenger ID "+(passengerCount)+ " arrives");
            Passenger newPassenger = new Passenger(passengerCount, time, true);
            firstClass.enqueue(newPassenger);



        }
        else{
            System.out.println("No first class passenger arrives");
        }

        if(secondCome){
            passengerCount++;
            System.out.println("Second class passenger ID "+passengerCount+ " arrives");
            Passenger newPassenger = new Passenger(passengerCount, time, true);
            secondClass.enqueue(newPassenger);

        }
        else{
            System.out.println("No second class passenger arrives.");
        }

        System.out.println("First class: "+ firstClass.toString());
        System.out.println("Second class: "+ secondClass.toString());
    }

    /**
     * this allows passenger count to be updated between the main LIRR Simulator and the station
     * @return
     */
    public int getPassengerCount() {
        return passengerCount;
    }

    /**
     * sets passengerCount
     * @param passengerCount
     */
    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }

    /**
     * sets the time
     * @param x
     */
    public void setTime(int x){
        this.time = x;
    }

    /**
     * sets the first arrival
     * @param x
     */
    public void setFirstArrival(int x){
        firstArrival = new BooleanSource(x);
    }

    /**
     * sets the second arrival
     * @param x
     */
    public void setSecondArrival(int x){
        secondArrival = new BooleanSource(x);
    }

    /**
     * gets the BooleanSource for the first class arrival
     * @return
     */
    public BooleanSource getFirstArrival() {
        return firstArrival;
    }

    /**
     * returns the BooleanSource for the second class arrival
     * @return
     */
    public BooleanSource getSecondArrival() {
        return secondArrival;
    }

    /**
     * returns the PassengerQueue of the firstClass
     * @return
     */
    public PassengerQueue getFirstClass() {
        return firstClass;
    }

    /**
     * returns the PassengerQueue of the secondClass
     * @return
     */
    public PassengerQueue getSecondClass() {
        return secondClass;
    }


}
