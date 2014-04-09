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

import com.cuit.exam.entity.TQtnInterpretation;

/**
 * A data access object (DAO) providing persistence and search support for
 * TQtnInterpretation entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.cuit.exam.entity.TQtnInterpretation
 * @author MyEclipse Persistence Tools
 */
@Transactional
@Component
public class TQtnInterpretationDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TQtnInterpretationDAO.class);
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

	public void save(TQtnInterpretation transientInstance) {
		log.debug("saving TQtnInterpretation instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TQtnInterpretation persistentInstance) {
		log.debug("deleting TQtnInterpretation instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TQtnInterpretation findById(java.lang.Integer id) {
		log.debug("getting TQtnInterpretation instance with id: " + id);
		try {
			TQtnInterpretation instance = (TQtnInterpretation) getCurrentSession()
					.get("com.cuit.exam.entity.TQtnInterpretation", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TQtnInterpretation> findByExample(TQtnInterpretation instance) {
		log.debug("finding TQtnInterpretation instance by example");
		try {
			List<TQtnInterpretation> results = (List<TQtnInterpretation>) getCurrentSession()
					.createCriteria("com.cuit.exam.entity.TQtnInterpretation")
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
		log.debug("finding TQtnInterpretation instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TQtnInterpretation as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<TQtnInterpretation> findByDifficulty(Object difficulty) {
		return findByProperty(DIFFICULTY, difficulty);
	}

	public List<TQtnInterpretation> findByQuestionDescription(
			Object questionDescription) {
		return findByProperty(QUESTION_DESCRIPTION, questionDescription);
	}

	public List<TQtnInterpretation> findByIsArtificial(Object isArtificial) {
		return findByProperty(IS_ARTIFICIAL, isArtificial);
	}

	public List<TQtnInterpretation> findByAnswer(Object answer) {
		return findByProperty(ANSWER, answer);
	}

	public List findAll() {
		log.debug("finding all TQtnInterpretation instances");
		try {
			String queryString = "from TQtnInterpretation";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TQtnInterpretation merge(TQtnInterpretation detachedInstance) {
		log.debug("merging TQtnInterpretation instance");
		try {
			TQtnInterpretation result = (TQtnInterpretation) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TQtnInterpretation instance) {
		log.debug("attaching dirty TQtnInterpretation instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TQtnInterpretation instance) {
		log.debug("attaching clean TQtnInterpretation instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TQtnInterpretationDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TQtnInterpretationDAO) ctx.getBean("TQtnInterpretationDAO");
	}
}