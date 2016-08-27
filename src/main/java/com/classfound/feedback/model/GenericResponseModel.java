package com.classfound.feedback.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

/**
 * The generic response model.
 * Created by philic3 on 8/27/2016.
 */
@JsonPOJOBuilder
public class GenericResponseModel {

    /**
     * The status of the response.
     */
    @JsonProperty(value = "status")
    private String status;

    /**
     * The message returned by the operation.
     */
    @JsonProperty(value = "message")
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
