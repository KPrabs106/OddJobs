package hackgt.oddjobs;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;

import cz.msebera.android.httpclient.Header;

public class ListingsActivity extends Activity {

    int[] jobIds;
    String[] jobTitles;
    double[] costs;
    String[] categories;
    String[] locations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listings);

        getJobListings();
    }

    private void getJobListings() {
        ClientInterface.post("get_all_jobs.php", null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                jobIds = new int[response.length()];
                jobTitles = new String[response.length()];
                costs = new double[response.length()];
                categories = new String[response.length()];
                locations = new String[response.length()];

                for (int i = 0; i < response.length(); i++) {
                    try {
                        jobIds[i] = response.getJSONObject(i).getInt("id");
                        jobTitles[i] = response.getJSONObject(i).getString("title");
                        costs[i] = response.getJSONObject(i).getDouble("cost");
                        categories[i] = response.getJSONObject(i).getString("category");
                        locations[i] = response.getJSONObject(i).getString("location");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                initJobListings();
            }
        });
    }

    private void initJobListings() {
        ListingsAdapter listingsAdapter = new ListingsAdapter(this, jobIds, jobTitles, costs, categories, locations);
        ListView jobListView = (ListView) findViewById(R.id.jobListView);
        jobListView.setAdapter(listingsAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_listings, menu);
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
