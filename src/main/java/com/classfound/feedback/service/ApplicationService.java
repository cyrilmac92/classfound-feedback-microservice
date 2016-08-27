package com.classfound.feedback.service;

import com.classfound.feedback.model.ApplicationModel;

/**
 * The service that contains all the business logic associated with application operations.
 * Created by philic3 on 8/27/2016.
 */
public interface ApplicationService {

    /**
     * Method to register a new application
     * @param applicationModel the application detials.
     */
    void registerApplication(ApplicationModel applicationModel) throws Exception;
}
