package hackgt.oddjobs;

import android.util.Log;

/**
 * Created by prabh on 9/27/2015.
 */
public class JobListing {

    private int jobId;
    private String jobTitle;
    private double cost;
    private String category;
    private String location;
    private String date;
    private String time;

    public JobListing(int id, String jobTitle, double cost, String category, String location, String dateTime) {
        this.jobId = id;
        this.jobTitle = jobTitle;
        this.cost = cost;
        this.category = category;
        this.location = location;
        this.date = dateTime.substring(0,dateTime.indexOf(" "));
        this.time = dateTime.substring(dateTime.indexOf(" "));
        Log.e("date",date);
        Log.e("time",time);
    }

    public int getJobId() {
        return jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public double getCost() {
        return cost;
    }

    public String getCategory() {
        return category;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() { return date; }

    public String getTime() { return time; }
}
