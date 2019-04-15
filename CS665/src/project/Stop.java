package project;

import utils.Utils;

/**
 *
 * @author Eddy
 */
public class Stop {
    public void get() {
        Utils.id_list.clear();
        
        Repository repository = new Repository("stop");
        
        System.out.println(Utils.line);
        
        for (Iterator iter = repository.getIterator(); iter.hasNext();) {
            String stop = (String)iter.next();
            System.out.println(stop);
        }
        System.out.println(Utils.line);
    }
}
