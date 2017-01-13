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
