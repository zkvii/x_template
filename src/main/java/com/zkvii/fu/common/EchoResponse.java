package com.zkvii.fu.common;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@Builder
@EqualsAndHashCode
public class EchoResponse {
    private ResponseCode code;
    private String message;
    private Object data;
}
