/**
 * Name: Sharon Guan
 * SBU ID: 114430436
 * Email: sharon.guan@stonybrook.edu
 * Recitation: R01
 */

public class EmptyQueueException extends Exception {
    /**
     * Custom exception for when queue is empty
     */
    public EmptyQueueException(){
        super("Queue is empty");
    }

    /**
     * Takes in a string for exception and will change the default string
     * @param x
     */
    public EmptyQueueException(String x){
        super(x);
    }
}
