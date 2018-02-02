package si.tilnik.nls.beans;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.jboss.logging.Logger;

public abstract class NlsEntityManager<T>
{
    protected final Logger log = Logger.getLogger(this.getClass());
    private final Class<T> baseType;
    @Inject
    private EntityManager em;

    public NlsEntityManager()
    {
        this(null);
    }

    public NlsEntityManager(Class<T> baseType)
    {
        this.baseType = baseType;
    }

    public List<T> getAll()
    {
        String ql = "SELECT e FROM " + baseType.getSimpleName() + " e";
        return getEntityManager().createQuery(ql, baseType).getResultList();
    }

    public EntityManager getEntityManager()
    {
        return em;
    }
}
