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

import com.cuit.exam.entity.TTestPaperHasTQtnAnswer;

/**
 * A data access object (DAO) providing persistence and search support for
 * TTestPaperHasTQtnAnswer entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.cuit.exam.entity.TTestPaperHasTQtnAnswer
 * @author MyEclipse Persistence Tools
 */
@Transactional
@Component
public class TTestPaperHasTQtnAnswerDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TTestPaperHasTQtnAnswerDAO.class);
	// property constants
	public static final String _TUSER_SCORE = "TUserScore";
	public static final String _TUSER_ANSWER = "TUserAnswer";
	public static final String IS_CHECKED = "isChecked";
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

	public void save(TTestPaperHasTQtnAnswer transientInstance) {
		log.debug("saving TTestPaperHasTQtnAnswer instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TTestPaperHasTQtnAnswer persistentInstance) {
		log.debug("deleting TTestPaperHasTQtnAnswer instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TTestPaperHasTQtnAnswer findById(
			com.cuit.exam.entity.TTestPaperHasTQtnAnswerId id) {
		log.debug("getting TTestPaperHasTQtnAnswer instance with id: " + id);
		try {
			TTestPaperHasTQtnAnswer instance = (TTestPaperHasTQtnAnswer) getCurrentSession()
					.get("com.cuit.exam.entity.TTestPaperHasTQtnAnswer", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TTestPaperHasTQtnAnswer> findByExample(
			TTestPaperHasTQtnAnswer instance) {
		log.debug("finding TTestPaperHasTQtnAnswer instance by example");
		try {
			List<TTestPaperHasTQtnAnswer> results = (List<TTestPaperHasTQtnAnswer>) getCurrentSession()
					.createCriteria(
							"com.cuit.exam.entity.TTestPaperHasTQtnAnswer")
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
		log.debug("finding TTestPaperHasTQtnAnswer instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TTestPaperHasTQtnAnswer as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<TTestPaperHasTQtnAnswer> findByTUserScore(Object TUserScore) {
		return findByProperty(_TUSER_SCORE, TUserScore);
	}

	public List<TTestPaperHasTQtnAnswer> findByTUserAnswer(Object TUserAnswer) {
		return findByProperty(_TUSER_ANSWER, TUserAnswer);
	}

	public List<TTestPaperHasTQtnAnswer> findByIsChecked(Object isChecked) {
		return findByProperty(IS_CHECKED, isChecked);
	}

	public List findAll() {
		log.debug("finding all TTestPaperHasTQtnAnswer instances");
		try {
			String queryString = "from TTestPaperHasTQtnAnswer";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TTestPaperHasTQtnAnswer merge(
			TTestPaperHasTQtnAnswer detachedInstance) {
		log.debug("merging TTestPaperHasTQtnAnswer instance");
		try {
			TTestPaperHasTQtnAnswer result = (TTestPaperHasTQtnAnswer) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TTestPaperHasTQtnAnswer instance) {
		log.debug("attaching dirty TTestPaperHasTQtnAnswer instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TTestPaperHasTQtnAnswer instance) {
		log.debug("attaching clean TTestPaperHasTQtnAnswer instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TTestPaperHasTQtnAnswerDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TTestPaperHasTQtnAnswerDAO) ctx
				.getBean("TTestPaperHasTQtnAnswerDAO");
	}
}