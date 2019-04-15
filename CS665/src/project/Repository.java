package project;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import utils.DirectionBean;
import utils.OkhttpUtil;
import utils.PredictionBean;
import utils.StopBean;
import utils.Utils;

/**
 *
 * @author Eddy
 */
public class Repository implements Container {
    
    public int check = -1;
    
    public DirectionBean directionItem;
    
    public List<DirectionBean.RoutesBean.LegsBean.StepsBean> directions;
    
    public List<PredictionBean.DataBeanXXX> predictions;
    
    public List<StopBean> stops;
    
    public Repository(String id) {
        if (id.equals("direction")) {
            check = 0;
            directionItem = OkhttpUtil.requestDirection();
            directions = directionItem.getRoutes().get(0).getLegs().get(0).getSteps();
        } else if (id.equals("prediction")) {
            check = 1;
            predictions = OkhttpUtil.requestPrediction().getData();
        } else if (id.equals("stop")) {
            check = 2;
            stops = OkhttpUtil.requestStop();
        }
    }
    
    @Override
    public Iterator getIterator() {
        return new AllIterator();
    }
    
    private class AllIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            if (check == 0) {
                if (index < directions.size()) {
                    return true;
                }
            } else if (check == 1) {
                if (index < predictions.size()) {
                    return true;
                }
            } else if (check == 2) {
                if (index < stops.size()) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                if (check == 0) {
                    return process_direction(index++);
                } else if (check == 1) {
                    return process_prediction(index++);
                } else if (check == 2) {
                    return process_stop(index++);
                }
            }
            return null;
        }
    }
    
    public String process_direction(int i) {
        if (i == 0) {
            String total_dis = directionItem.getRoutes().get(0).getLegs().get(0).getDistance().getText();
            String total_tim = directionItem.getRoutes().get(0).getLegs().get(0).getDuration().getText();            
            System.out.println(Utils.total_d + total_dis + " | " + Utils.total_t + total_tim + "\n" + Utils.line);
        }
        
        String info = directions.get(i).getHtml_instructions();
        String distance = directions.get(i).getDistance().getText();
        String time = directions.get(i).getDuration().getText();

        String content = info + " | " + distance + " | " + time;

        return (i + 1) + ". " + content.replaceAll("<.*?>", "");
    }
    
    public String process_prediction(int i) {
        
        //Train line name
        String route_id = predictions.get(i).getRelationships().getRoute().getData().getId();
        //Train line direction
        int direction = predictions.get(i).getAttributes().getDirection_id();

        //Define variables
        String labelText = "";
        String directionText = "";
        String[] dir;

        //Direction Judgement
        if (direction == 1) {
            dir = Utils.directions;
        } else {
            dir = Utils.oppose_directions;
        }

        //Name and image/icon Judgement
        if (route_id.startsWith("B")) {

            directionText = dir[7];
        } else if (route_id.startsWith("O")) {

            directionText = dir[2];
        } else if (route_id.startsWith("R")) {

            directionText = dir[0];
        } else if (route_id.startsWith("M")) {

            directionText = dir[1];
        } else if (route_id.startsWith("G")) {

            if (route_id.endsWith("B")) {
                directionText = dir[3];
            } else if (route_id.endsWith("C")) {
                directionText = dir[4];
            } else if (route_id.endsWith("D")) {
                directionText = dir[5];
            } else if (route_id.endsWith("E")) {
                directionText = dir[6];
            }
        }

        //Arriving time, departing time, how many stops away
        String arrTimeNode = predictions.get(i).getAttributes().getArrival_time();
        String depTimeNode = predictions.get(i).getAttributes().getDeparture_time();
        String status = predictions.get(i).getAttributes().getStatus();

        //Set time format
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String nowTime = df.format(new Date());
        String preTime = "";
        String arrTime = "";
        String depTime = "";
        long timeDifference = 0;

        //Processing time format and change then into human-readable format
        if ((arrTimeNode == null) && (depTimeNode == null)) {
            if (status == null) {
                //continue;
            } else {
                labelText = status;
            }
        } else if (!(arrTimeNode == null) && (depTimeNode == null)) {
            arrTime = arrTimeNode.substring(0, 19).replace("T", " ");
            preTime = arrTime;
        } else if ((arrTimeNode == null) && !(depTimeNode == null)) {
            depTime = depTimeNode.substring(0, 19).replace("T", " ");
            preTime = depTime;
        } else if (!(arrTimeNode == null) && !(depTimeNode == null)) {
            arrTime = arrTimeNode.substring(0, 19).replace("T", " ");
            preTime = arrTime;
        }

        //Calculate how many minutes the train will arriving
        if (!(arrTimeNode == null) || !(depTimeNode == null)) {
            try {
                Date nowDate = df.parse(nowTime);
                Date preDate = df.parse(preTime);

                //System.out.println(preDate);
                timeDifference = (preDate.getTime() - nowDate.getTime()) / 60000;

                labelText = timeDifference + " Min";
            } catch (ParseException ex) {
            }
        }
        return (i + 1) + ". " + route_id + " | " + labelText + " | " + directionText;

    }
    
    public String process_stop(int i) {
        StopBean stopItem = stops.get(i);
        Utils.id_list.add(stopItem.getName());
        return (i + 1) + ". " + stopItem.getName() + " | " + stopItem.getAddress() + " | " + stopItem.getId();
    }
}
