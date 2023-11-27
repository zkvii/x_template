package com.zkvii.fu.common;

import lombok.Getter;

@Getter
public enum ResponseCode {
    SUCCESS(200),
    ERROR(500),
    NOT_FOUND(404),
    UNAUTHORIZED(401),
    FORBIDDEN(403),
    BAD_REQUEST(400);

    private final int code;

    ResponseCode(int code) {
        this.code = code;
    }

}
