package si.tilnik.nls.beans;

import javax.ejb.Stateless;

import si.tilnik.nls.entity.NlsIssueType;

@Stateless
public class NlsIssueTypeManager extends NlsEntityManager<NlsIssueType>
{
    public NlsIssueTypeManager()
    {
        super(NlsIssueType.class);
    }
}
