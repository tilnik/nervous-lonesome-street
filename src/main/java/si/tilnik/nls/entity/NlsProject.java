package si.tilnik.nls.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NLS_PROJECT")
public class NlsProject
{
    @Id
    @Column(name = "NLS_PROJECT_ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long nlsProjectId;
    @Column(name = "PROJECT_NAME")
    private String projectName;

    public Long getNlsProjectId()
    {
        return nlsProjectId;
    }

    public void setNlsProjectId(Long nlsProjectId)
    {
        this.nlsProjectId = nlsProjectId;
    }

    public String getProjectName()
    {
        return projectName;
    }

    public void setProjectName(String projectName)
    {
        this.projectName = projectName;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        NlsProject that = (NlsProject) o;
        return Objects.equals(getNlsProjectId(), that.getNlsProjectId()) &&
                Objects.equals(getProjectName(), that.getProjectName());
    }

    @Override
    public int hashCode()
    {

        return Objects.hash(getNlsProjectId(), getProjectName());
    }
}
