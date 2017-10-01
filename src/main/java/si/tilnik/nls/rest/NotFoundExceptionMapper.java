package si.tilnik.nls.rest;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<Exception>
{
    @Override
    public Response toResponse(Exception e)
    {
        StringWriter stack = new StringWriter();
        e.printStackTrace(new PrintWriter(stack));
        return Response
                .status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(String.format("Error: %s\n%s ", e.getMessage(), stack.getBuffer().toString()))
                .type(MediaType.TEXT_PLAIN_TYPE)
                .build();
    }
}
