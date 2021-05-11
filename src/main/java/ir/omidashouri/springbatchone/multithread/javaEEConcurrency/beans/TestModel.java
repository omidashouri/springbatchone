package ir.omidashouri.springbatchone.multithread.javaEEConcurrency.beans;


import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TestModel implements Serializable {

    private String myId;


    public String getMyId() {
        return myId;
    }

    public void setMyId(String myId) {
        this.myId = myId;
    }
}
