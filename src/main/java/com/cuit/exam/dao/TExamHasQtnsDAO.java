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

import com.cuit.exam.entity.TExamHasQtns;

/**
 * A data access object (DAO) providing persistence and search support for
 * TExamHasQtns entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.cuit.exam.entity.TExamHasQtns
 * @author MyEclipse Persistence Tools
 */
@Transactional
@Component
public class TExamHasQtnsDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TExamHasQtnsDAO.class);
	// property constants
	public static final String QTN_TYPE = "qtnType";
	public static final String FULL_SOCRE = "fullSocre";
	public static final String DIFFICULTY = "difficulty";
	public static final String QTN_COUNT = "qtnCount";
	
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

	public void save(TExamHasQtns transientInstance) {
		log.debug("saving TExamHasQtns instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TExamHasQtns persistentInstance) {
		log.debug("deleting TExamHasQtns instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TExamHasQtns findById(java.lang.Integer id) {
		log.debug("getting TExamHasQtns instance with id: " + id);
		try {
			TExamHasQtns instance = (TExamHasQtns) getCurrentSession().get(
					"com.cuit.exam.entity.TExamHasQtns", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TExamHasQtns> findByExample(TExamHasQtns instance) {
		log.debug("finding TExamHasQtns instance by example");
		try {
			List<TExamHasQtns> results = (List<TExamHasQtns>) getCurrentSession()
					.createCriteria("com.cuit.exam.entity.TExamHasQtns")
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
		log.debug("finding TExamHasQtns instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TExamHasQtns as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<TExamHasQtns> findByQtnType(Object qtnType) {
		return findByProperty(QTN_TYPE, qtnType);
	}

	public List<TExamHasQtns> findByFullSocre(Object fullSocre) {
		return findByProperty(FULL_SOCRE, fullSocre);
	}

	public List<TExamHasQtns> findByDifficulty(Object difficulty) {
		return findByProperty(DIFFICULTY, difficulty);
	}

	public List<TExamHasQtns> findByQtnCount(Object qtnCount) {
		return findByProperty(QTN_COUNT, qtnCount);
	}

	public List findAll() {
		log.debug("finding all TExamHasQtns instances");
		try {
			String queryString = "from TExamHasQtns";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TExamHasQtns merge(TExamHasQtns detachedInstance) {
		log.debug("merging TExamHasQtns instance");
		try {
			TExamHasQtns result = (TExamHasQtns) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TExamHasQtns instance) {
		log.debug("attaching dirty TExamHasQtns instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TExamHasQtns instance) {
		log.debug("attaching clean TExamHasQtns instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TExamHasQtnsDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TExamHasQtnsDAO) ctx.getBean("TExamHasQtnsDAO");
	}
}