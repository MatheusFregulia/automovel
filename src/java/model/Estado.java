/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Aluno
 */
@Entity
@Table(name = "estado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estado.findAll", query = "SELECT e FROM Estado e"),
    @NamedQuery(name = "Estado.findByIdEstado", query = "SELECT e FROM Estado e WHERE e.idEstado = :idEstado"),
    @NamedQuery(name = "Estado.findByEstadodoVeiculo", query = "SELECT e FROM Estado e WHERE e.estadodoVeiculo = :estadodoVeiculo")})
public class Estado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idEstado")
    private Integer idEstado;
    @Basic(optional = false)
    @Column(name = "Estado_do_Veiculo")
    private String estadodoVeiculo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoidEstado")
    private Collection<Automovel> automovelCollection;

    public Estado() {
    }

    public Estado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public Estado(Integer idEstado, String estadodoVeiculo) {
        this.idEstado = idEstado;
        this.estadodoVeiculo = estadodoVeiculo;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getEstadodoVeiculo() {
        return estadodoVeiculo;
    }

    public void setEstadodoVeiculo(String estadodoVeiculo) {
        this.estadodoVeiculo = estadodoVeiculo;
    }

    @XmlTransient
    public Collection<Automovel> getAutomovelCollection() {
        return automovelCollection;
    }

    public void setAutomovelCollection(Collection<Automovel> automovelCollection) {
        this.automovelCollection = automovelCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstado != null ? idEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estado)) {
            return false;
        }
        Estado other = (Estado) object;
        if ((this.idEstado == null && other.idEstado != null) || (this.idEstado != null && !this.idEstado.equals(other.idEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Estado[ idEstado=" + idEstado + " ]";
    }
    
}
