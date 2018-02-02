package si.tilnik.nls.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NLS_ROLE")
public class NlsRole
{
    @Id
    @Column(name = "NLS_ROLE_ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long nlsRoleId;
    @Column(name = "ROLE_NAME", nullable = false)
    private String roleName;

    public Long getNlsRoleId()
    {
        return nlsRoleId;
    }

    public void setNlsRoleId(Long nlsRoleId)
    {
        this.nlsRoleId = nlsRoleId;
    }

    public String getRoleName()
    {
        return roleName;
    }

    public void setRoleName(String roleName)
    {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        NlsRole nlsRole = (NlsRole) o;
        return Objects.equals(getNlsRoleId(), nlsRole.getNlsRoleId()) &&
                Objects.equals(getRoleName(), nlsRole.getRoleName());
    }

    @Override
    public int hashCode()
    {

        return Objects.hash(getNlsRoleId(), getRoleName());
    }
}


