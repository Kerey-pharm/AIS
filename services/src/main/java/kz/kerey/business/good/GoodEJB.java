package kz.kerey.business.good;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;

@Stateless
public class GoodEJB {

	@Resource(mappedName = "java:jboss/drugstoreEntityManagerFactory")
	public EntityManagerFactory emf;
	
	public void createGood(kz.kerey.business.good.GoodWrapper request) {
		
	}
	
}
