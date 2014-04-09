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

import com.cuit.exam.entity.TExam;

/**
 * A data access object (DAO) providing persistence and search support for TExam
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.cuit.exam.entity.TExam
 * @author MyEclipse Persistence Tools
 */
@Transactional
@Component
public class TExamDAO {
	private static final Logger log = LoggerFactory.getLogger(TExamDAO.class);
	// property constants
	public static final String TITLE = "title";
	public static final String FULL_SCORE = "fullScore";
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

	public void save(TExam transientInstance) {
		log.debug("saving TExam instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TExam persistentInstance) {
		log.debug("deleting TExam instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TExam findById(java.lang.Integer id) {
		log.debug("getting TExam instance with id: " + id);
		try {
			TExam instance = (TExam) getCurrentSession().get(
					"com.cuit.exam.entity.TExam", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TExam> findByExample(TExam instance) {
		log.debug("finding TExam instance by example");
		try {
			List<TExam> results = (List<TExam>) getCurrentSession()
					.createCriteria("com.cuit.exam.entity.TExam")
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
		log.debug("finding TExam instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TExam as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<TExam> findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List<TExam> findByFullScore(Object fullScore) {
		return findByProperty(FULL_SCORE, fullScore);
	}

	public List findAll() {
		log.debug("finding all TExam instances");
		try {
			String queryString = "from TExam";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TExam merge(TExam detachedInstance) {
		log.debug("merging TExam instance");
		try {
			TExam result = (TExam) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TExam instance) {
		log.debug("attaching dirty TExam instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TExam instance) {
		log.debug("attaching clean TExam instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TExamDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TExamDAO) ctx.getBean("TExamDAO");
	}
}