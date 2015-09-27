package hackgt.oddjobs;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by prabh on 9/27/2015.
 */
public class JobListing implements Parcelable{

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

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(jobId);
        out.writeString(jobTitle);
        out.writeDouble(cost);
        out.writeString(category);
        out.writeString(location);
        out.writeString(date);
        out.writeString(time);
    }

    public static final Parcelable.Creator<JobListing> CREATOR = new Parcelable.Creator<JobListing>() {
        public JobListing createFromParcel(Parcel in) {
            return new JobListing(in);
        }

        public JobListing[] newArray(int size) {
            return new JobListing[size];
        }
    };

    public JobListing(Parcel in) {
        this.jobId = in.readInt();
        this.jobTitle = in.readString();
        this.cost = in.readDouble();
        this.category = in.readString();
        this.location = in.readString();
        this.date = in.readString();
        this.time = in.readString();
    }

}
