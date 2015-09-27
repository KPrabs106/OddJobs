package hackgt.oddjobs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.melnykov.fab.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.logging.Filter;

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
        ListView listView = (ListView) findViewById(R.id.jobListView);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.attachToListView(listView);
        fab.show();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), FormFillActivity.class));
            }
        });
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

        if (id == R.id.action_filter) {
            Intent i = new Intent(this.getApplicationContext(), FilterActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
