package hackgt.oddjobs;

/**
 * Created by prabh on 9/27/2015.
 */
public class JobListing {

    private int jobId;
    private String jobTitle;
    private double cost;
    private String category;
    private String location;

    public JobListing(int id, String jobTitle, double cost, String category, String location) {
        this.jobId = id;
        this.jobTitle = jobTitle;
        this.cost = cost;
        this.category = category;
        this.location = location;
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
}
