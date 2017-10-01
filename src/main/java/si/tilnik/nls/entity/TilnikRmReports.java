package si.tilnik.nls.entity;

import java.sql.Time;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table(name = "TILNIK_RM_REPORTS")
public class TilnikRmReports
{
    private Time datum;
    private String jira;
    private String opis;
    private Long trajanje;
    private String tip;
    private String izvajalec;

    @Basic
    @Column(name = "DATUM", nullable = true)
    public Time getDatum()
    {
        return datum;
    }

    public void setDatum(Time datum)
    {
        this.datum = datum;
    }

    @Basic
    @Column(name = "JIRA", nullable = true, length = 20)
    public String getJira()
    {
        return jira;
    }

    public void setJira(String jira)
    {
        this.jira = jira;
    }

    @Basic
    @Column(name = "OPIS", nullable = true, length = 255)
    public String getOpis()
    {
        return opis;
    }

    public void setOpis(String opis)
    {
        this.opis = opis;
    }

    @Basic
    @Column(name = "TRAJANJE", nullable = true, precision = 2)
    public Long getTrajanje()
    {
        return trajanje;
    }

    public void setTrajanje(Long trajanje)
    {
        this.trajanje = trajanje;
    }

    @Basic
    @Column(name = "TIP", nullable = true, length = 20)
    public String getTip()
    {
        return tip;
    }

    public void setTip(String tip)
    {
        this.tip = tip;
    }

    @Basic
    @Column(name = "IZVAJALEC", nullable = true, length = 20)
    public String getIzvajalec()
    {
        return izvajalec;
    }

    public void setIzvajalec(String izvajalec)
    {
        this.izvajalec = izvajalec;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        TilnikRmReports that = (TilnikRmReports) o;

        if (datum != null ? !datum.equals(that.datum) : that.datum != null)
            return false;
        if (jira != null ? !jira.equals(that.jira) : that.jira != null)
            return false;
        if (opis != null ? !opis.equals(that.opis) : that.opis != null)
            return false;
        if (trajanje != null ? !trajanje.equals(that.trajanje) : that.trajanje != null)
            return false;
        if (tip != null ? !tip.equals(that.tip) : that.tip != null)
            return false;
        if (izvajalec != null ? !izvajalec.equals(that.izvajalec) : that.izvajalec != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = datum != null ? datum.hashCode() : 0;
        result = 31 * result + (jira != null ? jira.hashCode() : 0);
        result = 31 * result + (opis != null ? opis.hashCode() : 0);
        result = 31 * result + (trajanje != null ? trajanje.hashCode() : 0);
        result = 31 * result + (tip != null ? tip.hashCode() : 0);
        result = 31 * result + (izvajalec != null ? izvajalec.hashCode() : 0);
        return result;
    }
}
