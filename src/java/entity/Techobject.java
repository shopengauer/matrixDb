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
import javax.persistence.FetchType;
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
@Table(name = "techobject")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Techobject.findAll", query = "SELECT t FROM Techobject t"),
    @NamedQuery(name = "Techobject.findByIdTechobject", query = "SELECT t FROM Techobject t WHERE t.idTechobject = :idTechobject"),
    @NamedQuery(name = "Techobject.findByTechobjectName", query = "SELECT t FROM Techobject t WHERE t.techobjectName = :techobjectName"),
    @NamedQuery(name = "Techobject.findByTechobjectCod", query = "SELECT t FROM Techobject t WHERE t.techobjectCod = :techobjectCod"),
    @NamedQuery(name = "Techobject.findByTechobjectVersion", query = "SELECT t FROM Techobject t WHERE t.techobjectVersion = :techobjectVersion"),
    @NamedQuery(name = "Techobject.findByTechobjectDescription", query = "SELECT t FROM Techobject t WHERE t.techobjectDescription = :techobjectDescription"),
    @NamedQuery(name = "Techobject.findByCreateTime", query = "SELECT t FROM Techobject t WHERE t.createTime = :createTime"),
    @NamedQuery(name = "Techobject.findByUpdateTime", query = "SELECT t FROM Techobject t WHERE t.updateTime = :updateTime")})
public class Techobject implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id_techobject")
    private Integer idTechobject;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "techobject_name")
    private String techobjectName;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "techobject_cod")
    private String techobjectCod;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "techobject_version")
    private String techobjectVersion;
    
    @Size(max = 1024)
    @Column(name = "techobject_description")
    private String techobjectDescription;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    
    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeId;
    
    @JoinColumn(name = "techobject_type_id", referencedColumnName = "techobject_type_id")
    @ManyToOne(optional = false)
    private TechobjectType techobjectTypeId;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "techobjectId", fetch = FetchType.LAZY)
    private List<TechobjectPart> techobjectPartList;

    public Techobject() {
    }

    public Techobject(Integer idTechobject) {
        this.idTechobject = idTechobject;
    }

    public Techobject(Integer idTechobject, String techobjectName, String techobjectCod, String techobjectVersion, Date createTime) {
        this.idTechobject = idTechobject;
        this.techobjectName = techobjectName;
        this.techobjectCod = techobjectCod;
        this.techobjectVersion = techobjectVersion;
        this.createTime = createTime;
    }

    public Integer getIdTechobject() {
        return idTechobject;
    }

    public void setIdTechobject(Integer idTechobject) {
        this.idTechobject = idTechobject;
    }

    public String getTechobjectName() {
        return techobjectName;
    }

    public void setTechobjectName(String techobjectName) {
        this.techobjectName = techobjectName;
    }

    public String getTechobjectCod() {
        return techobjectCod;
    }

    public void setTechobjectCod(String techobjectCod) {
        this.techobjectCod = techobjectCod;
    }

    public String getTechobjectVersion() {
        return techobjectVersion;
    }

    public void setTechobjectVersion(String techobjectVersion) {
        this.techobjectVersion = techobjectVersion;
    }

    public String getTechobjectDescription() {
        return techobjectDescription;
    }

    public void setTechobjectDescription(String techobjectDescription) {
        this.techobjectDescription = techobjectDescription;
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

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public TechobjectType getTechobjectTypeId() {
        return techobjectTypeId;
    }

    public void setTechobjectTypeId(TechobjectType techobjectTypeId) {
        this.techobjectTypeId = techobjectTypeId;
    }

    @XmlTransient
    public List<TechobjectPart> getTechobjectPartList() {
        return techobjectPartList;
    }

    public void setTechobjectPartList(List<TechobjectPart> techobjectPartList) {
        this.techobjectPartList = techobjectPartList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTechobject != null ? idTechobject.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Techobject)) {
            return false;
        }
        Techobject other = (Techobject) object;
        if ((this.idTechobject == null && other.idTechobject != null) || (this.idTechobject != null && !this.idTechobject.equals(other.idTechobject))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Techobject[ idTechobject=" + idTechobject + " ]";
    }
    
}
