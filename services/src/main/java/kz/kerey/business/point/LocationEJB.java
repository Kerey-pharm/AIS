package kz.kerey.business.point;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import kz.kerey.business.types.points.Location;
import kz.kerey.business.wrappers.LocationWrapper;
import kz.kerey.constants.Constants;
import kz.kerey.exceptions.ValidatorException;

@Stateless
public class LocationEJB {

	@Resource(mappedName = "java:jboss/drugstoreEntityManagerFactory")
	public EntityManagerFactory emf;
	
	public List<LocationWrapper> getLocationList(boolean paged, Integer pageNum, Integer perPage) throws ValidatorException {
		List<LocationWrapper> result = new ArrayList<>();
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			Query query = em.createQuery("from Location l order by l.name");
			if (paged) {
				query = query.setFirstResult(perPage * (pageNum - 1))
						.setMaxResults(perPage);
			}
			List<Location> list = query.getResultList();
			for(Location type : list) {
				//result.add(LocationWrapper.fromEntity(type));
			}
			return result;
		}
		finally {
			if (em!=null)
				if (em.isOpen())
					em.close();
		}
	}
	
	public List<LocationWrapper> getLocationListFiltered(boolean paged, Integer pageNum, Integer perPage, String filter) throws ValidatorException {
		List<LocationWrapper> result = new ArrayList<>();
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			Query query = em.createQuery("from Location l where lower(l.name) like :text1 order by l.name");
			if (paged) {
				query = query.setFirstResult(perPage * (pageNum - 1))
						.setMaxResults(perPage);
			}
			query = query.setParameter("text1", filter.toLowerCase()+"%");
			List<Location> list = query.getResultList();
			for(Location type : list) {
				//result.add(LocationWrapper.fromEntity(type));
			}
			return result;
		}
		finally {
			if (em!=null)
				if (em.isOpen())
					em.close();
		}
	}
	
	public void deleteLocation(Long id) throws ValidatorException {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			Location obj = em.find(Location.class, id);
			if (obj==null)
				throw new ValidatorException(Constants.objectIsNull, "Location with id: "+id+" not exists");
			em.remove(obj);
		}
		finally {
			if (em!=null)
				if (em.isOpen())
					em.close();
		}
	}
	
	public void createLocation(LocationWrapper location) throws ValidatorException {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			List<Location> list = em.createQuery("from Location l where l.name=:text1")
					.setParameter("text1", location.getName())
					.getResultList();
			if (list.size()>0)
				throw new ValidatorException(Constants.objectExists, "Location with name: "+location.getName()+" exists");
			//Location obj = LocationWrapper.toEntity(location);
			//em.persist(obj);
		}
		finally {
			if (em!=null)
				if (em.isOpen())
					em.close();
		}
	}
	
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
	
}