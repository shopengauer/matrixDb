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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "techobject_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TechobjectType.findAll", query = "SELECT t FROM TechobjectType t"),
    @NamedQuery(name = "TechobjectType.findByTechobjectTypeId", query = "SELECT t FROM TechobjectType t WHERE t.techobjectTypeId = :techobjectTypeId"),
    @NamedQuery(name = "TechobjectType.findByTechobjectType", query = "SELECT t FROM TechobjectType t WHERE t.techobjectType = :techobjectType"),
    @NamedQuery(name = "TechobjectType.findByTechobjectDesc", query = "SELECT t FROM TechobjectType t WHERE t.techobjectDesc = :techobjectDesc"),
    @NamedQuery(name = "TechobjectType.findByCreateTime", query = "SELECT t FROM TechobjectType t WHERE t.createTime = :createTime"),
    @NamedQuery(name = "TechobjectType.findByUpdateTime", query = "SELECT t FROM TechobjectType t WHERE t.updateTime = :updateTime")})
public class TechobjectType implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "techobject_type_id")
    private Integer techobjectTypeId;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "techobject_type")
    private String techobjectType;
    
    @Size(max = 512)
    @Column(name = "techobject_desc")
    private String techobjectDesc;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    
    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    public TechobjectType() {
    }

    public TechobjectType(Integer techobjectTypeId) {
        this.techobjectTypeId = techobjectTypeId;
    }

    public TechobjectType(Integer techobjectTypeId, String techobjectType, Date createTime) {
        this.techobjectTypeId = techobjectTypeId;
        this.techobjectType = techobjectType;
        this.createTime = createTime;
    }

    public Integer getTechobjectTypeId() {
        return techobjectTypeId;
    }

    public void setTechobjectTypeId(Integer techobjectTypeId) {
        this.techobjectTypeId = techobjectTypeId;
    }

    public String getTechobjectType() {
        return techobjectType;
    }

    public void setTechobjectType(String techobjectType) {
        this.techobjectType = techobjectType;
    }

    public String getTechobjectDesc() {
        return techobjectDesc;
    }

    public void setTechobjectDesc(String techobjectDesc) {
        this.techobjectDesc = techobjectDesc;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (techobjectTypeId != null ? techobjectTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TechobjectType)) {
            return false;
        }
        TechobjectType other = (TechobjectType) object;
        if ((this.techobjectTypeId == null && other.techobjectTypeId != null) || (this.techobjectTypeId != null && !this.techobjectTypeId.equals(other.techobjectTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TechobjectType[ techobjectTypeId=" + techobjectTypeId + " ]";
    }
    
}
