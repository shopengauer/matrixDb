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
import javax.persistence.Id;
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
@Table(name = "rowobject_time")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RowobjectTime.findAll", query = "SELECT r FROM RowobjectTime r"),
    @NamedQuery(name = "RowobjectTime.findByCreateTime", query = "SELECT r FROM RowobjectTime r WHERE r.createTime = :createTime"),
    @NamedQuery(name = "RowobjectTime.findByUpdateTime", query = "SELECT r FROM RowobjectTime r WHERE r.updateTime = :updateTime"),
    @NamedQuery(name = "RowobjectTime.findById", query = "SELECT r FROM RowobjectTime r WHERE r.id = :id")})
public class RowobjectTime implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "id")
    private String id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "timestampsId")
    private List<Rowobject> rowobjectList;

    public RowobjectTime() {
    }

    public RowobjectTime(String id) {
        this.id = id;
    }

    public RowobjectTime(String id, Date createTime) {
        this.id = id;
        this.createTime = createTime;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RowobjectTime)) {
            return false;
        }
        RowobjectTime other = (RowobjectTime) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.RowobjectTime[ id=" + id + " ]";
    }
    
}
