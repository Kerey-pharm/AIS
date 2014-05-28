package kz.kerey.business.good;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import kz.kerey.business.types.Good;
import kz.kerey.business.types.GoodType;
import kz.kerey.constants.Constants;
import kz.kerey.exceptions.ValidatorException;

@Stateless
public class GoodEJB {

	@Resource(mappedName = "java:jboss/drugstoreEntityManagerFactory")
	public EntityManagerFactory emf;
	
	public void stub() throws ValidatorException {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
		}
		finally {
			if (em!=null)
				if (em.isOpen())
					em.close();
		}
	}
	
	public void delete(Long id) throws ValidatorException {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			Good good = em.find(Good.class, id);
			if (good==null)
				throw new ValidatorException(Constants.objectIsNull, "Object with ID:"+id+" is NULL");
			em.remove(good);
		}
		finally {
			if (em!=null)
				if (em.isOpen())
					em.close();
		}
	}
	
	public void createGood(GoodWrapper request) throws ValidatorException {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			GoodType type = em.find(GoodType.class, request.getType().getId());
			if (type==null)
				throw new ValidatorException(Constants.fieldNotFilledProperly, "GoodType not recognized");
			List<Good> list = em.createQuery("from Good g where lower(name)=:text1")
					.setParameter("text1", request.getName().toLowerCase())
					.getResultList();
			if (list.size()>0)
				throw new ValidatorException(Constants.objectExists, "Good exists");
			Good good = GoodWrapper.toEntity(request);
			good.setType(type);
			em.persist(good);
		}
		finally {
			if (em!=null)
				if (em.isOpen())
					em.close();
		}
	}
	
	public List<GoodWrapper> getGoodListFiltered(boolean paged, Integer pageNum, Integer perPage, String filter) throws ValidatorException {
		EntityManager em = null;
		List<GoodWrapper> result = new ArrayList<GoodWrapper>();
		try {
			em = emf.createEntityManager();
			Query query = em.createQuery("from Good g where lower(g.name) like :text1 order by g.name");
			if (paged) {
				query = query.setFirstResult(perPage * (pageNum - 1))
						.setMaxResults(perPage);
			}
			query = query.setParameter("text1", filter.toLowerCase()+"%");
			List<Good> list = query.getResultList();
			for(Good type : list) {
				result.add(GoodWrapper.fromEntity(type));
			}
			return result;
		}
		finally {
			if (em!=null) 
				if (em.isOpen())
					em.close();
		}
	}
	
	public List<GoodWrapper> getGoodList(boolean paged, Integer pageNum, Integer perPage) throws ValidatorException {
		EntityManager em = null;
		List<GoodWrapper> result = new ArrayList<GoodWrapper>();
		try {
			em = emf.createEntityManager();
			Query query = em.createQuery("from Good order by name");
			if (paged) {
				query = query.setFirstResult(perPage * (pageNum - 1))
						.setMaxResults(perPage);
			}
			List<Good> list = query.getResultList();
			for(Good type : list) {
				result.add(GoodWrapper.fromEntity(type));
			}
			return result;
		}
		finally {
			if (em!=null) 
				if (em.isOpen())
					em.close();
		}
	}
	
}
