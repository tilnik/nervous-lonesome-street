package si.tilnik.nls.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "NLS_REPORT")
public class NlsReport
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NLS_REPORT_ID")
    private Long nlsReportId;
    @Column(name = "TICKET_ID")
    private String ticketId;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "START_TS_DAT")
    private Date startTsDat;
    @Column(name = "END_TS_DAT")
    private Date endTsDat;
    @JoinColumn(name = "NLS_ISSUE_TYPE_ID")
    @ManyToOne
    private NlsIssueType nlsIssueType;
    @JoinColumn(name = "NLS_USER_ID")
    @ManyToOne
    private NlsUser nlsUser;
    @JoinColumn(name = "NLS_PROJECT_ID")
    @ManyToOne
    private NlsProject nlsProject;

    public Long getNlsReportId()
    {
        return nlsReportId;
    }

    public void setNlsReportId(Long nlsReportId)
    {
        this.nlsReportId = nlsReportId;
    }

    public String getTicketId()
    {
        return ticketId;
    }

    public void setTicketId(String ticketId)
    {
        this.ticketId = ticketId;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Date getStartTsDat()
    {
        return startTsDat;
    }

    public void setStartTsDat(Date startTsDat)
    {
        this.startTsDat = startTsDat;
    }

    public Date getEndTsDat()
    {
        return endTsDat;
    }

    public void setEndTsDat(Date endTsDat)
    {
        this.endTsDat = endTsDat;
    }

    public NlsIssueType getNlsIssueType()
    {
        return nlsIssueType;
    }

    public void setNlsIssueType(NlsIssueType nlsIssueType)
    {
        this.nlsIssueType = nlsIssueType;
    }

    public NlsUser getNlsUser()
    {
        return nlsUser;
    }

    public void setNlsUser(NlsUser user)
    {
        this.nlsUser = user;
    }

    public NlsProject getNlsProject()
    {
        return nlsProject;
    }

    public void setNlsProject(NlsProject nlsProject)
    {
        this.nlsProject = nlsProject;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        NlsReport nlsReport = (NlsReport) o;
        return Objects.equals(getNlsReportId(), nlsReport.getNlsReportId()) &&
                Objects.equals(getTicketId(), nlsReport.getTicketId()) &&
                Objects.equals(getDescription(), nlsReport.getDescription()) &&
                Objects.equals(getStartTsDat(), nlsReport.getStartTsDat()) &&
                Objects.equals(getEndTsDat(), nlsReport.getEndTsDat()) &&
                Objects.equals(getNlsIssueType(), nlsReport.getNlsIssueType()) &&
                Objects.equals(getNlsUser(), nlsReport.getNlsUser()) &&
                Objects.equals(getNlsProject(), nlsReport.getNlsProject());
    }

    @Override
    public int hashCode()
    {

        return Objects.hash(getNlsReportId(), getTicketId(), getDescription(), getStartTsDat(), getEndTsDat(), getNlsIssueType(), getNlsUser(), getNlsProject());
    }
}
