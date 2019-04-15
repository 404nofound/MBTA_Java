package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Eddy
 */
public class Utils {
    
    public static String dep;
    
    public static String des;
    
    public static String mode;
    
    public static List<String> id_list = new ArrayList<String>();
    
    public static String id;
    
    public static String train;
    
    public static String stop;
    //Train direction
    public static String[] directions = {"ALEWIFE - BRAINTREE", "ASHMONT - MATTAPAN", "OAK GROVE - FORSET HILLS", 
            "Park St - BOSTON COLLEGE", "NORTH STATION - CLEVELAND CIRCLE", "PARK St - RIVERSIDE",
            "LECHMERE - HEATH", "BOWDOIN - WONDERLAND"};
    
    //Train oppse direction
    public static String[] oppose_directions = {"BRAINTREE - ALEWIFE", "MATTAPAN - ASHMONT", "FORSET HILLS - OAK GROVE", 
            "BOSTON COLLEGE - Park St", "CLEVELAND CIRCLE - NORTH STATION", "RIVERSIDE - PARK St",
            "HEATH - LECHMERE", "WONDERLAND - BOWDOIN"};
    
    public static String welcome = "################################################################################\n" +
                                   "******  Wlcome to use train time prediction and route planning system  ******\n" +
                                   "################################################################################";
    
    public static String location = "Please input your current address, like: North Station, Boston, MA\n" +
                                    "################################################################################";
    
    public static String destination = "Please input your destination train station, like: Boston University East\n" +
                                       "################################################################################";
    
    public static String travel_mode = "Please choose one travel mode, like: walking, driving, bicycling\n" +
                                "################################################################################";
    
    public static String empty_input = "Warning: Please do not leave empty input. Please Try again.\n" + 
                                       "################################################################################";
    
    public static String error_input = "Warning: Please input correct instruction. Please Try again.\n" + 
                                       "################################################################################";
    
    public static String no_stop = "Warning: Cannot find this train station." +
                                   "################################################################################";
    
    public static String line = "################################################################################";
    
    public static String total_d = "################################################################################\n" +
                                   "The total distance is: ";
    
    public static String total_t = "The total time is: ";
    
    public static String main_menu = "(1) Route Planning => Train Prediction\n" +
                                     "(2) Get train Stop => Train Prediction\n" +
                                     "(0) Exit Now\n" +
                                     "################################################################################";
    
    public static String menu = "################################################################################\n" +
                                "(1) You can change another departure place\n" +
                                "(2) You can change another destination place\n" +
                                "(3) You can change another travel mode\n" +
                                "(4) Go back to main menu\n" +
                                "(0) Exit now\n" +
                                "################################################################################";
    
    public static String child_menu2 = "################################################################################\n" +
                                       "(1) You can change another train line\n" +
                                       "(2) You can change another stop of the same train\n" +
                                       "(3) Go back to main menu\n" +
                                       "(0) Exit now\n" +
                                       "################################################################################";
    
