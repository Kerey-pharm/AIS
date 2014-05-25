package kz.kerey.business.good.ejb;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;

import kz.kerey.business.types.Good;
import kz.kerey.constants.Constants;

@Stateless
public class GoodEJB {

	@Resource(mappedName = "java:jboss/drugstoreEntityManagerFactory")
	public EntityManagerFactory emf;
	
	public void createGood(kz.kerey.business.good.wrapper.Good request) {
		
	}
	
}
