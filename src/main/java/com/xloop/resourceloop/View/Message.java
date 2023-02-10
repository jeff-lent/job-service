package com.xloop.resourceloop.View;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {

    private String message;
    
    public Message(String applyingJob) {
        this.message = applyingJob;
    }


}
