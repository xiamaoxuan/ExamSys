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

import com.cuit.exam.entity.TUserHasTExam;

/**
 * A data access object (DAO) providing persistence and search support for
 * TUserHasTExam entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.cuit.exam.entity.TUserHasTExam
 * @author MyEclipse Persistence Tools
 */
@Transactional
@Component
public class TUserHasTExamDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TUserHasTExamDAO.class);
	// property constants
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

	public void save(TUserHasTExam transientInstance) {
		log.debug("saving TUserHasTExam instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TUserHasTExam persistentInstance) {
		log.debug("deleting TUserHasTExam instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TUserHasTExam findById(com.cuit.exam.entity.TUserHasTExamId id) {
		log.debug("getting TUserHasTExam instance with id: " + id);
		try {
			TUserHasTExam instance = (TUserHasTExam) getCurrentSession().get(
					"com.cuit.exam.entity.TUserHasTExam", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TUserHasTExam> findByExample(TUserHasTExam instance) {
		log.debug("finding TUserHasTExam instance by example");
		try {
			List<TUserHasTExam> results = (List<TUserHasTExam>) getCurrentSession()
					.createCriteria("com.cuit.exam.entity.TUserHasTExam")
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
		log.debug("finding TUserHasTExam instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TUserHasTExam as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all TUserHasTExam instances");
		try {
			String queryString = "from TUserHasTExam";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TUserHasTExam merge(TUserHasTExam detachedInstance) {
		log.debug("merging TUserHasTExam instance");
		try {
			TUserHasTExam result = (TUserHasTExam) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TUserHasTExam instance) {
		log.debug("attaching dirty TUserHasTExam instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TUserHasTExam instance) {
		log.debug("attaching clean TUserHasTExam instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TUserHasTExamDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TUserHasTExamDAO) ctx.getBean("TUserHasTExamDAO");
	}
}