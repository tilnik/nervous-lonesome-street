package si.tilnik.nls.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NLS_ISSUE_TYPE")
public class NlsIssueType
{
    @Id
    @Column(name = "NLS_ISSUE_TYPE_ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long nlsIssueTypeId;
    @Column(name = "TYPE", nullable = false)
    private String type;
    @Column(name = "DESCRIPTION")
    private String description;

    public Long getNlsIssueTypeId()
    {
        return nlsIssueTypeId;
    }

    public void setNlsIssueTypeId(Long nlsIssueTypeId)
    {
        this.nlsIssueTypeId = nlsIssueTypeId;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        NlsIssueType that = (NlsIssueType) o;
        return Objects.equals(getNlsIssueTypeId(), that.getNlsIssueTypeId()) &&
                Objects.equals(getType(), that.getType()) &&
                Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode()
    {

        return Objects.hash(getNlsIssueTypeId(), getType(), getDescription());
    }
}
