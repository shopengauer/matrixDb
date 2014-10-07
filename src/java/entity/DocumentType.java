/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vasiliy
 */
@Entity
@Table(name = "document_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocumentType.findAll", query = "SELECT d FROM DocumentType d"),
    @NamedQuery(name = "DocumentType.findByIddocumentType", query = "SELECT d FROM DocumentType d WHERE d.iddocumentType = :iddocumentType"),
    @NamedQuery(name = "DocumentType.findByDocType", query = "SELECT d FROM DocumentType d WHERE d.docType = :docType"),
    @NamedQuery(name = "DocumentType.findByDocTypeDescription", query = "SELECT d FROM DocumentType d WHERE d.docTypeDescription = :docTypeDescription")})
public class DocumentType implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddocument_type")
    private Integer iddocumentType;
   
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "doc_type")
    private String docType;
   
    @Size(max = 512)
    @Column(name = "doc_type_description")
    private String docTypeDescription;
  
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "documentTypeId")
    private Documentation documentation;

    public DocumentType() {
    }

    public DocumentType(Integer iddocumentType) {
        this.iddocumentType = iddocumentType;
    }

    public DocumentType(Integer iddocumentType, String docType) {
        this.iddocumentType = iddocumentType;
        this.docType = docType;
    }

    public Integer getIddocumentType() {
        return iddocumentType;
    }

    public void setIddocumentType(Integer iddocumentType) {
        this.iddocumentType = iddocumentType;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getDocTypeDescription() {
        return docTypeDescription;
    }

    public void setDocTypeDescription(String docTypeDescription) {
        this.docTypeDescription = docTypeDescription;
    }

    public Documentation getDocumentation() {
        return documentation;
    }

    public void setDocumentation(Documentation documentation) {
        this.documentation = documentation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddocumentType != null ? iddocumentType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentType)) {
            return false;
        }
        DocumentType other = (DocumentType) object;
        if ((this.iddocumentType == null && other.iddocumentType != null) || (this.iddocumentType != null && !this.iddocumentType.equals(other.iddocumentType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DocumentType[ iddocumentType=" + iddocumentType + " ]";
    }
    
}
