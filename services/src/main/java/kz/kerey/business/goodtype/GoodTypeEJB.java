package kz.kerey.business.goodtype;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import kz.kerey.business.types.GoodType;
import kz.kerey.constants.Constants;
import kz.kerey.exceptions.ValidatorException;

@Stateless
public class GoodTypeEJB {

	@Resource(mappedName = "java:jboss/drugstoreEntityManagerFactory")
	public EntityManagerFactory emf;
	
	public List<GoodTypeWrapper> getGoodTypeList(boolean paged, Integer pageNum, Integer perPage) throws ValidatorException {
		EntityManager em = null;
		List<GoodTypeWrapper> result = new ArrayList<GoodTypeWrapper>();
		try {
			em = emf.createEntityManager();
			Query query = em.createQuery("from GoodType order by name");
			if (paged) {
				query = query.setFirstResult(perPage * (pageNum - 1))
						.setMaxResults(perPage);
			}
			List<GoodType> list = query.getResultList();
			for(GoodType type : list) {
				result.add(GoodTypeWrapper.fromEntity(type));
			}
			return result;
		}
		finally {
			if (em!=null) 
				if (em.isOpen())
					em.close();
		}
	}
	
	public void deleteGoodType(Long id) throws ValidatorException {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			GoodType obj = em.find(GoodType.class, id);
			em.remove(obj);
		}
		finally {
			if (em!=null) 
				if (em.isOpen())
					em.close();
		}
	}
	
	public void createGoodType(GoodTypeWrapper type) throws ValidatorException {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			List<GoodType> list = em.createQuery("from GoodType where name=:text1")
					.setParameter("text1", type.getName())
					.getResultList();
			if (list.size()==0) {
				GoodType obj = new GoodType();
				obj.setName(type.getName());
				em.persist(obj);
			}
			else {
				throw new ValidatorException(Constants.objectExists, "objectExists");
			}
		}
		finally {
			if (em!=null)
				if (em.isOpen())
					em.close();
		}
	}
	
}
