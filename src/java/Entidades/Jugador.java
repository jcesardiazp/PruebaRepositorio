/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
 * @author julio
 */
@Entity
@Table(name = "jugador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jugador.findAll", query = "SELECT j FROM Jugador j")
    , @NamedQuery(name = "Jugador.findByIdjugador", query = "SELECT j FROM Jugador j WHERE j.idjugador = :idjugador")
    , @NamedQuery(name = "Jugador.findByNombrejugador", query = "SELECT j FROM Jugador j WHERE j.nombrejugador = :nombrejugador")
    , @NamedQuery(name = "Jugador.findByNacionalidad", query = "SELECT j FROM Jugador j WHERE j.nacionalidad = :nacionalidad")
    , @NamedQuery(name = "Jugador.findByNumjugador", query = "SELECT j FROM Jugador j WHERE j.numjugador = :numjugador")})
public class Jugador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idjugador")
    private Integer idjugador;
    @Size(max = 20)
    @Column(name = "nombrejugador")
    private String nombrejugador;
    @Size(max = 20)
    @Column(name = "nacionalidad")
    private String nacionalidad;
    @Column(name = "numjugador")
    private Integer numjugador;
    @OneToMany(mappedBy = "idjugador", fetch = FetchType.EAGER)
    private List<Equipo> equipoList;

    public Jugador() {
    }

    public Jugador(Integer idjugador) {
        this.idjugador = idjugador;
    }

    public Integer getIdjugador() {
        return idjugador;
    }

    public void setIdjugador(Integer idjugador) {
        this.idjugador = idjugador;
    }

    public String getNombrejugador() {
        return nombrejugador;
    }

    public void setNombrejugador(String nombrejugador) {
        this.nombrejugador = nombrejugador;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Integer getNumjugador() {
        return numjugador;
    }

    public void setNumjugador(Integer numjugador) {
        this.numjugador = numjugador;
    }

    @XmlTransient
    public List<Equipo> getEquipoList() {
        return equipoList;
    }

    public void setEquipoList(List<Equipo> equipoList) {
        this.equipoList = equipoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idjugador != null ? idjugador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jugador)) {
            return false;
        }
        Jugador other = (Jugador) object;
        if ((this.idjugador == null && other.idjugador != null) || (this.idjugador != null && !this.idjugador.equals(other.idjugador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Jugador[ idjugador=" + idjugador + " ]";
    }
    
}
