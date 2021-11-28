package by.itacademy.javaenterprise.knyazev;

import javax.persistence.EntityManager;

import by.itacademy.javaenterprise.knyazev.dao.GoodsDAO;
import by.itacademy.javaenterprise.knyazev.jpa.JpaUtil;

public class App {

	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		GoodsDAO goodsDAO = new GoodsDAO(em);
		
		goodsDAO.close();
		JpaUtil.closeEntityManagerFactory();
	}
}