package si.tilnik.nls.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FOO")
public class Foo
{
    private Long col1;

    //    @Basic
    @Column(name = "COL1", nullable = true, precision = 3)
    @Id
    public Long getCol1()
    {
        return col1;
    }

    public void setCol1(Long col1)
    {
        this.col1 = col1;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Foo foo = (Foo) o;

        if (col1 != null ? !col1.equals(foo.col1) : foo.col1 != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        return col1 != null ? col1.hashCode() : 0;
    }
}
