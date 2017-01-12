package com.classfound.feedback.controller;

import com.classfound.feedback.model.ApplicationModel;
import com.classfound.feedback.model.GenericResponseModel;
import com.classfound.feedback.service.ApplicationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.classfound.feedback.util.ConstantsUtil.APPLICATION_REGISTERED_SUCCESS_MESSAGE;
import static com.classfound.feedback.util.ConstantsUtil.ERROR_STATUS;
import static com.classfound.feedback.util.ConstantsUtil.SUCCESS_STATUS;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * The controller class that exposes application related end points.
 * Created by philic3 on 8/27/2016.
 */
@RestController
@RequestMapping(value = "/api/v1/application")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    private static final Logger LOG = Logger.getLogger("ApplicationController");

    /**
     * The endpoint that registers an application.
     * @param applicationModel the application details.
     * @return the status of the operation.
     */
    @RequestMapping(path = "/register", consumes = "application/json", method = POST)
    GenericResponseModel registerApplication(@RequestBody ApplicationModel applicationModel) {
        LOG.info("ApplicationController:registerApplication Enter");
        GenericResponseModel genericResponseModel = new GenericResponseModel();
        try {
            applicationService.registerApplication(applicationModel);
            genericResponseModel.setStatus(SUCCESS_STATUS);
            genericResponseModel.setMessage(APPLICATION_REGISTERED_SUCCESS_MESSAGE);
        } catch (Exception e) {
           genericResponseModel.setMessage(e.getMessage());
           genericResponseModel.setStatus(ERROR_STATUS);
        }
        return genericResponseModel;
    }
}
