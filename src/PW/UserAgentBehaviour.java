package PW;
import jade.core.behaviours.CyclicBehaviour;

public class UserAgentBehaviour extends CyclicBehaviour {
	private UserAgent agent;
	private String FILE_PATH = "src/files/";
	
	public UserAgentBehaviour(UserAgent agent) {
		super(agent);
		this.agent = agent;
	}
	
	public void action() {
		String input = this.agent.readInput();
		String[] arguments = input.split("_");
		
		String actionToPerform = arguments[0];
		String configurationFile = arguments[1];
		
		Task task = new Task(actionToPerform, FILE_PATH + "/" + configurationFile);
		agent.startAction(task);
	}
}