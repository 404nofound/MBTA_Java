package project;

import utils.Utils;

/**
 *
 * @author Eddy
 */
public class Init {
    public static void init() {
        
        Helper helper = Helper.getInstance();
        
        System.out.println(Utils.main_menu);
        
        String choice = Utils.ask_input();

        switch (choice) {
            case "1":
                Utils.get_departure();
                Utils.get_destination();
                Utils.get_mode();
                
                helper.findDirection();
                helper.trainPrediction();
                show_child_menu1();
                break;
            case "2":
                Utils.get_train();
                
                helper.getStop();
                Utils.get_stop();
                
                helper.trainPrediction();
                
                show_child_menu2();
                break;
            case "0":
                System.exit(0);
                break;
            default:
                System.out.println(Utils.error_input);
                init();
                break;
        }
    }
    
    public static void show_child_menu1() {
        System.out.println(Utils.menu);
        String choice = Utils.ask_input();
        
        Helper helper = Helper.getInstance();
        
        switch(choice) {
            case "1":
                Utils.get_departure();
                helper.findDirection();
                break;
            case "2":
                System.out.println(Utils.destination);
                String change = Utils.ask_input();
                helper.getSubject().setState(change);
                break;
            case "3":
                Utils.get_mode();
                helper.findDirection();
                break;
            case "4":
                init();
                break;
            case "0":
                System.exit(0);
                break;
        }
        show_child_menu1();
    }
    
    public static void show_child_menu2() {
        System.out.println(Utils.child_menu2);
        String choice = Utils.ask_input();
        
        Helper helper = Helper.getInstance();
        
        switch(choice) {
            case "1":
                Utils.get_train();
               
                helper.getStop();
                Utils.get_stop();
                helper.trainPrediction();
                break;
            case "2":
                helper.getStop();
                Utils.get_stop();
                helper.trainPrediction();
                break;
            case "3":
                init();
                break;
            case "0":
                System.exit(0);
                break;
        }
        show_child_menu2();
    }
}
