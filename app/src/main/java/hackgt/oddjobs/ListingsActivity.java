package hackgt.oddjobs;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
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

    JobListing[] jobListings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listings);

        getJobListings();
    }

    private void getJobListings() {
        ClientInterface.get("get_all_jobs.php", null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {

                jobListings = new JobListing[response.length()];
                int jobId;
                String jobTitle;
                double cost;
                String category;
                String location;
                String dateTime;
                String details;

                for (int i = 0; i < response.length(); i++) {
                    try {
                        jobId = response.getJSONObject(i).getInt("id");
                        jobTitle = response.getJSONObject(i).getString("title");
                        cost = response.getJSONObject(i).getDouble("cost");
                        category = response.getJSONObject(i).getString("category");
                        location = response.getJSONObject(i).getString("location");
                        dateTime = response.getJSONObject(i).getString("time");
                        details = response.getJSONObject(i).getString("details");

                        jobListings[i] = new JobListing(jobId, jobTitle, cost, category, location, dateTime, details);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                initJobListings();
            }
        });
    }

    private void initJobListings() {
        Log.e("Job Listing",jobListings[0].getDetails());
        ListingsAdapter listingsAdapter = new ListingsAdapter(this, jobListings);
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
