package utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.util.List;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 *
 * @author Eddy
 */
public class OkhttpUtil {
    public static DirectionBean requestDirection() {
        try {
            String url = "https://maps.googleapis.com/maps/api/directions/json?origin=" + Utils.dep + "&destination=" + Utils.des + "&mode=" + Utils.mode + "&key=Please_replace_with_your_own_Key";
             
            OkHttpClient client = new OkHttpClient();
            
            Request request = new Request.Builder().url(url).build();
            Response response = client.newCall(request).execute();
            
            Gson gson = new Gson();
            DirectionBean directionItem = gson.fromJson(response.body().string().trim(), DirectionBean.class);
            
            return directionItem;
        } catch (IOException ex) {
        }
        return null;
    }
    
    public static PredictionBean requestPrediction() {
        try {
            String[] Ids = Utils.stop_id.split(",");
            for (int i = 0; i < Ids.length; i += 2) {
                if (Ids[i].toLowerCase().equals(Utils.des.toLowerCase())) {
                    Utils.id = Ids[i+1];
                }
            }
            String url = "https://api-v3.mbta.com/predictions?filter[route]=Blue,Orange,Red,Mattapan,Green-B,Green-C,Green-D,Green-E&filter[stop]=" + Utils.id;
            
            OkHttpClient client = new OkHttpClient();
            
            Request request = new Request.Builder().url(url).build();
            Response response = client.newCall(request).execute();
            
            Gson gson2 = new Gson();
            PredictionBean predictionItem = gson2.fromJson(response.body().string().trim(), PredictionBean.class);
            
            return predictionItem;
        } catch (IOException ex) {
        }
        return null;
    }
    
    public static List<StopBean> requestStop() {
        try {
            String url = "https://www.yichangshao.com/stop.php";
            
            OkHttpClient client = new OkHttpClient();
            
            FormBody.Builder builder = new FormBody.Builder();
            builder.add("train", Utils.train);
            RequestBody formBody = builder.build();
            Request request = new Request.Builder().url(url).post(formBody).build();
            Response response = client.newCall(request).execute();
            
            Gson gson = new Gson();
            List<StopBean> stopList = gson.fromJson(response.body().string().trim(), new TypeToken<List<StopBean>>(){}.getType());
            
            return stopList;
        } catch (IOException ex) {
        }
        return null;
    }
}
