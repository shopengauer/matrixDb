/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vasiliy
 */
@Entity
@Table(name = "part_references")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PartReferences.findAll", query = "SELECT p FROM PartReferences p"),
    @NamedQuery(name = "PartReferences.findByIdPartref", query = "SELECT p FROM PartReferences p WHERE p.idPartref = :idPartref"),
    @NamedQuery(name = "PartReferences.findByPartref", query = "SELECT p FROM PartReferences p WHERE p.partref = :partref"),
    @NamedQuery(name = "PartReferences.findByDescription", query = "SELECT p FROM PartReferences p WHERE p.description = :description")})
public class PartReferences implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_partref")
    private Integer idPartref;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "partref")
    private String partref;
    @Size(max = 45)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "rowobject_id", referencedColumnName = "id_rowobject")
    @ManyToOne(optional = false)
    private Rowobject rowobjectId;
    @JoinColumn(name = "techobject_part_id", referencedColumnName = "id_techobject_part")
    @ManyToOne(optional = false)
    private TechobjectPart techobjectPartId;

    public PartReferences() {
    }

    public PartReferences(Integer idPartref) {
        this.idPartref = idPartref;
    }

    public PartReferences(Integer idPartref, String partref) {
        this.idPartref = idPartref;
        this.partref = partref;
    }

    public Integer getIdPartref() {
        return idPartref;
    }

    public void setIdPartref(Integer idPartref) {
        this.idPartref = idPartref;
    }

    public String getPartref() {
        return partref;
    }

    public void setPartref(String partref) {
        this.partref = partref;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Rowobject getRowobjectId() {
        return rowobjectId;
    }

    public void setRowobjectId(Rowobject rowobjectId) {
        this.rowobjectId = rowobjectId;
    }

    public TechobjectPart getTechobjectPartId() {
        return techobjectPartId;
    }

    public void setTechobjectPartId(TechobjectPart techobjectPartId) {
        this.techobjectPartId = techobjectPartId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPartref != null ? idPartref.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PartReferences)) {
            return false;
        }
        PartReferences other = (PartReferences) object;
        if ((this.idPartref == null && other.idPartref != null) || (this.idPartref != null && !this.idPartref.equals(other.idPartref))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PartReferences[ idPartref=" + idPartref + " ]";
    }
    
}
