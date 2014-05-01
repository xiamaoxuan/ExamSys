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

import com.cuit.exam.entity.TQtnJudge;

/**
 * A data access object (DAO) providing persistence and search support for
 * TQtnJudge entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.cuit.exam.entity.TQtnJudge
 * @author MyEclipse Persistence Tools
 */
@Transactional
@Component
public class TQtnJudgeDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TQtnJudgeDAO.class);
	// property constants
	public static final String DIFFICULTY = "difficulty";
	public static final String QUESTION_DESCRIPTION = "questionDescription";
	public static final String IS_ARTIFICIAL = "isArtificial";
	public static final String IS_CORRECT = "isCorrect";
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

	public void save(TQtnJudge transientInstance) {
		log.debug("saving TQtnJudge instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TQtnJudge persistentInstance) {
		log.debug("deleting TQtnJudge instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TQtnJudge findById(java.lang.Integer id) {
		log.debug("getting TQtnJudge instance with id: " + id);
		try {
			TQtnJudge instance = (TQtnJudge) getCurrentSession().get(
					"com.cuit.exam.entity.TQtnJudge", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TQtnJudge> findByExample(TQtnJudge instance) {
		log.debug("finding TQtnJudge instance by example");
		try {
			List<TQtnJudge> results = (List<TQtnJudge>) getCurrentSession()
					.createCriteria("com.cuit.exam.entity.TQtnJudge")
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
		log.debug("finding TQtnJudge instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TQtnJudge as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<TQtnJudge> findByDifficulty(Object difficulty) {
		return findByProperty(DIFFICULTY, difficulty);
	}

	public List<TQtnJudge> findByQuestionDescription(Object questionDescription) {
		return findByProperty(QUESTION_DESCRIPTION, questionDescription);
	}

	public List<TQtnJudge> findByIsArtificial(Object isArtificial) {
		return findByProperty(IS_ARTIFICIAL, isArtificial);
	}

	public List<TQtnJudge> findByIsCorrect(Object isCorrect) {
		return findByProperty(IS_CORRECT, isCorrect);
	}

	public List findAll() {
		log.debug("finding all TQtnJudge instances");
		try {
			String queryString = "from TQtnJudge";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TQtnJudge merge(TQtnJudge detachedInstance) {
		log.debug("merging TQtnJudge instance");
		try {
			TQtnJudge result = (TQtnJudge) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TQtnJudge instance) {
		log.debug("attaching dirty TQtnJudge instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TQtnJudge instance) {
		log.debug("attaching clean TQtnJudge instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TQtnJudgeDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TQtnJudgeDAO) ctx.getBean("TQtnJudgeDAO");
	}
}