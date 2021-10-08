package com.example.test_task.controller;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseStatus {
    private boolean success = true;
    private List<String> errors;

    public void addError(String error){
        success = false;
        if(errors == null)
            errors = new ArrayList<>();
        errors.add(error);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
