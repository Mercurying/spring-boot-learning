package com.mercury.springbootlearning.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WSMessage {
    private String name;
}
