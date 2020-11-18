package PW;

import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;


public class ManagerAgent extends Agent {
	private int numFAgents;
	
	void registerDF() {
		DFAgentDescription dfd =  new DFAgentDescription();
		ServiceDescription sd = new ServiceDescription();
		sd.setName(getName());
		sd.setType("ManagerAgent");
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

	public void doAction(Task task)	{
		int requiredFAgents = 3;
		String action = task.getAction();
		if (action.contentEquals("I")) {
			try {
			int currentNFAgents = numFAgents;
			if (requiredFAgents > currentNFAgents) {
					ContainerController managerController = getContainerController();
					for(int i = numFAgents; i < requiredFAgents; i++) {
						AgentController newAgent = managerController.createNewAgent("FuzzyAgent" + i,
							this.getClass().getPackage().getName() + ".FuzzyAgent", null);
							newAgent.start();
							numFAgents++;	
					}
			}
			} catch (Exception e) {
				e.printStackTrace();
				}
			
			} else if (action.contentEquals("D")) {
			//To DO
			}
	}
	
	public void getXML(Task task) {
		
	}
	
	protected void setup() {
		this.registerDF();
				
		// Add behaviours
		addBehaviour(new ManagerAgentBehaviour(this));
	}
	
	protected void takedown() {
		this.deRegisterDF();
	}

}
