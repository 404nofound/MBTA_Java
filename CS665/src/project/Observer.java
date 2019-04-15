package project;

/**
 *
 * @author Eddy
 */
public abstract class Observer {
    
   protected Subject subject;
   
   public abstract void update();
}