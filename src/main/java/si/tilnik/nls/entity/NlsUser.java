package si.tilnik.nls.entity;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "NLS_USER")
public class NlsUser
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "NLS_USER_ID")
    private Long nlsUserId;
    @Column(name = "USERNAME", nullable = false)
    private String username;
    @Column(name = "NAME")
    private String name;
    @Column(name = "SURNAME")
    private String surname;
    @Column(name = "PASSWORD")
    private String password;

    @ManyToMany()
    private Set<NlsRole> roles;

    public Long getNlsUserId()
    {
        return nlsUserId;
    }

    public void setNlsUserId(Long nlsUserId)
    {
        this.nlsUserId = nlsUserId;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public Set<NlsRole> getRoles()
    {
        return roles;
    }

    public void setRoles(Set<NlsRole> roles)
    {
        this.roles = roles;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        NlsUser nlsUser = (NlsUser) o;
        return Objects.equals(getUsername(), nlsUser.getUsername()) &&
                Objects.equals(getNlsUserId(), nlsUser.getNlsUserId()) &&
                Objects.equals(getName(), nlsUser.getName()) &&
                Objects.equals(getSurname(), nlsUser.getSurname());
    }

    @Override
    public int hashCode()
    {

        return Objects.hash(getUsername(), getNlsUserId(), getName(), getSurname());
    }
}
