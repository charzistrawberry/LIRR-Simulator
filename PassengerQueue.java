/**
 * Name: Sharon Guan
 * SBU ID: 114430436
 * Email: sharon.guan@stonybrook.edu
 * Recitation: R01
 */

import java.util.ArrayList;

public class PassengerQueue extends ArrayList {

    /**
     * no arg constructor
     */
    public PassengerQueue(){

    }

    /**
     * adds passenger into queue
     * @param p
     */
    public void enqueue(Passenger p){
        this.add(p);
    }

    /**
     * removes passenger from queue
     * @return
     */
    public Passenger dequeue(){
        Passenger answer;
        answer = (Passenger) this.get(0);
        this.remove(0);
        return answer;
    }

    /**
     * peeks the first passenger of queue
     * @return
     */
    public Passenger peek(){
        return (Passenger)this.get(0);
    }

    /**
     * checks whether queue is empty
     * @return
     */
    public boolean isEmpty(){
        return (this.size()==0);
    }

    /**
     * prints array of all passengers
     * @return
     */
    public String toString(){
        String result = "[";
        for(int i = 0; i<this.size(); i++){
            result+= this.get(i).toString()+",";

        }
        result+= "]";
        return result;
    }


}
