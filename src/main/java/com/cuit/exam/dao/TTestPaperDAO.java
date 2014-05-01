package com.cuit.exam.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cuit.exam.entity.TTestPaper;

/**
 * A data access object (DAO) providing persistence and search support for
 * TTestPaper entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.cuit.exam.entity.TTestPaper
 * @author MyEclipse Persistence Tools
 */
@Transactional
@Component
public class TTestPaperDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TTestPaperDAO.class);
	// property constants
	public static final String SCORE = "score";
	public static final String TEST_STATE = "testState";
	public static final String MODIFY_STATE = "modifyState";
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(TTestPaper transientInstance) {
		log.debug("saving TTestPaper instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TTestPaper persistentInstance) {
		log.debug("deleting TTestPaper instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TTestPaper findById(java.lang.Integer id) {
		log.debug("getting TTestPaper instance with id: " + id);
		try {
			TTestPaper instance = (TTestPaper) getCurrentSession().get(
					"com.cuit.exam.entity.TTestPaper", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TTestPaper> findByExample(TTestPaper instance) {
		log.debug("finding TTestPaper instance by example");
		try {
			List<TTestPaper> results = (List<TTestPaper>) getCurrentSession()
					.createCriteria("com.cuit.exam.entity.TTestPaper")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TTestPaper instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TTestPaper as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<TTestPaper> findByScore(Object score) {
		return findByProperty(SCORE, score);
	}

	public List<TTestPaper> findByTestState(Object testState) {
		return findByProperty(TEST_STATE, testState);
	}

	public List<TTestPaper> findByModifyState(Object modifyState) {
		return findByProperty(MODIFY_STATE, modifyState);
	}

	public List findAll() {
		log.debug("finding all TTestPaper instances");
		try {
			String queryString = "from TTestPaper";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TTestPaper merge(TTestPaper detachedInstance) {
		log.debug("merging TTestPaper instance");
		try {
			TTestPaper result = (TTestPaper) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TTestPaper instance) {
		log.debug("attaching dirty TTestPaper instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TTestPaper instance) {
		log.debug("attaching clean TTestPaper instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TTestPaperDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TTestPaperDAO) ctx.getBean("TTestPaperDAO");
	}
}