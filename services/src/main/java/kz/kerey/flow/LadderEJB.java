package kz.kerey.flow;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import kz.kerey.exceptions.ValidatorException;

@Stateless
public class LadderEJB {

	@Resource(mappedName = "java:jboss/drugstoreEntityManagerFactory")
	public EntityManagerFactory emf;
	
	public void createLadder(LadderWrapper obj) throws ValidatorException {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			Ladder ladder = new Ladder();
			ladder.setName(obj.getName());
			em.persist(ladder);
		}
		finally {
			if (em!=null)
				if (em.isOpen())
					em.close();
		}
	}
	
	public void addStepToLadder(StepWrapper obj, LadderWrapper ladder) {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			Ladder l = em.find(Ladder.class, ladder.getId());
			
			Step step = new Step();
			step.setName(obj.getName());
			em.persist(step);
			
			l.getSteps().add(step);
			
		}
		finally {
			if (em!=null)
				if (em.isOpen())
					em.close();
		}
	}
	
}
