/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.neomtech.gadm.bangladesh.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
@Table(name = "divisions")
@XmlRootElement
@ToString
@Getter
@Setter
@NoArgsConstructor
@NamedQueries({
    @NamedQuery(name = "Divisions.findAll", query = "SELECT d FROM Divisions d")
    , @NamedQuery(name = "Divisions.findById", query = "SELECT d FROM Divisions d WHERE d.id = :id")
    , @NamedQuery(name = "Divisions.findByName", query = "SELECT d FROM Divisions d WHERE d.name = :name")
    , @NamedQuery(name = "Divisions.findByBnName", query = "SELECT d FROM Divisions d WHERE d.bnName = :bnName")
    , @NamedQuery(name = "Divisions.findByUrl", query = "SELECT d FROM Divisions d WHERE d.url = :url")
    , @NamedQuery(name = "Divisions.engName", query = "SELECT d.id, d.name FROM Divisions d")})
public class Divisions implements Serializable {

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
    @Basic(optional = false)
    @Column(name = "url")
    private String url;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "divisionId")
    private Collection<Districts> districtsCollection;

    public Divisions(Integer id) {
        this.id = id;
    }

    public Divisions(Integer id, String name, String bnName, String url) {
        this.id = id;
        this.name = name;
        this.bnName = bnName;
        this.url = url;
    }

    @XmlTransient
    public Collection<Districts> getDistrictsCollection() {
        return districtsCollection;
    }

    public void setDistrictsCollection(Collection<Districts> districtsCollection) {
        this.districtsCollection = districtsCollection;
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
        if (!(object instanceof Divisions)) {
            return false;
        }
        Divisions other = (Divisions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}
