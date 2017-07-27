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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "automovel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Automovel.findAll", query = "SELECT a FROM Automovel a"),
    @NamedQuery(name = "Automovel.findByPlaca", query = "SELECT a FROM Automovel a WHERE a.placa = :placa"),
    @NamedQuery(name = "Automovel.findByNome", query = "SELECT a FROM Automovel a WHERE a.nome = :nome"),
    @NamedQuery(name = "Automovel.findByAnoFabricacao", query = "SELECT a FROM Automovel a WHERE a.anoFabricacao = :anoFabricacao"),
    @NamedQuery(name = "Automovel.findByModelo", query = "SELECT a FROM Automovel a WHERE a.modelo = :modelo"),
    @NamedQuery(name = "Automovel.findByCor", query = "SELECT a FROM Automovel a WHERE a.cor = :cor"),
    @NamedQuery(name = "Automovel.findByPreco", query = "SELECT a FROM Automovel a WHERE a.preco = :preco")})
public class Automovel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "placa")
    private Integer placa;
    @Basic(optional = false)
    @Column(name = "Nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "Ano_Fabricacao")
    private String anoFabricacao;
    @Basic(optional = false)
    @Column(name = "Modelo")
    private String modelo;
    @Basic(optional = false)
    @Column(name = "Cor")
    private String cor;
    @Basic(optional = false)
    @Column(name = "Preco")
    private float preco;
    @JoinColumn(name = "Estado_idEstado", referencedColumnName = "idEstado")
    @ManyToOne(optional = false)
    private Estado estadoidEstado;
    @JoinColumn(name = "Marca_idMarca", referencedColumnName = "idMarca")
    @ManyToOne(optional = false)
    private Marca marcaidMarca;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "automovelplaca")
    private Collection<Vendas> vendasCollection;

    public Automovel() {
    }

    public Automovel(Integer placa) {
        this.placa = placa;
    }

    public Automovel(Integer placa, String nome, String anoFabricacao, String modelo, String cor, float preco) {
        this.placa = placa;
        this.nome = nome;
        this.anoFabricacao = anoFabricacao;
        this.modelo = modelo;
        this.cor = cor;
        this.preco = preco;
    }

    public Integer getPlaca() {
        return placa;
    }

    public void setPlaca(Integer placa) {
        this.placa = placa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(String anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Estado getEstadoidEstado() {
        return estadoidEstado;
    }

    public void setEstadoidEstado(Estado estadoidEstado) {
        this.estadoidEstado = estadoidEstado;
    }

    public Marca getMarcaidMarca() {
        return marcaidMarca;
    }

    public void setMarcaidMarca(Marca marcaidMarca) {
        this.marcaidMarca = marcaidMarca;
    }

    @XmlTransient
    public Collection<Vendas> getVendasCollection() {
        return vendasCollection;
    }

    public void setVendasCollection(Collection<Vendas> vendasCollection) {
        this.vendasCollection = vendasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (placa != null ? placa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Automovel)) {
            return false;
        }
        Automovel other = (Automovel) object;
        if ((this.placa == null && other.placa != null) || (this.placa != null && !this.placa.equals(other.placa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Automovel[ placa=" + placa + " ]";
    }
    
}
