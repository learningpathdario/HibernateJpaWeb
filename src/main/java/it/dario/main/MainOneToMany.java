package it.dario.main;

import java.util.Date;

import org.hibernate.Session;

import it.dario.bean.Stock;
import it.dario.bean.StockDailyRecord;
import it.dario.hibernate.HibernateUtil;




public class MainOneToMany {

	public MainOneToMany() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
        System.out.println("Hibernate one to many (Annotation)");
	Session session = HibernateUtil.getSessionFactory().openSession();

	session.beginTransaction();

	Stock stock = new Stock();
        stock.setStockCode("7052");
        stock.setStockName("PADINI");
        stock.setStockId(25);
        
        
        StockDailyRecord stockDailyRecords = new StockDailyRecord();
        stockDailyRecords.setPriceOpen(new Float("6"));
        stockDailyRecords.setPriceClose(new Float("6"));
        stockDailyRecords.setPriceChange(new Float("10.0"));
        stockDailyRecords.setVolume(3000000L);
        stockDailyRecords.setDate(new Date());
        
        stockDailyRecords.setStock(stock);        
        stock.getStockDailyRecords().add(stockDailyRecords);

        
        session.merge(stock);
        session.save(stockDailyRecords);

	session.getTransaction().commit();
	System.out.println("Done");

	}

}
