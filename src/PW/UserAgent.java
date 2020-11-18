package PW;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;


public class UserAgent extends Agent {
	private Task task = null;
	
	void registerDF() {
		DFAgentDescription dfd =  new DFAgentDescription();
		ServiceDescription sd = new ServiceDescription();
		sd.setName(getName());
		sd.setType("UserAgent");
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

	public String readInput() {
		String input = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter action to perform: <action>_<file>");
		try {
			input = reader.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return input;
	}

		public void startAction(Task task) {
			this.task = task;
		}

	protected void setup() {
		this.registerDF();

		// Add behaviours
		addBehaviour(new UserAgentBehaviour(this));
	}
	
	protected void takedown() {
		this.deRegisterDF();
	}
}
