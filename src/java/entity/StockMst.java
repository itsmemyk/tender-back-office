/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mayank
 */
@Entity
@Table(name = "stock_mst")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StockMst.findAll", query = "SELECT s FROM StockMst s"),
    @NamedQuery(name = "StockMst.findById", query = "SELECT s FROM StockMst s WHERE s.id = :id"),
    @NamedQuery(name = "StockMst.findByFinYear", query = "SELECT s FROM StockMst s WHERE s.finYear = :finYear"),
    @NamedQuery(name = "StockMst.findByAsOnDate", query = "SELECT s FROM StockMst s WHERE s.asOnDate = :asOnDate"),
    @NamedQuery(name = "StockMst.findByOpeningQty", query = "SELECT s FROM StockMst s WHERE s.openingQty = :openingQty"),
    @NamedQuery(name = "StockMst.findByClosingQty", query = "SELECT s FROM StockMst s WHERE s.closingQty = :closingQty"),
    @NamedQuery(name = "StockMst.findByMinQty", query = "SELECT s FROM StockMst s WHERE s.minQty = :minQty"),
    @NamedQuery(name = "StockMst.findByMaxQty", query = "SELECT s FROM StockMst s WHERE s.maxQty = :maxQty"),
    @NamedQuery(name = "StockMst.findByRate", query = "SELECT s FROM StockMst s WHERE s.rate = :rate")})
public class StockMst implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "fin_year")
    private String finYear;
    @Basic(optional = false)
    @NotNull
    @Column(name = "as_on_date")
    @Temporal(TemporalType.DATE)
    private Date asOnDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "opening_qty")
    private int openingQty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "closing_qty")
    private int closingQty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "min_qty")
    private int minQty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "max_qty")
    private int maxQty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rate")
    private double rate;
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ItemMst itemId;

    public StockMst() {
    }

    public StockMst(Integer id) {
        this.id = id;
    }

    public StockMst(Integer id, String finYear, Date asOnDate, int openingQty, int closingQty, int minQty, int maxQty, double rate) {
        this.id = id;
        this.finYear = finYear;
        this.asOnDate = asOnDate;
        this.openingQty = openingQty;
        this.closingQty = closingQty;
        this.minQty = minQty;
        this.maxQty = maxQty;
        this.rate = rate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFinYear() {
        return finYear;
    }

    public void setFinYear(String finYear) {
        this.finYear = finYear;
    }

    public Date getAsOnDate() {
        return asOnDate;
    }

    public void setAsOnDate(Date asOnDate) {
        this.asOnDate = asOnDate;
    }

    public int getOpeningQty() {
        return openingQty;
    }

    public void setOpeningQty(int openingQty) {
        this.openingQty = openingQty;
    }

    public int getClosingQty() {
        return closingQty;
    }

    public void setClosingQty(int closingQty) {
        this.closingQty = closingQty;
    }

    public int getMinQty() {
        return minQty;
    }

    public void setMinQty(int minQty) {
        this.minQty = minQty;
    }

    public int getMaxQty() {
        return maxQty;
    }

    public void setMaxQty(int maxQty) {
        this.maxQty = maxQty;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public ItemMst getItemId() {
        return itemId;
    }

    public void setItemId(ItemMst itemId) {
        this.itemId = itemId;
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
        if (!(object instanceof StockMst)) {
            return false;
        }
        StockMst other = (StockMst) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.StockMst[ id=" + id + " ]";
    }
    
}
