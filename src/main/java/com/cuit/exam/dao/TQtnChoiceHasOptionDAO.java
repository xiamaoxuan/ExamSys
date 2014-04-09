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

import com.cuit.exam.entity.TQtnChoiceHasOption;

/**
 * A data access object (DAO) providing persistence and search support for
 * TQtnChoiceHasOption entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.cuit.exam.entity.TQtnChoiceHasOption
 * @author MyEclipse Persistence Tools
 */
@Transactional
@Component
public class TQtnChoiceHasOptionDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TQtnChoiceHasOptionDAO.class);
	// property constants
	public static final String OPTION_DESCRIPTION = "optionDescription";
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

	public void save(TQtnChoiceHasOption transientInstance) {
		log.debug("saving TQtnChoiceHasOption instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TQtnChoiceHasOption persistentInstance) {
		log.debug("deleting TQtnChoiceHasOption instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TQtnChoiceHasOption findById(java.lang.Integer id) {
		log.debug("getting TQtnChoiceHasOption instance with id: " + id);
		try {
			TQtnChoiceHasOption instance = (TQtnChoiceHasOption) getCurrentSession()
					.get("com.cuit.exam.entity.TQtnChoiceHasOption", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TQtnChoiceHasOption> findByExample(TQtnChoiceHasOption instance) {
		log.debug("finding TQtnChoiceHasOption instance by example");
		try {
			List<TQtnChoiceHasOption> results = (List<TQtnChoiceHasOption>) getCurrentSession()
					.createCriteria("com.cuit.exam.entity.TQtnChoiceHasOption")
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
		log.debug("finding TQtnChoiceHasOption instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TQtnChoiceHasOption as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<TQtnChoiceHasOption> findByOptionDescription(
			Object optionDescription) {
		return findByProperty(OPTION_DESCRIPTION, optionDescription);
	}

	public List<TQtnChoiceHasOption> findByIsCorrect(Object isCorrect) {
		return findByProperty(IS_CORRECT, isCorrect);
	}

	public List findAll() {
		log.debug("finding all TQtnChoiceHasOption instances");
		try {
			String queryString = "from TQtnChoiceHasOption";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TQtnChoiceHasOption merge(TQtnChoiceHasOption detachedInstance) {
		log.debug("merging TQtnChoiceHasOption instance");
		try {
			TQtnChoiceHasOption result = (TQtnChoiceHasOption) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TQtnChoiceHasOption instance) {
		log.debug("attaching dirty TQtnChoiceHasOption instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TQtnChoiceHasOption instance) {
		log.debug("attaching clean TQtnChoiceHasOption instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TQtnChoiceHasOptionDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TQtnChoiceHasOptionDAO) ctx.getBean("TQtnChoiceHasOptionDAO");
	}
}