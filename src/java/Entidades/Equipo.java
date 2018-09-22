/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * @author julio
 */
@Entity
@Table(name = "equipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipo.findAll", query = "SELECT e FROM Equipo e")
    , @NamedQuery(name = "Equipo.findByNumequipo", query = "SELECT e FROM Equipo e WHERE e.numequipo = :numequipo")
    , @NamedQuery(name = "Equipo.findByNumjugadores", query = "SELECT e FROM Equipo e WHERE e.numjugadores = :numjugadores")
    , @NamedQuery(name = "Equipo.findByNombretecnico", query = "SELECT e FROM Equipo e WHERE e.nombretecnico = :nombretecnico")})
public class Equipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numequipo")
    private Integer numequipo;
    @Column(name = "numjugadores")
    private Integer numjugadores;
    @Size(max = 20)
    @Column(name = "nombretecnico")
    private String nombretecnico;
    @JoinColumn(name = "idjugador", referencedColumnName = "idjugador")
    @ManyToOne(fetch = FetchType.EAGER)
    private Jugador idjugador;

    public Equipo() {
    }

    public Equipo(Integer numequipo) {
        this.numequipo = numequipo;
    }

    public Integer getNumequipo() {
        return numequipo;
    }

    public void setNumequipo(Integer numequipo) {
        this.numequipo = numequipo;
    }

    public Integer getNumjugadores() {
        return numjugadores;
    }

    public void setNumjugadores(Integer numjugadores) {
        this.numjugadores = numjugadores;
    }

    public String getNombretecnico() {
        return nombretecnico;
    }

    public void setNombretecnico(String nombretecnico) {
        this.nombretecnico = nombretecnico;
    }

    public Jugador getIdjugador() {
        return idjugador;
    }

    public void setIdjugador(Jugador idjugador) {
        this.idjugador = idjugador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numequipo != null ? numequipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipo)) {
            return false;
        }
        Equipo other = (Equipo) object;
        if ((this.numequipo == null && other.numequipo != null) || (this.numequipo != null && !this.numequipo.equals(other.numequipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Equipo[ numequipo=" + numequipo + " ]";
    }
    
}
