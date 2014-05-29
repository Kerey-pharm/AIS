package kz.kerey.business.point;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import kz.kerey.business.types.points.Distributor;
import kz.kerey.business.types.points.Location;
import kz.kerey.business.types.points.Point;
import kz.kerey.business.types.points.Warehouse;
import kz.kerey.business.wrappers.DistributorWrapper;
import kz.kerey.business.wrappers.WarehouseWrapper;
import kz.kerey.constants.Constants;
import kz.kerey.exceptions.ValidatorException;

@Stateless
public class PointEJB {

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
	
	public List<DistributorWrapper> getDistributorList(boolean paged, Integer pageNum, Integer perPage) throws ValidatorException {
		List<DistributorWrapper> result = new ArrayList<>();
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			Query query = em.createQuery("from Distributor p order by p.name");
			if (paged) {
				query = query.setFirstResult(perPage * (pageNum - 1))
						.setMaxResults(perPage);
			}
			List<Distributor> list = query.getResultList();
			for (Distributor obj : list) {
				result.add(DistributorWrapper.fromEntity(obj));
			}
			return result;
		}
		finally {
			if (em!=null)
				if (em.isOpen())
					em.close();
		}
	}
	
	public List<WarehouseWrapper> getWarehouseList(boolean paged, Integer pageNum, Integer perPage) throws ValidatorException {
		List<WarehouseWrapper> result = new ArrayList<>();
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			Query query = em.createQuery("from Warehouse p order by p.name");
			if (paged) {
				query = query.setFirstResult(perPage * (pageNum - 1))
						.setMaxResults(perPage);
			}
			List<Warehouse> list = query.getResultList();
			for (Warehouse obj : list) {
				result.add(WarehouseWrapper.fromEntity(obj));
			}
			return result;
		}
		finally {
			if (em!=null)
				if (em.isOpen())
					em.close();
		}
	}
	
	public List<DistributorWrapper> getDistributorListFiltered(boolean paged, Integer pageNum, Integer perPage, String filter) throws ValidatorException {
		List<DistributorWrapper> result = new ArrayList<>();
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			Query query = em.createQuery("from Distributor p where lower(p.name) like :text1 order by p.name");
			if (paged) {
				query = query.setFirstResult(perPage * (pageNum - 1))
						.setMaxResults(perPage);
			}
			query = query.setParameter("text1", filter.toLowerCase()+"%");
			List<Distributor> list = query.getResultList();
			for (Distributor obj : list) {
				result.add(DistributorWrapper.fromEntity(obj));
			}
			return result;
		}
		finally {
			if (em!=null)
				if (em.isOpen())
					em.close();
		}
	}
	
	public List<WarehouseWrapper> getWarehouseListFiltered(boolean paged, Integer pageNum, Integer perPage, String filter) throws ValidatorException {
		List<WarehouseWrapper> result = new ArrayList<>();
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			Query query = em.createQuery("from Warehouse p where lower(p.name) like :text1 order by p.name");
			if (paged) {
				query = query.setFirstResult(perPage * (pageNum - 1))
						.setMaxResults(perPage);
			}
			query = query.setParameter("text1", filter.toLowerCase()+"%");
			List<Warehouse> list = query.getResultList();
			for (Warehouse obj : list) {
				result.add(WarehouseWrapper.fromEntity(obj));
			}
			return result;
		}
		finally {
			if (em!=null)
				if (em.isOpen())
					em.close();
		}
	}
	
	public void deletePoint(Long id) throws ValidatorException {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			Point point = em.find(Point.class, id);
			if (point==null)
				throw new ValidatorException(Constants.objectIsNull, "Point with ID:"+id+ " is NULL");
			em.remove(point);
		}
		finally {
			if (em!=null)
				if (em.isOpen())
					em.close();
		}
	}
	
	public void createWarehouse(WarehouseWrapper obj) throws ValidatorException {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			List<Point> list = em.createQuery("from Point p where lower(p.name)=:text1")
					.setParameter("text1", obj.getName().toLowerCase())
					.getResultList();
			if (list.size()>0)
				throw new ValidatorException(Constants.objectExists, "Point with NAME:"+obj.getName()+ " is EXISTS");
			Location location = em.find(Location.class, obj.getLocation().getId());
			if (location==null)
				throw new ValidatorException(Constants.objectIsNull, "Location with ID:"+obj.getLocation().getId()+ " is NULL");
			Warehouse warehouse = WarehouseWrapper.toEntity(obj);
			warehouse.setLocation(location);
			em.persist(warehouse);
		}
		finally {
			if (em!=null)
				if (em.isOpen())
					em.close();
		}
	}
	
	public void createDistributor(DistributorWrapper obj) throws ValidatorException {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			List<Point> list = em.createQuery("from Point p where lower(p.name)=:text1")
					.setParameter("text1", obj.getName().toLowerCase())
					.getResultList();
			if (list.size()>0)
				throw new ValidatorException(Constants.objectExists, "Point with NAME:"+obj.getName()+ " is EXISTS");
			Location location = em.find(Location.class, obj.getLocation().getId());
			if (location==null)
				throw new ValidatorException(Constants.objectIsNull, "Location with ID:"+obj.getLocation().getId()+ " is NULL");
			Distributor distributor = DistributorWrapper.toEntity(obj);
			distributor.setLocation(location);
			em.persist(distributor);
		}
		finally {
			if (em!=null)
				if (em.isOpen())
					em.close();
		}
	}
	
}