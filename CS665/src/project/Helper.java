package project;

import utils.Utils;

/**
 *
 * @author Eddy
 */
public class Helper {
    
    private Subject subject;
    private Direction direction;
    private Prediction prediction;
    private Stop stop;
    
    private static Helper instance = new Helper();
    
    private Helper() {
        
        System.out.println(Utils.welcome);
        
        subject = new Subject();
        
        direction = new Direction(subject);
        prediction = new Prediction(subject);
        stop = new Stop();
    }
    
    public Subject getSubject() {
        return subject;
    }
    
    public static synchronized Helper getInstance() {
        if (instance == null) {
            instance = new Helper();
        }
        return instance;
    }
    
    public void findDirection() {
        direction.get();
    }
    
    public void trainPrediction() {
        prediction.get();
    }
    
    public void getStop() {
        stop.get();
    }
}
