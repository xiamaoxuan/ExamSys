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

import com.cuit.exam.entity.TQtnFillBlank;

/**
 * A data access object (DAO) providing persistence and search support for
 * TQtnFillBlank entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.cuit.exam.entity.TQtnFillBlank
 * @author MyEclipse Persistence Tools
 */
@Transactional
@Component
public class TQtnFillBlankDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TQtnFillBlankDAO.class);
	// property constants
	public static final String DIFFICULTY = "difficulty";
	public static final String IS_ARTIFICIAL = "isArtificial";
	public static final String ANSWER = "answer";
	public static final String QUESTION_DESCRIPTION = "questionDescription";
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

	public void save(TQtnFillBlank transientInstance) {
		log.debug("saving TQtnFillBlank instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TQtnFillBlank persistentInstance) {
		log.debug("deleting TQtnFillBlank instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TQtnFillBlank findById(java.lang.Integer id) {
		log.debug("getting TQtnFillBlank instance with id: " + id);
		try {
			TQtnFillBlank instance = (TQtnFillBlank) getCurrentSession().get(
					"com.cuit.exam.entity.TQtnFillBlank", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TQtnFillBlank> findByExample(TQtnFillBlank instance) {
		log.debug("finding TQtnFillBlank instance by example");
		try {
			List<TQtnFillBlank> results = (List<TQtnFillBlank>) getCurrentSession()
					.createCriteria("com.cuit.exam.entity.TQtnFillBlank")
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
		log.debug("finding TQtnFillBlank instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TQtnFillBlank as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<TQtnFillBlank> findByDifficulty(Object difficulty) {
		return findByProperty(DIFFICULTY, difficulty);
	}

	public List<TQtnFillBlank> findByIsArtificial(Object isArtificial) {
		return findByProperty(IS_ARTIFICIAL, isArtificial);
	}

	public List<TQtnFillBlank> findByAnswer(Object answer) {
		return findByProperty(ANSWER, answer);
	}

	public List<TQtnFillBlank> findByQuestionDescription(
			Object questionDescription) {
		return findByProperty(QUESTION_DESCRIPTION, questionDescription);
	}

	public List findAll() {
		log.debug("finding all TQtnFillBlank instances");
		try {
			String queryString = "from TQtnFillBlank";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TQtnFillBlank merge(TQtnFillBlank detachedInstance) {
		log.debug("merging TQtnFillBlank instance");
		try {
			TQtnFillBlank result = (TQtnFillBlank) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TQtnFillBlank instance) {
		log.debug("attaching dirty TQtnFillBlank instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TQtnFillBlank instance) {
		log.debug("attaching clean TQtnFillBlank instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TQtnFillBlankDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TQtnFillBlankDAO) ctx.getBean("TQtnFillBlankDAO");
	}
}