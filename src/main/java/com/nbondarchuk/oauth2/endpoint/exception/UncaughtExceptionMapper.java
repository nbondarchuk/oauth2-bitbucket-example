package com.nbondarchuk.oauth2.endpoint.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.exception.ExceptionUtils;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class UncaughtExceptionMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable t) {
        return Response.serverError().entity(Error.of(t)).type(MediaType.APPLICATION_JSON_TYPE).build();
    }

    public static class Error {

        @Getter
        @Setter
        @JsonProperty
        private String message;

        @Getter
        @Setter
        @JsonProperty
        private String stacktrace;

        public static Error of(Throwable t) {
            Error error = new Error();
            error.setMessage(t.getMessage());
            error.setStacktrace(ExceptionUtils.getStackTrace(t));
            return error;
        }
    }
}