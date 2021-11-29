package by.itacademy.javaenterprise.knyazev;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.itacademy.javaenterprise.knyazev.dao.CategoriesDAO;
import by.itacademy.javaenterprise.knyazev.dao.GoodsDAO;
import by.itacademy.javaenterprise.knyazev.dao.ProducersDAO;
import by.itacademy.javaenterprise.knyazev.dao.exceptions.DAOException;
import by.itacademy.javaenterprise.knyazev.entities.Category;
import by.itacademy.javaenterprise.knyazev.entities.Good;
import by.itacademy.javaenterprise.knyazev.entities.Producer;
import by.itacademy.javaenterprise.knyazev.jpa.JpaUtil;


public class App {
	private static final Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		GoodsDAO goodsDAO = new GoodsDAO(JpaUtil.getEntityManager());
		
		Good good = new Good();
		good.setName("Огурец");
		good.setSort("Среднеазиатский");
		good.setDescription("Огурец среднеазиатский сладкий для детей");
		
		Category category = findCategory(2l, JpaUtil.getEntityManager());
		Producer producer = findProducer(7l, JpaUtil.getEntityManager());
		
		good.setCategory(category);
		good.setProducer(producer);
		
		try {
			goodsDAO.save(good);
		} catch (DAOException e) {
			logger.error(e.getMessage());
		}
		
		goodsDAO.close();
		JpaUtil.closeEntityManagerFactory();
	}
	
	public static Category findCategory(Long id, EntityManager em) {
		CategoriesDAO categoriesDAO = new CategoriesDAO(em);
		Category category = new Category();
		try {
			category = categoriesDAO.find(2L);
			categoriesDAO.close();
			return category;
		} catch (DAOException e) {
			logger.error(e.getMessage());
			return null;
		}
	}
	
	public static Producer findProducer(Long id, EntityManager em) {
		ProducersDAO producersDAO = new ProducersDAO(em);
		Producer producer = new Producer();
		try {
			producer = producersDAO.find(8L);
			producersDAO.close();
			return producer;
		} catch (DAOException e) {
			logger.error(e.getMessage());
			return null;
		}
	}
}