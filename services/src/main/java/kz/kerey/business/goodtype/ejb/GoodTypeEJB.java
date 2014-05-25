package kz.kerey.business.goodtype.ejb;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import kz.kerey.business.goodtype.wrapper.GoodType;
import kz.kerey.constants.Constants;
import kz.kerey.exceptions.ValidatorException;

@Stateless
public class GoodTypeEJB {

	@Resource(mappedName = "java:jboss/drugstoreEntityManagerFactory")
	public EntityManagerFactory emf;
	
	public void createGoodType(GoodType type) throws ValidatorException {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			List<GoodType> list = em.createQuery("from GoodType where name=:text1")
					.setParameter("text1", type.getName())
					.getResultList();
			if (list.size()==0) {
				kz.kerey.business.types.GoodType obj = new kz.kerey.business.types.GoodType();
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
