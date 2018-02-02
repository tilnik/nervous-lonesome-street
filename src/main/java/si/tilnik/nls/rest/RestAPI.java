package si.tilnik.nls.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.logging.Logger;

import si.tilnik.nls.beans.NlsIssueTypeManager;
import si.tilnik.nls.entity.NlsIssueType;

//import si.tilnik.nls.entity.Foo;

@Path("/")
//@RequestScoped
@Stateless
public class RestAPI
{
    private Logger log = Logger.getLogger(RestAPI.class);
    @EJB
    private NlsIssueTypeManager nlsIssueTypeManager;

    @GET
    @Produces("application/json")
    @Path("/getAllIssueTypes")
    public Response getAllIssueTypes()
    {
        List<NlsIssueType> all = nlsIssueTypeManager.getAll();
        return Response.ok(all, MediaType.APPLICATION_JSON_TYPE).build();
    }

    @GET
    @Produces("text/plain")
    @Path("/status")
    public String status()
    {
        log.debug("Invoked: get status ... It works");
        return "It works!";
    }

    //    @GET
    //    @Produces("text/plain")
    //    public String root()
    //    {
    //        InitialContext context = null;
    //        Connection connection = null;
    //        String username = null;
    //        try
    //        {
    //            context = new InitialContext();
    //            DataSource ds = (DataSource) context.lookup("java:jboss/datasources/NlsDS");
    //            connection = ds.getConnection();
    //            username = connection.getMetaData().getUserName();
    //        }
    //        catch (RuntimeException e)
    //        {
    //            throw e;
    //        }
    //        catch (Exception e)
    //        {
    //            throw new RuntimeException(e.getMessage(), e);
    //        }
    //        finally
    //        {
    //            if (connection != null)
    //            {
    //                try
    //                {
    //                    connection.close();
    //                }
    //                catch (Exception e)
    //                {
    //                    throw new RuntimeException(e.getMessage(), e);
    //                }
    //            }
    //        }
    //        return "Howdy " + username + " at " + new Date() + ".  ";
    //    }
}