    public static String stop_id = "Alewife,place-alfcl,Davis,place-davis,Porter,place-portr,Harvard,place-harsq,Central,place-cntsq,Kendall/MIT,place-knncl,Charles/MGH,place-chmnl,Park Street,place-pktrm,Downtown Crossing,place-dwnxg,South Station,place-sstat,Broadway,place-brdwy,Andrew,place-andrw,JFK/UMass,place-jfk,Savin Hill,place-shmnl,Fields Corner,place-fldcr,Shawmut,place-smmnl,North Quincy,place-nqncy,Quincy Center,place-qnctr,Quincy Adams,place-qamnl,Braintree,place-brntn,Ashmont,place-asmnl,Bowdoin,place-bomnl,Government Center,place-gover,State Street,place-state,Aquarium,place-aqucl,Maverick,place-mvbcl,Airport,place-aport,Wood Island,place-wimnl,Orient Heights,place-orhte,Suffolk Downs,place-sdmnl,Beachmont,place-bmmnl,Revere Beach,place-rbmnl,Wonderland,place-wondl,Forest Hills,place-forhl,Green Street,place-grnst,Stony Brook,place-sbmnl,Jackson Square,place-jaksn,Roxbury Crossing,place-rcmnl,Ruggles,place-rugg,Massachusetts Avenue,place-masta,Back Bay,place-bbsta,Tufts Medical Center,place-tumnl,Chinatown,place-chncl,Downtown Crossing,place-dwnxg,State Street,place-state,Haymarket,place-haecl,North Station,place-north,Community College,place-ccmnl,Sullivan Square,place-sull,Assembly,place-astao,Wellington,place-welln,Malden Center,place-mlmnl,Oak Grove,place-ogmnl,Boston College,place-lake,South Street,place-sougr,Chestnut Hill Avenue,place-chill,Chiswick Road,place-chswk,Sutherland Road,place-sthld,Washington Street,place-wascm,Warren Street,place-wrnst,Allston Street,place-alsgr,Griggs Street,place-grigg,Harvard Avenue,place-harvd,Packards Corner,place-brico,Babcock Street,place-babck,Pleasant Street,place-plsgr,Saint Paul Street,place-stplb,Boston University West,place-buwst,Boston University Central,place-bucen,Boston University East,place-buest,Blandford Street,place-bland,Kenmore,place-kencl,Hynes Convention Center,place-hymnl,Copley,place-coecl,Arlington,place-armnl,Boylston,place-boyls,Park Street,place-pktrm,Cleveland Circle,place-clmnl,Englewood Avenue,place-engav,Dean Road,place-denrd,Tappan Street,place-tapst,Washington Square,place-bcnwa,Fairbanks Street,place-fbkst,Brandon Hall,place-bndhl,Summit Avenue,place-sumav,Coolidge Corner,place-cool,Saint Paul Street,place-stpul,Kent Street,place-kntst,Hawes Street,place-hwsst,Saint Marys Street,place-smary,Kenmore,place-kencl,Hynes Convention Center,place-hymnl,Copley,place-coecl,Arlington,place-armnl,Boylston,place-boyls,Park Street,place-pktrm,Government Center,place-gover,Haymarket,place-haecl,North Station,place-north,Government Center,place-gover,Park Street,place-pktrm,Boylston,place-boyls,Arlington,place-armnl,Copley,place-coecl,Hynes Convention Center,place-hymnl,Kenmore,place-kencl,Fenway,place-fenwy,Longwood,place-longw,Brookline Village,place-bvmnl,Brookline Hills,place-brkhl,Beaconsfield,place-bcnfd,Reservoir,place-rsmnl,Chestnut Hill,place-chhil,Newton Centre,place-newto,Newton Highlands,place-newtn,Eliot,place-eliot,Waban,place-waban,Woodland,place-woodl,Riverside,place-river,Heath Street,place-hsmnl,Back of the Hill,place-bckhl,Riverway,place-rvrwy,Mission Park,place-mispk,Fenwood Road,place-fenwd,Brigham Circle,place-brmnl,Longwood Medical Area,place-lngmd,Museum of Fine Arts,place-mfa,Northeastern University,place-nuniv,Symphony,place-symcl,Prudential,place-prmnl,Copley,place-coecl,Arlington,place-armnl,Boylston,place-boyls,Park Street,place-pktrm,Government Center,place-gover,Haymarket,place-haecl,North Station,place-north,Science Park,place-spmnl,Lechmere,place-lech,Ashmont,place-asmnl,Cedar Grove,place-cedgr,Butler,place-butlr,Milton,place-miltt,Central Avenue,place-cenav,Valley Road,place-valrd,Capen Street,place-capst,Mattapan,place-matt";
    
    public static String show_train = "################################################################################\n" +
                                      "Please choose one train line to continue:\n" +
                                      "(1) Red\n" +
                                      "(2) Mattapan\n" +
                                      "(3) Orange\n" +
                                      "(4) Blue\n" +
                                      "(5) Green B\n" +
                                      "(6) Green C\n" +
                                      "(7) Green D\n" +
                                      "(8) Green E\n" +
                                      "################################################################################";
    
    public static String choose_stop = "Please choose one stop to continue:\n" +
                                       "################################################################################";
    
    public static void get_departure() {
        System.out.println(Utils.location);
        dep = Utils.ask_input();
    }
    
    public static void get_destination() {
        System.out.println(Utils.destination);
        des = Utils.ask_input();
    }
    
    public static void get_mode() {
        System.out.println(Utils.travel_mode);
        mode = Utils.ask_input();
    }
    
    public static void get_train() {
        System.out.println(show_train);
        String choice = Utils.ask_input();
        
        switch (choice) {
            case "1":
                train = "red";
                break;
            case "2":
                train = "mattapan";
                break;
            case "3":
                train = "orange";
                break;
            case "4":
                train = "blue";
                break;
            case "5":
                train = "greenb";
                break;
            case "6":
                train = "greenc";
                break;
            case "7":
                train = "greend";
                break;
            case "8":
                train = "greene";
                break;
            default:
                System.out.println(error_input);
                get_train();
                break;
        }
    }
    
    public static void get_stop() {
        //Helper helper = Helper.getInstance();
        //helper.getStop();
        
        System.out.println(choose_stop);
        
        String choice = ask_input();
        
        des = id_list.get(Integer.parseInt(choice)-1);
        
        //helper.trainPrediction();
    }
    
    public static String ask_input() {
        Scanner scanner = new Scanner(System.in);
        String content = scanner.nextLine();
        
        if (content.trim().equals("") || content == null) {
            System.out.println(empty_input);
            ask_input();
        }
        return content;
    }
}
