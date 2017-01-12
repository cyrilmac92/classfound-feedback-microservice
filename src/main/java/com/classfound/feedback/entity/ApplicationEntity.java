package com.classfound.feedback.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by philic3 on 8/27/2016.
 */
@Entity
@Table(name = "application")
public class ApplicationEntity {


    private long appId;
    private String appKey;
    private String appOwner;
    private String appName;
    private List<FeedbackEntity> feedbacks;

    @Id
    @Column(name = "app_id", nullable = false)
    public long getAppId() {
        return appId;
    }

    @GeneratedValue(strategy = GenerationType.AUTO)
    public void setAppId(long appId) {
        this.appId = appId;
    }

    @Basic
    @Column(name = "app_key", nullable = true, length = 1000)
    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    @Basic
    @Column(name = "app_owner", nullable = true, length = 200)
    public String getAppOwner() {
        return appOwner;
    }

    public void setAppOwner(String appOwner) {
        this.appOwner = appOwner;
    }

    @Basic
    @Column(name = "app_name", nullable = true, length = 200)
    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApplicationEntity that = (ApplicationEntity) o;

        if (appId != that.appId) return false;
        if (appKey != null ? !appKey.equals(that.appKey) : that.appKey != null) return false;
        if (appOwner != null ? !appOwner.equals(that.appOwner) : that.appOwner != null) return false;
        if (appName != null ? !appName.equals(that.appName) : that.appName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (appId ^ (appId >>> 32));
        result = 31 * result + (appKey != null ? appKey.hashCode() : 0);
        result = 31 * result + (appOwner != null ? appOwner.hashCode() : 0);
        result = 31 * result + (appName != null ? appName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "application")
    public List<FeedbackEntity> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<FeedbackEntity> feedbacks) {
        this.feedbacks = feedbacks;
    }
}
