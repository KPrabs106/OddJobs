package hackgt.oddjobs;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;

public class FormFillActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_fill);

        Button submit = (Button) findViewById(R.id.btnSubmit);
        final EditText tbRequest = (EditText) findViewById(R.id.tbRequestTitle);
        final EditText tbAddress = (EditText) findViewById(R.id.tbAddress);
        final DatePicker dpDate = (DatePicker) findViewById(R.id.dpDate);
        final TimePicker tpTime = (TimePicker) findViewById(R.id.tpTime);
        final EditText tbCost = (EditText) findViewById(R.id.tbCost);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String request = String.valueOf(tbRequest.getText());
                String address = String.valueOf(tbAddress.getText());
                String dateTime = dpDate.getYear() + "-" + dpDate.getMonth() + "-" + dpDate.getDayOfMonth()
                        + " " + tpTime.getHour() + ":" + tpTime.getMinute() + ":" + "00";
                String cost = String.valueOf(tbCost.getText());
                //Log.e("Date time", dateTime);
                RequestParams requestParams = new RequestParams();
                requestParams.put("request", request);
                requestParams.put("address", address);
                requestParams.put("dateTime", dateTime);
                requestParams.put("cost", cost);

                ClientInterface.post("post_job.php", requestParams, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        Log.e(String.valueOf(statusCode),"");
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        Log.e(String.valueOf(statusCode),"");
                    }
                });
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_form_fill, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
