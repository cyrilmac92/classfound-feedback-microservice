package com.classfound.feedback.entity;

import javax.persistence.*;

/**
 * Created by philic3 on 8/27/2016.
 */
@Entity
@Table(name = "feedback")
public class FeedbackEntity {
    private long feedbackId;
    private String feedbackDescription;
    private String feedbackUserName;
    private Long appId;
    private ApplicationEntity application;

    @Id
    @Column(name = "feedback_id", nullable = false)
    public long getFeedbackId() {
        return feedbackId;
    }

    @GeneratedValue(strategy = GenerationType.AUTO)
    public void setFeedbackId(long feedbackId) {
        this.feedbackId = feedbackId;
    }

    @Basic
    @Column(name = "feedback_description", nullable = true, length = 1000)
    public String getFeedbackDescription() {
        return feedbackDescription;
    }

    public void setFeedbackDescription(String feedbackDescription) {
        this.feedbackDescription = feedbackDescription;
    }

    @Basic
    @Column(name = "feedback_user_name", nullable = true, length = 200)
    public String getFeedbackUserName() {
        return feedbackUserName;
    }

    public void setFeedbackUserName(String feedbackUserName) {
        this.feedbackUserName = feedbackUserName;
    }

    @Basic
    @Column(name = "app_id", nullable = true)
    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FeedbackEntity that = (FeedbackEntity) o;

        if (feedbackId != that.feedbackId) return false;
        if (feedbackDescription != null ? !feedbackDescription.equals(that.feedbackDescription) : that.feedbackDescription != null)
            return false;
        if (feedbackUserName != null ? !feedbackUserName.equals(that.feedbackUserName) : that.feedbackUserName != null)
            return false;
        if (appId != null ? !appId.equals(that.appId) : that.appId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (feedbackId ^ (feedbackId >>> 32));
        result = 31 * result + (feedbackDescription != null ? feedbackDescription.hashCode() : 0);
        result = 31 * result + (feedbackUserName != null ? feedbackUserName.hashCode() : 0);
        result = 31 * result + (appId != null ? appId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "app_id", referencedColumnName = "app_id", insertable = false, updatable = false)
    public ApplicationEntity getApplication() {
        return application;
    }

    public void setApplication(ApplicationEntity application) {
        this.application = application;
    }
}
