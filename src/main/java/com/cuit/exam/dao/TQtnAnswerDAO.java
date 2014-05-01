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

import com.cuit.exam.entity.TQtnAnswer;

/**
 * A data access object (DAO) providing persistence and search support for
 * TQtnAnswer entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.cuit.exam.entity.TQtnAnswer
 * @author MyEclipse Persistence Tools
 */
@Transactional
@Component
public class TQtnAnswerDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TQtnAnswerDAO.class);
	// property constants
	public static final String DIFFICULTY = "difficulty";
	public static final String QUESTION_DESCRIPTION = "questionDescription";
	public static final String IS_ARTIFICIAL = "isArtificial";
	public static final String ANSWER = "answer";
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

	public void save(TQtnAnswer transientInstance) {
		log.debug("saving TQtnAnswer instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TQtnAnswer persistentInstance) {
		log.debug("deleting TQtnAnswer instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TQtnAnswer findById(java.lang.Integer id) {
		log.debug("getting TQtnAnswer instance with id: " + id);
		try {
			TQtnAnswer instance = (TQtnAnswer) getCurrentSession().get(
					"com.cuit.exam.entity.TQtnAnswer", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TQtnAnswer> findByExample(TQtnAnswer instance) {
		log.debug("finding TQtnAnswer instance by example");
		try {
			List<TQtnAnswer> results = (List<TQtnAnswer>) getCurrentSession()
					.createCriteria("com.cuit.exam.entity.TQtnAnswer")
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
		log.debug("finding TQtnAnswer instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TQtnAnswer as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<TQtnAnswer> findByDifficulty(Object difficulty) {
		return findByProperty(DIFFICULTY, difficulty);
	}

	public List<TQtnAnswer> findByQuestionDescription(Object questionDescription) {
		return findByProperty(QUESTION_DESCRIPTION, questionDescription);
	}

	public List<TQtnAnswer> findByIsArtificial(Object isArtificial) {
		return findByProperty(IS_ARTIFICIAL, isArtificial);
	}

	public List<TQtnAnswer> findByAnswer(Object answer) {
		return findByProperty(ANSWER, answer);
	}

	public List findAll() {
		log.debug("finding all TQtnAnswer instances");
		try {
			String queryString = "from TQtnAnswer";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TQtnAnswer merge(TQtnAnswer detachedInstance) {
		log.debug("merging TQtnAnswer instance");
		try {
			TQtnAnswer result = (TQtnAnswer) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TQtnAnswer instance) {
		log.debug("attaching dirty TQtnAnswer instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TQtnAnswer instance) {
		log.debug("attaching clean TQtnAnswer instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TQtnAnswerDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TQtnAnswerDAO) ctx.getBean("TQtnAnswerDAO");
	}
}