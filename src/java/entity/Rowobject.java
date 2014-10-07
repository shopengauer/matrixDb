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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "rowobject")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rowobject.findAll", query = "SELECT r FROM Rowobject r"),
    @NamedQuery(name = "Rowobject.findByIdRowobject", query = "SELECT r FROM Rowobject r WHERE r.idRowobject = :idRowobject"),
    @NamedQuery(name = "Rowobject.findByRowobjectCod", query = "SELECT r FROM Rowobject r WHERE r.rowobjectCod = :rowobjectCod"),
    @NamedQuery(name = "Rowobject.findByRowobjectPack", query = "SELECT r FROM Rowobject r WHERE r.rowobjectPack = :rowobjectPack"),
    @NamedQuery(name = "Rowobject.findByRowobjectDescription", query = "SELECT r FROM Rowobject r WHERE r.rowobjectDescription = :rowobjectDescription"),
    @NamedQuery(name = "Rowobject.findByRowobjectValue", query = "SELECT r FROM Rowobject r WHERE r.rowobjectValue = :rowobjectValue"),
    @NamedQuery(name = "Rowobject.findByRowobjectVoltage", query = "SELECT r FROM Rowobject r WHERE r.rowobjectVoltage = :rowobjectVoltage"),
    @NamedQuery(name = "Rowobject.findByRowobjectCurrent", query = "SELECT r FROM Rowobject r WHERE r.rowobjectCurrent = :rowobjectCurrent"),
    @NamedQuery(name = "Rowobject.findByRowobjectPower", query = "SELECT r FROM Rowobject r WHERE r.rowobjectPower = :rowobjectPower"),
    @NamedQuery(name = "Rowobject.findByRowobjectTolerance", query = "SELECT r FROM Rowobject r WHERE r.rowobjectTolerance = :rowobjectTolerance"),
    @NamedQuery(name = "Rowobject.findByRowobjectManufacture", query = "SELECT r FROM Rowobject r WHERE r.rowobjectManufacture = :rowobjectManufacture"),
    @NamedQuery(name = "Rowobject.findByRowobjectRohs", query = "SELECT r FROM Rowobject r WHERE r.rowobjectRohs = :rowobjectRohs"),
    @NamedQuery(name = "Rowobject.findByDescription", query = "SELECT r FROM Rowobject r WHERE r.description = :description")})
