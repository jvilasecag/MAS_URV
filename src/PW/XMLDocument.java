package PW;

import java.io.File;

//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//import org.w3c.dom.Node;
//import org.w3c.dom.NodeList;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.DocumentBuilder;

public class XMLDocument {
	private String title;
	private String application;
	private String fuzzyagents;
	private String[] fuzzySettings;
	private String aggregation;
	
	public XMLDocument () {
		title = null;
		application = null;
		fuzzyagents = null;
		fuzzySettings = null;
		aggregation = null;
	}
	
	public void parseXML (Task task) {
		File file = new File (task.getFile());
//		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//		DocumentBuilder db = dbf.newDocumentBuilder();
//		Document doc = db.parse(file);
//		doc.getDocumentElement().normalize();
//		NodeList nodeList = doc.getElementsByTagName("SimulationSettings");
//		Node nnode = nodeList.item(0);
//		Element rootElement = (Element) nNode;
		
//		this.setTitle(rootElement.getElementsByTagName("title").item(0).getTextContent);
//		this.setApplication(rootElement.getElementsByTagName("application").item(0).getTextContent);
//		this.setFuzzyAgents(rootElement.getElementsByTagName("fuzzyagents").item(0).getTextContent);
//		this.setFuzzySettings(rootElement.getElementsByTagName("fuzzySettings").item(0).getTextContent);
//		this.setAggregation(rootElement.getElementsByTagName("aggregation").item(0).getTextContent);
	}
}
