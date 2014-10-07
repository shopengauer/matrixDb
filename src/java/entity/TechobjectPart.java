/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Vasiliy
 */
@Entity
@Table(name = "techobject_part")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TechobjectPart.findAll", query = "SELECT t FROM TechobjectPart t"),
    @NamedQuery(name = "TechobjectPart.findByIdTechobjectPart", query = "SELECT t FROM TechobjectPart t WHERE t.idTechobjectPart = :idTechobjectPart"),
    @NamedQuery(name = "TechobjectPart.findByPartName", query = "SELECT t FROM TechobjectPart t WHERE t.partName = :partName"),
    @NamedQuery(name = "TechobjectPart.findByPartCod", query = "SELECT t FROM TechobjectPart t WHERE t.partCod = :partCod"),
    @NamedQuery(name = "TechobjectPart.findByPartLevel", query = "SELECT t FROM TechobjectPart t WHERE t.partLevel = :partLevel"),
    @NamedQuery(name = "TechobjectPart.findByPartVersion", query = "SELECT t FROM TechobjectPart t WHERE t.partVersion = :partVersion"),
    @NamedQuery(name = "TechobjectPart.findByPartParent", query = "SELECT t FROM TechobjectPart t WHERE t.partParent = :partParent"),
    @NamedQuery(name = "TechobjectPart.findByCreateTime", query = "SELECT t FROM TechobjectPart t WHERE t.createTime = :createTime"),
    @NamedQuery(name = "TechobjectPart.findByUpdateTime", query = "SELECT t FROM TechobjectPart t WHERE t.updateTime = :updateTime")})
public class TechobjectPart implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_techobject_part")
    private Integer idTechobjectPart;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "part_name")
    private String partName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "part_cod")
    private String partCod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "part_level")
    private int partLevel;
    @Size(max = 75)
    @Column(name = "part_version")
    private String partVersion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "part_parent")
    private String partParent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "techobjectPartId")
    private List<Documentation> documentationList;
    @JoinColumn(name = "techobject_id", referencedColumnName = "id_techobject")
    @ManyToOne(optional = false)
    private Techobject techobjectId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "techobjectPartIdTechobjectPart")
    private List<TechobjectPart> techobjectPartList;
    @JoinColumn(name = "techobject_part_id_techobject_part", referencedColumnName = "id_techobject_part")
    @ManyToOne(optional = false)
    private TechobjectPart techobjectPartIdTechobjectPart;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "techobjectPartId")
    private List<PartReferences> partReferencesList;

    public TechobjectPart() {
    }

    public TechobjectPart(Integer idTechobjectPart) {
        this.idTechobjectPart = idTechobjectPart;
    }

    public TechobjectPart(Integer idTechobjectPart, String partName, String partCod, int partLevel, String partParent, Date createTime) {
        this.idTechobjectPart = idTechobjectPart;
        this.partName = partName;
        this.partCod = partCod;
        this.partLevel = partLevel;
        this.partParent = partParent;
        this.createTime = createTime;
    }

    public Integer getIdTechobjectPart() {
        return idTechobjectPart;
    }

    public void setIdTechobjectPart(Integer idTechobjectPart) {
        this.idTechobjectPart = idTechobjectPart;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getPartCod() {
        return partCod;
    }

    public void setPartCod(String partCod) {
        this.partCod = partCod;
    }

    public int getPartLevel() {
        return partLevel;
    }

    public void setPartLevel(int partLevel) {
        this.partLevel = partLevel;
    }

    public String getPartVersion() {
        return partVersion;
    }

    public void setPartVersion(String partVersion) {
        this.partVersion = partVersion;
    }

    public String getPartParent() {
        return partParent;
    }

    public void setPartParent(String partParent) {
        this.partParent = partParent;
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

    @XmlTransient
    public List<Documentation> getDocumentationList() {
        return documentationList;
    }

    public void setDocumentationList(List<Documentation> documentationList) {
        this.documentationList = documentationList;
    }

    public Techobject getTechobjectId() {
        return techobjectId;
    }

    public void setTechobjectId(Techobject techobjectId) {
        this.techobjectId = techobjectId;
    }

    @XmlTransient
    public List<TechobjectPart> getTechobjectPartList() {
        return techobjectPartList;
    }

    public void setTechobjectPartList(List<TechobjectPart> techobjectPartList) {
        this.techobjectPartList = techobjectPartList;
    }

    public TechobjectPart getTechobjectPartIdTechobjectPart() {
        return techobjectPartIdTechobjectPart;
    }

    public void setTechobjectPartIdTechobjectPart(TechobjectPart techobjectPartIdTechobjectPart) {
        this.techobjectPartIdTechobjectPart = techobjectPartIdTechobjectPart;
    }

    @XmlTransient
    public List<PartReferences> getPartReferencesList() {
        return partReferencesList;
    }

    public void setPartReferencesList(List<PartReferences> partReferencesList) {
        this.partReferencesList = partReferencesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTechobjectPart != null ? idTechobjectPart.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TechobjectPart)) {
            return false;
        }
        TechobjectPart other = (TechobjectPart) object;
        if ((this.idTechobjectPart == null && other.idTechobjectPart != null) || (this.idTechobjectPart != null && !this.idTechobjectPart.equals(other.idTechobjectPart))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TechobjectPart[ idTechobjectPart=" + idTechobjectPart + " ]";
    }
    
}
