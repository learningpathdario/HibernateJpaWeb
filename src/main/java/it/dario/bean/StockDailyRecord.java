package it.dario.bean;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "stock_daily_record",uniqueConstraints = @UniqueConstraint(columnNames = "DATA"))
@SequenceGenerator(sequenceName = "STOCK_DAILY_RECORD_SEQ",initialValue=1, allocationSize=1, name = "STOCK_DAILY_RECORD_SEQ")
public class StockDailyRecord implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer recordId;
	private Stock stock;
	private Float priceOpen;
	private Float priceClose;
	private Float priceChange;
	private Long volume;
	private Date data;

	public StockDailyRecord() {
	}

	public StockDailyRecord(Stock stock, Date data) {
		this.stock = stock;
		this.data = data;
	}

	public StockDailyRecord(Stock stock, Float priceOpen, Float priceClose,
			Float priceChange, Long volume, Date data) {
		this.stock = stock;
		this.priceOpen = priceOpen;
		this.priceClose = priceClose;
		this.priceChange = priceChange;
		this.volume = volume;
		this.data = data;
	}

	@Id
//	@GeneratedValue(strategy = IDENTITY)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STOCK_DAILY_RECORD_SEQ")
	@Column(name = "DAILY_RECORD_ID", unique = true, nullable = false)
	public Integer getRecordId() {
		return this.recordId;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STOCK_ID", nullable = false)
	public Stock getStock() {
		return this.stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	@Column(name = "PRICE_OPEN", precision = 6)
	public Float getPriceOpen() {
		return this.priceOpen;
	}

	public void setPriceOpen(Float priceOpen) {
		this.priceOpen = priceOpen;
	}

	@Column(name = "PRICE_CLOSE", precision = 6)
	public Float getPriceClose() {
		return this.priceClose;
	}

	public void setPriceClose(Float priceClose) {
		this.priceClose = priceClose;
	}

	@Column(name = "PRICE_CHANGE", precision = 6)
	public Float getPriceChange() {
		return this.priceChange;
	}

	public void setPriceChange(Float priceChange) {
		this.priceChange = priceChange;
	}

	@Column(name = "VOLUME")
	public Long getVolume() {
		return this.volume;
	}

	public void setVolume(Long volume) {
		this.volume = volume;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA", unique = true, nullable = false, length = 10)
	public Date getDate() {
		return this.data;
	}

	public void setDate(Date date) {
		this.data = date;
	}

}
