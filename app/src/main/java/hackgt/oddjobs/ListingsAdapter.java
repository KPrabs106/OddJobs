package hackgt.oddjobs;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * Created by prabh on 9/26/2015.
 */
public class ListingsAdapter extends ArrayAdapter<JobListing> {

    private final Activity activity;
    private final JobListing[] jobListings;

    public ListingsAdapter(Activity activity, JobListing[] jobListings) {
        super(activity, R.layout.individual_listings_layout, jobListings);
        this.activity = activity;
        this.jobListings = jobListings;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.individual_listings_layout, null, true);

        TextView tvTask = (TextView) rowView.findViewById(R.id.tvTask);
        tvTask.setText(jobListings[position].getJobTitle());

        TextView tvCost = (TextView) rowView.findViewById(R.id.tvCost);
        tvCost.setText(formatMoney(jobListings[position].getCost()));

        TextView tvCategory = (TextView) rowView.findViewById(R.id.tvCategory);
        tvCategory.setText(jobListings[position].getCategory());

        TextView tvLocation = (TextView) rowView.findViewById(R.id.tvLocation);
        //TODO format location to only show zipcode
        tvLocation.setText(jobListings[position].getLocation());

        //TODO create on click listener and pass job id
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),DetailedListingActivity.class);
                i.putExtra("jobId", jobListings[position].getJobId());
                activity.startActivity(i);
            }
        });

        return rowView;
    }

    private String formatMoney(double cost) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(cost);
    }


}
