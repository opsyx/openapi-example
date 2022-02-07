package com.opsyx.openapi.sample.util;

import com.opsyx.openapi.sample.exceptions.InternalException;
import io.vavr.control.Try;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@UtilityClass
public class ResponseEntityUtil {

    public static <T> ResponseEntity<T> fromTryOk(Try<T> tryVariable) {
        return new ResponseEntity<>(tryVariable.getOrElseThrow(ResponseEntityUtil::handleException), HttpStatus.OK);
    }

    private static RuntimeException handleException(Throwable t) {
        if (t instanceof RuntimeException) {
            return (RuntimeException)t;
        }
        return new InternalException(t);
    }

}
