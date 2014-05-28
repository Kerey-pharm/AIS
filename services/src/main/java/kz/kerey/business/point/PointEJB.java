package kz.kerey.business.point;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import kz.kerey.business.types.points.Distributor;
import kz.kerey.business.types.points.Location;
import kz.kerey.business.types.points.Point;
import kz.kerey.business.types.points.Warehouse;
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