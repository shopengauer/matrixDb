/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vasiliy
 */
@Entity
@Table(name = "documentation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documentation.findAll", query = "SELECT d FROM Documentation d"),
    @NamedQuery(name = "Documentation.findByIdDocumentation", query = "SELECT d FROM Documentation d WHERE d.idDocumentation = :idDocumentation"),
    @NamedQuery(name = "Documentation.findByDocumentCod", query = "SELECT d FROM Documentation d WHERE d.documentCod = :documentCod"),
    @NamedQuery(name = "Documentation.findByDocumentName", query = "SELECT d FROM Documentation d WHERE d.documentName = :documentName"),
    @NamedQuery(name = "Documentation.findByDocumentDesc", query = "SELECT d FROM Documentation d WHERE d.documentDesc = :documentDesc"),
    @NamedQuery(name = "Documentation.findByDocumentFilename", query = "SELECT d FROM Documentation d WHERE d.documentFilename = :documentFilename"),
    @NamedQuery(name = "Documentation.findByCreateTime", query = "SELECT d FROM Documentation d WHERE d.createTime = :createTime"),
    @NamedQuery(name = "Documentation.findByUpdateTime", query = "SELECT d FROM Documentation d WHERE d.updateTime = :updateTime")})
public class Documentation implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_documentation")
    private Integer idDocumentation;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "document_cod")
    private String documentCod;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "document_name")
    private String documentName;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "document_desc")
    private String documentDesc;
    
    @Basic(optional = false, fetch = FetchType.LAZY)
    @NotNull
    @Lob
    @Column(name = "document_file")
    private byte[] documentFile;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "document_filename")
    private String documentFilename;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    
    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    
    @JoinColumn(name = "techobject_part_id", referencedColumnName = "id_techobject_part")
    @ManyToOne(optional = false)
    private TechobjectPart techobjectPartId;
    
    @JoinColumn(name = "document_type_id", referencedColumnName = "iddocument_type")
    @OneToOne(optional = false)
    private DocumentType documentTypeId;

    public Documentation() {
    }

    public Documentation(Integer idDocumentation) {
        this.idDocumentation = idDocumentation;
    }

    public Documentation(Integer idDocumentation, String documentCod, String documentName, String documentDesc, byte[] documentFile, String documentFilename, Date createTime) {
        this.idDocumentation = idDocumentation;
        this.documentCod = documentCod;
        this.documentName = documentName;
        this.documentDesc = documentDesc;
        this.documentFile = documentFile;
        this.documentFilename = documentFilename;
        this.createTime = createTime;
    }

    public Integer getIdDocumentation() {
        return idDocumentation;
    }

    public void setIdDocumentation(Integer idDocumentation) {
        this.idDocumentation = idDocumentation;
    }

    public String getDocumentCod() {
        return documentCod;
    }

    public void setDocumentCod(String documentCod) {
        this.documentCod = documentCod;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentDesc() {
        return documentDesc;
    }

    public void setDocumentDesc(String documentDesc) {
        this.documentDesc = documentDesc;
    }

    public byte[] getDocumentFile() {
        return documentFile;
    }

    public void setDocumentFile(byte[] documentFile) {
        this.documentFile = documentFile;
    }

    public String getDocumentFilename() {
        return documentFilename;
    }

    public void setDocumentFilename(String documentFilename) {
        this.documentFilename = documentFilename;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public TechobjectPart getTechobjectPartId() {
        return techobjectPartId;
    }

    public void setTechobjectPartId(TechobjectPart techobjectPartId) {
        this.techobjectPartId = techobjectPartId;
    }

    public DocumentType getDocumentTypeId() {
        return documentTypeId;
    }

    public void setDocumentTypeId(DocumentType documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocumentation != null ? idDocumentation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documentation)) {
            return false;
        }
        Documentation other = (Documentation) object;
        if ((this.idDocumentation == null && other.idDocumentation != null) || (this.idDocumentation != null && !this.idDocumentation.equals(other.idDocumentation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Documentation[ idDocumentation=" + idDocumentation + " ]";
    }
    
}
