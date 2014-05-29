package kz.kerey.business.task;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import kz.kerey.business.wrappers.TaskWrapper;
import kz.kerey.exceptions.ValidatorException;

@Stateless
public class TaskEJB {

	@Resource(mappedName = "java:jboss/drugstoreEntityManagerFactory")
	public EntityManagerFactory emf;

	public void createTask(TaskWrapper obj) throws ValidatorException {
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