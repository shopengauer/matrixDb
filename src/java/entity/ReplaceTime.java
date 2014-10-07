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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Vasiliy
 */
@Entity
@Table(name = "replace_time")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReplaceTime.findAll", query = "SELECT r FROM ReplaceTime r"),
    @NamedQuery(name = "ReplaceTime.findByCreateTime", query = "SELECT r FROM ReplaceTime r WHERE r.createTime = :createTime"),
    @NamedQuery(name = "ReplaceTime.findByUpdateTime", query = "SELECT r FROM ReplaceTime r WHERE r.updateTime = :updateTime"),
    @NamedQuery(name = "ReplaceTime.findById", query = "SELECT r FROM ReplaceTime r WHERE r.id = :id")})
public class ReplaceTime implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "timestamps1Id")
    private List<Replacement> replacementList;

    public ReplaceTime() {
    }

    public ReplaceTime(Integer id) {
        this.id = id;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public List<Replacement> getReplacementList() {
        return replacementList;
    }

    public void setReplacementList(List<Replacement> replacementList) {
        this.replacementList = replacementList;
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
        if (!(object instanceof ReplaceTime)) {
            return false;
        }
        ReplaceTime other = (ReplaceTime) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ReplaceTime[ id=" + id + " ]";
    }
    
}
