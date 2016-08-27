package com.classfound.feedback.entity;

import javax.persistence.*;

/**
 * Created by philic3 on 8/27/2016.
 */
@Entity
@Table(name = "feedback", schema = "classfound_feedback")
public class FeedbackEntity {
    private long feedbackId;
    private String feedbackDescription;
    private String feedbackUserName;

    @Id
    @Column(name = "feedback_id", nullable = false)
    public long getFeedbackId() {
        return feedbackId;
    }

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

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (feedbackId ^ (feedbackId >>> 32));
        result = 31 * result + (feedbackDescription != null ? feedbackDescription.hashCode() : 0);
        result = 31 * result + (feedbackUserName != null ? feedbackUserName.hashCode() : 0);
        return result;
    }
}
