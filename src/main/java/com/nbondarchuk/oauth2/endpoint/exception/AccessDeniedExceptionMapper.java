package com.nbondarchuk.oauth2.endpoint.exception;

import org.springframework.security.access.AccessDeniedException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import static javax.ws.rs.core.Response.Status.FORBIDDEN;

/**
 * @author Nikolay Bondarchuk
 * @since 2020-04-05
 */
public class AccessDeniedExceptionMapper implements ExceptionMapper<AccessDeniedException> {

    @Override
    public Response toResponse(AccessDeniedException e) {
        return Response.status(FORBIDDEN).entity(e.getMessage()).build();
    }
}
