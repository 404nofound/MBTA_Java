package project;

import utils.Utils;

/**
 *
 * @author Eddy
 */
public class Direction extends Observer{
    
    public Direction(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }
    
    public void get() {
        Repository repository = new Repository("direction");
        
        for (Iterator iter = repository.getIterator(); iter.hasNext();) {
            String direction = (String)iter.next();
            System.out.println(direction);
        }
    }

    @Override
    public void update() {
        Utils.des = subject.getState();
        get();
    }
}
