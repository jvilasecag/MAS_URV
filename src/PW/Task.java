package PW;
import java.io.Serializable;

public class Task implements Serializable{
	private String action;
	private String file;
	
	public Task(String action, String file) {
		this.action = action;
		this.file = file;
	}
	
	public String getAction() {
		return this.action;
	}
	
	public String getFile() {
		return this.getFile();
	}
}
