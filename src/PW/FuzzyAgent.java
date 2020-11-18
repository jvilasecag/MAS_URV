package PW;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;


public class FuzzyAgent extends Agent {

	void registerDF() {
		DFAgentDescription dfd =  new DFAgentDescription();
		ServiceDescription sd = new ServiceDescription();
		sd.setName(getName());
		sd.setType("FuzzyAgent");
		sd.setOwnership("VilasecaGiralt");
		dfd.addServices(sd);
		dfd.setName(getAID());
		
		try {
			DFService.register(this, dfd);
		} catch (jade.domain.FIPAException e) {
			doDelete();
		}
	}
	
	void deRegisterDF() {
		try {
			DFService.deregister(this);
		} catch (FIPAException e) {
			e.printStackTrace();
		}
	}

	protected void setup() {
		this.registerDF();
				
		// Add behaviours
		addBehaviour(new FuzzyAgentBehaviour(this));
	}
	
	protected void takedown() {
		this.deRegisterDF();
	}

}
