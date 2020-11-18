package PW;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;


public class ManagerAgentBehaviour extends CyclicBehaviour {
	private ManagerAgent agent;
	
	
	public ManagerAgentBehaviour (ManagerAgent agent) {
		super(agent);
		this.agent = agent;
	}
	
	public void action() {
		ACLMessage msg;
		msg = agent.blockingReceive();
		if (msg != null) {
			try {
				if (msg.getPerformative() == ACLMessage.REQUEST) {
					Task task = (Task) msg.getContentObject();
					ACLMessage response = msg.createReply();
					response.setPerformative(ACLMessage.AGREE);
					agent.send(response);
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
