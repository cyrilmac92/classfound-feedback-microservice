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
package com.classfound.feedback.controller;

import com.classfound.feedback.model.ApplicationModel;
import com.classfound.feedback.model.GenericResponseModel;
import com.classfound.feedback.service.ApplicationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
