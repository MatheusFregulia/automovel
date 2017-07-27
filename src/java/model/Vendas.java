/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aluno
 */
@Entity
@Table(name = "vendas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendas.findAll", query = "SELECT v FROM Vendas v"),
    @NamedQuery(name = "Vendas.findByIdVendas", query = "SELECT v FROM Vendas v WHERE v.idVendas = :idVendas"),
    @NamedQuery(name = "Vendas.findByData", query = "SELECT v FROM Vendas v WHERE v.data = :data")})
public class Vendas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idVendas")
    private Integer idVendas;
    @Basic(optional = false)
    @Column(name = "Data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @JoinColumn(name = "Automovel_placa", referencedColumnName = "placa")
    @ManyToOne(optional = false)
    private Automovel automovelplaca;
    @JoinColumn(name = "Comprador_idComprador", referencedColumnName = "idComprador")
    @ManyToOne(optional = false)
    private Comprador compradoridComprador;
    @JoinColumn(name = "Vendedor_idVendedor", referencedColumnName = "idVendedor")
    @ManyToOne(optional = false)
    private Vendedor vendedoridVendedor;

    public Vendas() {
    }

    public Vendas(Integer idVendas) {
        this.idVendas = idVendas;
    }

    public Vendas(Integer idVendas, Date data) {
        this.idVendas = idVendas;
        this.data = data;
    }

    public Integer getIdVendas() {
        return idVendas;
    }

    public void setIdVendas(Integer idVendas) {
        this.idVendas = idVendas;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Automovel getAutomovelplaca() {
        return automovelplaca;
    }

    public void setAutomovelplaca(Automovel automovelplaca) {
        this.automovelplaca = automovelplaca;
    }

    public Comprador getCompradoridComprador() {
        return compradoridComprador;
    }

    public void setCompradoridComprador(Comprador compradoridComprador) {
        this.compradoridComprador = compradoridComprador;
    }

    public Vendedor getVendedoridVendedor() {
        return vendedoridVendedor;
    }

    public void setVendedoridVendedor(Vendedor vendedoridVendedor) {
        this.vendedoridVendedor = vendedoridVendedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVendas != null ? idVendas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendas)) {
            return false;
        }
        Vendas other = (Vendas) object;
        if ((this.idVendas == null && other.idVendas != null) || (this.idVendas != null && !this.idVendas.equals(other.idVendas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Vendas[ idVendas=" + idVendas + " ]";
    }
    
}
