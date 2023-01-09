/**
 * Name: Sharon Guan
 * SBU ID: 114430436
 * Email: sharon.guan@stonybrook.edu
 * Recitation: R01
 */
public class BooleanSource {
    private double probability;

    /**
     * sets the probability given by the parameters
     * @param p
     */
    public BooleanSource(double p){
        if(p< 0.0 || p > 1.0){
            throw new IllegalArgumentException();
        }
        probability = p;
    }

    /**
     * returns the occurrence of the probability
     * @return
     */
    public boolean occurs(){
        return (Math.random() < probability);
    }
}
