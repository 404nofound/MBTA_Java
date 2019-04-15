package project;

import utils.Utils;

/**
 *
 * @author Eddy
 */
public class Prediction extends Observer {
    
    public Prediction(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }
    
    public void get() {
        
        Repository repository = new Repository("prediction");
        
        System.out.println(Utils.line);
        
        for (Iterator iter = repository.getIterator(); iter.hasNext();) {
            String prediction = (String)iter.next();
            System.out.println(prediction);
        }
        
        System.out.println(Utils.line);
    }

    @Override
    public void update() {
        Utils.des = subject.getState();
        get();
    }
}
