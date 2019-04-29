package com.gshepur.archunitexample.tasks;

import com.gshepur.archunitexample.methodannotation.Call;

import java.util.concurrent.Callable;

public class UploadUserDocsTask implements Callable<String>, RequestKeyAware {

    @Call
    private String call;


    @Override
    @Call
    public String call() throws Exception {
        return null;
    }

    @Override
    public String getRequestKey() {
        return "UploadUserDocTask";
    }
}
