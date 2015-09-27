package hackgt.oddjobs;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.text.NumberFormat;

public class DetailedListingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_listing);
        JobListing job = getIntent().getParcelableExtra("jobList");

        TextView tvTask = (TextView) findViewById(R.id.tvTask);
        tvTask.setText(job.getJobTitle());

        TextView tvCategory = (TextView) findViewById(R.id.tvCategory);
        tvCategory.setText(job.getCategory());

        TextView tvCost = (TextView) findViewById(R.id.tvCost);
        tvCost.setText(formatMoney(job.getCost()));

        TextView tvDate = (TextView) findViewById(R.id.tvDate);
        tvDate.setText(job.getDateTime());

        TextView tvLocation = (TextView) findViewById(R.id.tvLocation);
        tvLocation.setText(job.getLocation());

        TextView tvAddComments = (TextView) findViewById(R.id.tvAddCommentField);
        tvAddComments.setText(job.getDetails());
        Log.e("add comment", job.getDetails());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detailed_listing, menu);
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

    private String formatMoney(double cost) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(cost);
    }
}
