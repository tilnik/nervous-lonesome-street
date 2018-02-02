package si.tilnik.nls.rest;

import java.sql.Connection;
import java.util.Date;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

//import si.tilnik.nls.entity.Foo;

@Path("/")
//@RequestScoped
@Stateless
public class MyResource
{
    @Inject
    private EntityManager em;

    @GET
    @Produces("text/plain")
    @Path("/foo")
    public String foo(@QueryParam("id") @DefaultValue("0") Long id)
    {
//        Optional<Foo> f = Optional.ofNullable(em.find(Foo.class, id));
//        String fooId = f
//                .map(Foo::getCol1)
//                .map(x -> x.toString())
//                .orElse("Not found!");
        //        Foo foo = em.find(Foo.class, id);
        return String.format("Foo col0: %s", "AAA");

    }

    @GET
    @Produces("text/plain")
    @Path("/status")
    public String status()
    {

        return "It works!";
    }

    @GET
    @Produces("text/plain")
    public String root()
    {
        InitialContext context = null;
        Connection connection = null;
        String username = null;
        try
        {
            context = new InitialContext();
            DataSource ds = (DataSource) context.lookup("java:jboss/datasources/NlsDS");
            connection = ds.getConnection();
            username = connection.getMetaData().getUserName();
        }
        catch (RuntimeException e)
        {
            throw e;
        }
        catch (Exception e)
        {
            throw new RuntimeException(e.getMessage(), e);
        }
        finally
        {
            if (connection != null)
            {
                try
                {
                    connection.close();
                }
                catch (Exception e)
                {
                    throw new RuntimeException(e.getMessage(), e);
                }
            }
        }
        return "Howdy " + username + " at " + new Date() + ".  ";
    }
}

