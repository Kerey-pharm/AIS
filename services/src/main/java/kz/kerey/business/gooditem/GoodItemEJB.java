package kz.kerey.business.gooditem;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;

import kz.kerey.exceptions.ValidatorException;

@Stateless
public class GoodItemEJB {

	@Resource(mappedName = "java:jboss/drugstoreEntityManagerFactory")
	public EntityManagerFactory emf;
	
	public void createGoodItems(List<GoodItemWrapper> items) throws ValidatorException {
		
	}
	
}
