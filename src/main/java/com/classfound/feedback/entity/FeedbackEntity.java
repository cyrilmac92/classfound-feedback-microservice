/*
MIT License

Copyright (c) 2016 CYRIL MAC PHILIP

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

 */
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
