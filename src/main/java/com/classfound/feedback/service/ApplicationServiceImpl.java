package com.classfound.feedback.service;

import com.classfound.feedback.entity.ApplicationEntity;
import com.classfound.feedback.mapper.ApplicationMapper;
import com.classfound.feedback.model.ApplicationModel;
import com.classfound.feedback.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The service implementation for the application related operations.
 * Created by philic3 on 8/27/2016.
 */
@Service
public class ApplicationServiceImpl implements ApplicationService {

    /**
     * Autowiring the application repository.
     */
    @Autowired
    ApplicationRepository applicationRepository;

    /**
     * Method to register a new application
     * @param applicationModel the application detials.
     */
    public void registerApplication(ApplicationModel applicationModel) throws Exception {
        ApplicationEntity applicationEntity = ApplicationMapper.INSTANCE
                .applicationModelToApplicationEntity(applicationModel);
        if (applicationEntity == null) {
            throw new Exception("Invalid details");
        }
        if (!isAUniqueApplicationName(applicationEntity.getAppName())) {
            throw new Exception("Application Name is already used");
        }
        applicationRepository.save(applicationEntity);
    }

    /**
     * Verifies if the method is already been used.
     * @param applicationName the name of the application.
     * @return validity of the name.
     */
    private boolean isAUniqueApplicationName(String applicationName) {
        if (applicationRepository.findByAppName(applicationName) == null) {
            return true;
        } else {
            return false;
        }
    }

}

