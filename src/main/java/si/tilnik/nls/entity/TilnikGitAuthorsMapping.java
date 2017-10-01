package si.tilnik.nls.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TILNIK_GIT_AUTHORS_MAPPING", schema = "AI_DEV", catalog = "")
public class TilnikGitAuthorsMapping
{
    private String username;
    private String name;
    private String email;

    @Id
    @Column(name = "USERNAME", nullable = true, length = 255)
    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    @Basic
    @Column(name = "NAME", nullable = true, length = 255)
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Basic
    @Column(name = "EMAIL", nullable = true, length = 255)
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        TilnikGitAuthorsMapping that = (TilnikGitAuthorsMapping) o;

        if (username != null ? !username.equals(that.username) : that.username != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null)
            return false;
        if (email != null ? !email.equals(that.email) : that.email != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
