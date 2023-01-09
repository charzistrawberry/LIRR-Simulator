/**
 * Name: Sharon Guan
 * SBU ID: 114430436
 * Email: sharon.guan@stonybrook.edu
 * Recitation: R01
 */
public class Passenger {
    private int id;
    private int arrivalTime;
    private boolean isFirstClass;

    /**
     * constructor class that creates a passenger based on given attributes provided
     * id represents the unique ID of each passenger
     * @param id
     * arrival time represents the time the passenger arrives at the station
     * @param arrivalTime
     * isFirstClass is a boolean that differentiates whether the passenger is first class or second
     * @param isFirstClass
     */
    public Passenger(int id, int arrivalTime, boolean isFirstClass){
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.isFirstClass = isFirstClass;
    }

    /**
     * sets the id of the passenger
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * sets the arrival time of the passenger
     * @param arrivalTime
     */
    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    /**
     * checks whether the passenger is first class
     * @return
     */
    public boolean isFirstClass() {
        return isFirstClass;
    }

    /**
     * returns the id of the passenger
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * returns the arrival time of the passenger
     * @return
     */
    public int getArrivalTime() {
        return arrivalTime;
    }

    /**
     * returns whether the passenger is first class
     * @return
     */
    public boolean getIsFirstClass(){
        return isFirstClass;
    }

    /**
     * returns string of passenger
     * @return
     */
    public String toString(){
        return "P"+id+"@T"+arrivalTime;
    }




}

