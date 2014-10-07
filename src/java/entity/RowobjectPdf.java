/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Vasiliy
 */
@Entity
@Table(name = "rowobject_pdf")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RowobjectPdf.findAll", query = "SELECT r FROM RowobjectPdf r"),
    @NamedQuery(name = "RowobjectPdf.findByRowobjectPdfId", query = "SELECT r FROM RowobjectPdf r WHERE r.rowobjectPdfId = :rowobjectPdfId"),
    @NamedQuery(name = "RowobjectPdf.findByRowobjectPdfFilename", query = "SELECT r FROM RowobjectPdf r WHERE r.rowobjectPdfFilename = :rowobjectPdfFilename")})
public class RowobjectPdf implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rowobject_pdf_id")
    private Integer rowobjectPdfId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "rowobject_pdf_filename")
    private String rowobjectPdfFilename;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "rowobject_pdf")
    private byte[] rowobjectPdf;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rowobjectPdfRowobjectPdfId")
    private List<Rowobject> rowobjectList;

    public RowobjectPdf() {
    }

    public RowobjectPdf(Integer rowobjectPdfId) {
        this.rowobjectPdfId = rowobjectPdfId;
    }

    public RowobjectPdf(Integer rowobjectPdfId, String rowobjectPdfFilename, byte[] rowobjectPdf) {
        this.rowobjectPdfId = rowobjectPdfId;
        this.rowobjectPdfFilename = rowobjectPdfFilename;
        this.rowobjectPdf = rowobjectPdf;
    }

    public Integer getRowobjectPdfId() {
        return rowobjectPdfId;
    }

    public void setRowobjectPdfId(Integer rowobjectPdfId) {
        this.rowobjectPdfId = rowobjectPdfId;
    }

    public String getRowobjectPdfFilename() {
        return rowobjectPdfFilename;
    }

    public void setRowobjectPdfFilename(String rowobjectPdfFilename) {
        this.rowobjectPdfFilename = rowobjectPdfFilename;
    }

    public byte[] getRowobjectPdf() {
        return rowobjectPdf;
    }

    public void setRowobjectPdf(byte[] rowobjectPdf) {
        this.rowobjectPdf = rowobjectPdf;
    }

    @XmlTransient
    public List<Rowobject> getRowobjectList() {
        return rowobjectList;
    }

    public void setRowobjectList(List<Rowobject> rowobjectList) {
        this.rowobjectList = rowobjectList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rowobjectPdfId != null ? rowobjectPdfId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RowobjectPdf)) {
            return false;
        }
        RowobjectPdf other = (RowobjectPdf) object;
        if ((this.rowobjectPdfId == null && other.rowobjectPdfId != null) || (this.rowobjectPdfId != null && !this.rowobjectPdfId.equals(other.rowobjectPdfId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.RowobjectPdf[ rowobjectPdfId=" + rowobjectPdfId + " ]";
    }
    
}
