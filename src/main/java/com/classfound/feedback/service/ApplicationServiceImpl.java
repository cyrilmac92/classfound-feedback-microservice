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

