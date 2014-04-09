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

import com.cuit.exam.entity.TTestPaperHasTQtnChoice;

/**
 * A data access object (DAO) providing persistence and search support for
 * TTestPaperHasTQtnChoice entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.cuit.exam.entity.TTestPaperHasTQtnChoice
 * @author MyEclipse Persistence Tools
 */
@Transactional
@Component
public class TTestPaperHasTQtnChoiceDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TTestPaperHasTQtnChoiceDAO.class);
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

	public void save(TTestPaperHasTQtnChoice transientInstance) {
		log.debug("saving TTestPaperHasTQtnChoice instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TTestPaperHasTQtnChoice persistentInstance) {
		log.debug("deleting TTestPaperHasTQtnChoice instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TTestPaperHasTQtnChoice findById(
			com.cuit.exam.entity.TTestPaperHasTQtnChoiceId id) {
		log.debug("getting TTestPaperHasTQtnChoice instance with id: " + id);
		try {
			TTestPaperHasTQtnChoice instance = (TTestPaperHasTQtnChoice) getCurrentSession()
					.get("com.cuit.exam.entity.TTestPaperHasTQtnChoice", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TTestPaperHasTQtnChoice> findByExample(
			TTestPaperHasTQtnChoice instance) {
		log.debug("finding TTestPaperHasTQtnChoice instance by example");
		try {
			List<TTestPaperHasTQtnChoice> results = (List<TTestPaperHasTQtnChoice>) getCurrentSession()
					.createCriteria(
							"com.cuit.exam.entity.TTestPaperHasTQtnChoice")
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
		log.debug("finding TTestPaperHasTQtnChoice instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TTestPaperHasTQtnChoice as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<TTestPaperHasTQtnChoice> findByTUserScore(Object TUserScore) {
		return findByProperty(_TUSER_SCORE, TUserScore);
	}

	public List<TTestPaperHasTQtnChoice> findByTUserAnswer(Object TUserAnswer) {
		return findByProperty(_TUSER_ANSWER, TUserAnswer);
	}

	public List<TTestPaperHasTQtnChoice> findByIsChecked(Object isChecked) {
		return findByProperty(IS_CHECKED, isChecked);
	}

	public List findAll() {
		log.debug("finding all TTestPaperHasTQtnChoice instances");
		try {
			String queryString = "from TTestPaperHasTQtnChoice";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TTestPaperHasTQtnChoice merge(
			TTestPaperHasTQtnChoice detachedInstance) {
		log.debug("merging TTestPaperHasTQtnChoice instance");
		try {
			TTestPaperHasTQtnChoice result = (TTestPaperHasTQtnChoice) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TTestPaperHasTQtnChoice instance) {
		log.debug("attaching dirty TTestPaperHasTQtnChoice instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TTestPaperHasTQtnChoice instance) {
		log.debug("attaching clean TTestPaperHasTQtnChoice instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TTestPaperHasTQtnChoiceDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TTestPaperHasTQtnChoiceDAO) ctx
				.getBean("TTestPaperHasTQtnChoiceDAO");
	}
}