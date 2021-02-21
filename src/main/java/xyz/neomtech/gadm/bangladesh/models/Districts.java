/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.neomtech.gadm.bangladesh.models;

import lombok.ToString;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author G7
 */
@Entity
@Table(name = "districts")
@XmlRootElement
@ToString
@NamedQueries({
    @NamedQuery(name = "Districts.findAll", query = "SELECT d FROM Districts d")
    , @NamedQuery(name = "Districts.findById", query = "SELECT d FROM Districts d WHERE d.id = :id")
    , @NamedQuery(name = "Districts.findByName", query = "SELECT d FROM Districts d WHERE d.name = :name")
    , @NamedQuery(name = "Districts.findByBnName", query = "SELECT d FROM Districts d WHERE d.bnName = :bnName")
    , @NamedQuery(name = "Districts.findByLat", query = "SELECT d FROM Districts d WHERE d.lat = :lat")
    , @NamedQuery(name = "Districts.findByLon", query = "SELECT d FROM Districts d WHERE d.lon = :lon")
    , @NamedQuery(name = "Districts.findByUrl", query = "SELECT d FROM Districts d WHERE d.url = :url")})
public class Districts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "bn_name")
    private String bnName;
    @Column(name = "lat")
    private String lat;
    @Column(name = "lon")
    private String lon;
    @Basic(optional = false)
    @Column(name = "url")
    private String url;
    @JoinColumn(name = "division_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Divisions divisionId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "districtId")
    private Collection<Upazilas> upazilasCollection;

    public Districts() {
    }

    public Districts(Integer id) {
        this.id = id;
    }

    public Districts(Integer id, String name, String bnName, String url) {
        this.id = id;
        this.name = name;
        this.bnName = bnName;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBnName() {
        return bnName;
    }

    public void setBnName(String bnName) {
        this.bnName = bnName;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Divisions getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Divisions divisionId) {
        this.divisionId = divisionId;
    }

    @XmlTransient
    public Collection<Upazilas> getUpazilasCollection() {
        return upazilasCollection;
    }

    public void setUpazilasCollection(Collection<Upazilas> upazilasCollection) {
        this.upazilasCollection = upazilasCollection;
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
        if (!(object instanceof Districts)) {
            return false;
        }
        Districts other = (Districts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
