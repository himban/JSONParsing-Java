import com.codesnippets4all.json.parsers.JSONParser;
import com.codesnippets4all.json.parsers.JsonParserFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;


/**
 * Created by Himanshu on 30-03-2017.
 */
public class HTTPRequest {
    public static void main(String[] args) throws JSONException {
         URL url = null;
        try {
           url = new URL("https://jsonplaceholder.typicode.com/posts");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try {
            assert url != null;
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();  // Finally connect to the URL
//            for(int i=0;i<10;i++){        // Get URL Headers
//                System.out.println( httpURLConnection.getHeaderField(i));
//            }

//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(),"utf-8"));
//            StringBuilder stringBuilder = new StringBuilder();
//            String line = bufferedReader.readLine();
//            while(line!=null ){
//                stringBuilder.append(line);
//                line = bufferedReader.readLine();
//            }
//            String response  = stringBuilder.toString();
//            System.out.println(response);

            if(httpURLConnection.getResponseCode()==200){
                JsonParserFactory jsonParserFactory = JsonParserFactory.getInstance();
                JSONParser jsonParser = jsonParserFactory.newJsonParser();
                Map jsonData  = jsonParser.parseJson(httpURLConnection.getInputStream(),"utf-8");
              //  String date = jsonData.get("ip").toString();
                JSONObject jsonObject = new JSONObject(jsonData);
                JSONArray jsonArray = null;

                try {
                    jsonArray = jsonObject.getJSONArray("root");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                System.out.println(jsonArray);

                assert jsonArray != null;
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonobject = jsonArray.getJSONObject(i);
                    String  x = jsonobject.getString("userId");
                    System.out.println(x);
                    String url1 = jsonobject.getString("id");
                    System.out.println(url1);
                }


            }



        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