public class Rowobject implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rowobject")
    private Integer idRowobject;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "rowobject_cod")
    private String rowobjectCod;
    @Size(max = 45)
    @Column(name = "rowobject_pack")
    private String rowobjectPack;
    @Size(max = 128)
    @Column(name = "rowobject_description")
    private String rowobjectDescription;
    @Size(max = 45)
    @Column(name = "rowobject_value")
    private String rowobjectValue;
    @Size(max = 45)
    @Column(name = "rowobject_voltage")
    private String rowobjectVoltage;
    @Size(max = 45)
    @Column(name = "rowobject_current")
    private String rowobjectCurrent;
    @Size(max = 45)
    @Column(name = "rowobject_power")
    private String rowobjectPower;
    @Size(max = 45)
    @Column(name = "rowobject_tolerance")
    private String rowobjectTolerance;
    @Size(max = 45)
    @Column(name = "rowobject_manufacture")
    private String rowobjectManufacture;
    @Size(max = 45)
    @Column(name = "rowobject_rohs")
    private String rowobjectRohs;
    @Lob
    @Column(name = "rowobject_pdf")
    private byte[] rowobjectPdf;
    @Size(max = 45)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "timestamps_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RowobjectTime timestampsId;
    @JoinColumn(name = "rowobject_pdf_rowobject_pdf_id", referencedColumnName = "rowobject_pdf_id")
    @ManyToOne(optional = false)
    private RowobjectPdf rowobjectPdfRowobjectPdfId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rowobjectId")
    private List<Replacement> replacementList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rowobjectId")
    private List<PartReferences> partReferencesList;

    public Rowobject() {
    }

    public Rowobject(Integer idRowobject) {
        this.idRowobject = idRowobject;
    }

    public Rowobject(Integer idRowobject, String rowobjectCod) {
        this.idRowobject = idRowobject;
        this.rowobjectCod = rowobjectCod;
    }

    public Integer getIdRowobject() {
        return idRowobject;
    }

    public void setIdRowobject(Integer idRowobject) {
        this.idRowobject = idRowobject;
    }

    public String getRowobjectCod() {
        return rowobjectCod;
    }

    public void setRowobjectCod(String rowobjectCod) {
        this.rowobjectCod = rowobjectCod;
    }

    public String getRowobjectPack() {
        return rowobjectPack;
    }

    public void setRowobjectPack(String rowobjectPack) {
        this.rowobjectPack = rowobjectPack;
    }

    public String getRowobjectDescription() {
        return rowobjectDescription;
    }

    public void setRowobjectDescription(String rowobjectDescription) {
        this.rowobjectDescription = rowobjectDescription;
    }

    public String getRowobjectValue() {
        return rowobjectValue;
    }

    public void setRowobjectValue(String rowobjectValue) {
        this.rowobjectValue = rowobjectValue;
    }

    public String getRowobjectVoltage() {
        return rowobjectVoltage;
    }

    public void setRowobjectVoltage(String rowobjectVoltage) {
        this.rowobjectVoltage = rowobjectVoltage;
    }

    public String getRowobjectCurrent() {
        return rowobjectCurrent;
    }

    public void setRowobjectCurrent(String rowobjectCurrent) {
        this.rowobjectCurrent = rowobjectCurrent;
    }

    public String getRowobjectPower() {
        return rowobjectPower;
    }

    public void setRowobjectPower(String rowobjectPower) {
        this.rowobjectPower = rowobjectPower;
    }

    public String getRowobjectTolerance() {
        return rowobjectTolerance;
    }

    public void setRowobjectTolerance(String rowobjectTolerance) {
        this.rowobjectTolerance = rowobjectTolerance;
    }

    public String getRowobjectManufacture() {
        return rowobjectManufacture;
    }

    public void setRowobjectManufacture(String rowobjectManufacture) {
        this.rowobjectManufacture = rowobjectManufacture;
    }

    public String getRowobjectRohs() {
        return rowobjectRohs;
    }

    public void setRowobjectRohs(String rowobjectRohs) {
        this.rowobjectRohs = rowobjectRohs;
    }

    public byte[] getRowobjectPdf() {
        return rowobjectPdf;
    }

    public void setRowobjectPdf(byte[] rowobjectPdf) {
        this.rowobjectPdf = rowobjectPdf;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RowobjectTime getTimestampsId() {
        return timestampsId;
    }

    public void setTimestampsId(RowobjectTime timestampsId) {
        this.timestampsId = timestampsId;
    }

    public RowobjectPdf getRowobjectPdfRowobjectPdfId() {
        return rowobjectPdfRowobjectPdfId;
    }

    public void setRowobjectPdfRowobjectPdfId(RowobjectPdf rowobjectPdfRowobjectPdfId) {
        this.rowobjectPdfRowobjectPdfId = rowobjectPdfRowobjectPdfId;
    }

    @XmlTransient
    public List<Replacement> getReplacementList() {
        return replacementList;
    }

    public void setReplacementList(List<Replacement> replacementList) {
        this.replacementList = replacementList;
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
        hash += (idRowobject != null ? idRowobject.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rowobject)) {
            return false;
        }
        Rowobject other = (Rowobject) object;
        if ((this.idRowobject == null && other.idRowobject != null) || (this.idRowobject != null && !this.idRowobject.equals(other.idRowobject))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Rowobject[ idRowobject=" + idRowobject + " ]";
    }
    
}
