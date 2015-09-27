package hackgt.oddjobs;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * Created by prabh on 9/26/2015.
 */
public class ListingsAdapter extends ArrayAdapter<String> {

    private final Activity activity;
    private final int[] jobIds;
    private final String[] jobTitles;
    private final double[] costs;
    private final String[] categories;
    private final String[] locations;

    public ListingsAdapter(Activity activity, int[] jobIds, String[] jobTitles, double[] costs, String[] categories, String[] locations) {
        super(activity, R.layout.individual_listings_layout);
        this.activity = activity;
        this.jobIds = jobIds;
        this.jobTitles = jobTitles;
        this.costs = costs;
        this.categories = categories;
        this.locations = locations;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.individual_listings_layout, null, true);

        TextView tvTask = (TextView) view.findViewById(R.id.tvTask);
        tvTask.setText(jobTitles[position]);

        TextView tvCost = (TextView) view.findViewById(R.id.tvCost);
        tvCost.setText(formatMoney(costs[position]));

        TextView tvCategory = (TextView) view.findViewById(R.id.tvCategory);
        tvCategory.setText(categories[position]);

        TextView tvLocation = (TextView) view.findViewById(R.id.tvLocation);
        //TODO format location to only show zipcode
        tvLocation.setText(locations[position]);

        return rowView;
    }

    private String formatMoney(double cost) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(cost);
    }

}
