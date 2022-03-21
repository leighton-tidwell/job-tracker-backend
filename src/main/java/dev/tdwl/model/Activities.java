package dev.tdwl.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("activities")
public class Activities {

    @Id
    private String id;

    @Indexed(unique = true)
    private String jobId;

    private String userId;

    private List<Activity> activities;

    public Activities(String jobId, String userId, List<Activity> activities) {
        super();
        this.jobId = jobId;
        this.userId = userId;
        this.activities = activities;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
