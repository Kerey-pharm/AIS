package kz.kerey.logic.ejbs;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import kz.kerey.business.types.Good;
import kz.kerey.constants.Constants;
import kz.kerey.logic.services.types.GoodRequest;
import kz.kerey.logic.services.types.GoodResponse;

@Stateless
public class GoodEJB {

	@Resource(mappedName = "java:jboss/drugstoreEntityManagerFactory")
	public EntityManagerFactory emf;
	
	public GoodResponse createGood(GoodRequest request) {
		if (request!=null) {
			if (request.getName()!=null && request.getName().trim().length()>0) {
				EntityManager em = null;
				try {
					em = emf.createEntityManager();
					List<Good> goods = em.createQuery("from Good where name=:text1")
							.setParameter("text1", request.getName())
							.getResultList();
					if (goods.size()==0) {
						Good newGood = new Good();
						newGood.setName(request.getName());
						em.persist(newGood);
						return new GoodResponse(true,"",Constants.isOk);
					}
					else {
						return new GoodResponse(true,"",Constants.objectExists);
					}
				}
				catch (Exception ex) {
					ex.printStackTrace();
					return new GoodResponse(true,"",Constants.exceptionIsOccured);
				}
				finally {
					if (em!=null)
						if (em.isOpen())
							em.close();
				}
			}
			else {
				return new GoodResponse(false,"",Constants.objectIsEmpty);
			}
		}
		else {
			return new GoodResponse(false,"",Constants.objectIsNull);
		}
	}
	
}
