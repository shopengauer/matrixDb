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
@Table(name = "replacement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Replacement.findAll", query = "SELECT r FROM Replacement r"),
    @NamedQuery(name = "Replacement.findByIdReplacement", query = "SELECT r FROM Replacement r WHERE r.idReplacement = :idReplacement"),
    @NamedQuery(name = "Replacement.findByReplacementName", query = "SELECT r FROM Replacement r WHERE r.replacementName = :replacementName"),
    @NamedQuery(name = "Replacement.findByReplacementManufacture", query = "SELECT r FROM Replacement r WHERE r.replacementManufacture = :replacementManufacture"),
    @NamedQuery(name = "Replacement.findByAccepted", query = "SELECT r FROM Replacement r WHERE r.accepted = :accepted"),
    @NamedQuery(name = "Replacement.findByProductionTime", query = "SELECT r FROM Replacement r WHERE r.productionTime = :productionTime"),
    @NamedQuery(name = "Replacement.findByMoq", query = "SELECT r FROM Replacement r WHERE r.moq = :moq"),
    @NamedQuery(name = "Replacement.findByPriceUnit", query = "SELECT r FROM Replacement r WHERE r.priceUnit = :priceUnit")})
public class Replacement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_replacement")
    private Integer idReplacement;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "replacement_name")
    private String replacementName;
    @Size(max = 45)
    @Column(name = "replacement_manufacture")
    private String replacementManufacture;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "accepted")
    private String accepted;
    @Size(max = 45)
    @Column(name = "production_time")
    private String productionTime;
    @Size(max = 45)
    @Column(name = "moq")
    private String moq;
    @Column(name = "price_unit")
    private Long priceUnit;
    @JoinColumn(name = "rowobject_id", referencedColumnName = "id_rowobject")
    @ManyToOne(optional = false)
    private Rowobject rowobjectId;
    @JoinColumn(name = "timestamps_1_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ReplaceTime timestamps1Id;

    public Replacement() {
    }

    public Replacement(Integer idReplacement) {
        this.idReplacement = idReplacement;
    }

    public Replacement(Integer idReplacement, String replacementName, String accepted) {
        this.idReplacement = idReplacement;
        this.replacementName = replacementName;
        this.accepted = accepted;
    }

    public Integer getIdReplacement() {
        return idReplacement;
    }

    public void setIdReplacement(Integer idReplacement) {
        this.idReplacement = idReplacement;
    }

    public String getReplacementName() {
        return replacementName;
    }

    public void setReplacementName(String replacementName) {
        this.replacementName = replacementName;
    }

    public String getReplacementManufacture() {
        return replacementManufacture;
    }

    public void setReplacementManufacture(String replacementManufacture) {
        this.replacementManufacture = replacementManufacture;
    }

    public String getAccepted() {
        return accepted;
    }

    public void setAccepted(String accepted) {
        this.accepted = accepted;
    }

    public String getProductionTime() {
        return productionTime;
    }

    public void setProductionTime(String productionTime) {
        this.productionTime = productionTime;
    }

    public String getMoq() {
        return moq;
    }

    public void setMoq(String moq) {
        this.moq = moq;
    }

    public Long getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(Long priceUnit) {
        this.priceUnit = priceUnit;
    }

    public Rowobject getRowobjectId() {
        return rowobjectId;
    }

    public void setRowobjectId(Rowobject rowobjectId) {
        this.rowobjectId = rowobjectId;
    }

    public ReplaceTime getTimestamps1Id() {
        return timestamps1Id;
    }

    public void setTimestamps1Id(ReplaceTime timestamps1Id) {
        this.timestamps1Id = timestamps1Id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReplacement != null ? idReplacement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Replacement)) {
            return false;
        }
        Replacement other = (Replacement) object;
        if ((this.idReplacement == null && other.idReplacement != null) || (this.idReplacement != null && !this.idReplacement.equals(other.idReplacement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Replacement[ idReplacement=" + idReplacement + " ]";
    }
    
}
