package hackgt.oddjobs;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class ClientInterface {
    private static final String baseURL = "54.174.103.9";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String URL, RequestParams requestParams, AsyncHttpResponseHandler responseHandler){
        client.get(getAbsoluteURL(URL), requestParams, responseHandler);
    }

    public static void post(String URL, RequestParams requestParams, AsyncHttpResponseHandler responseHandler){
        client.post(URL, requestParams, responseHandler);
    }

    private static String getAbsoluteURL(String relativeURL){
        return baseURL + relativeURL;
    }
}
