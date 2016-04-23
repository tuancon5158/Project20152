

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import vn.hus.nlp.tokenizer.VietTokenizer;

import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class Project20152 {
	public static void main(String[] args) throws Exception {

		Properties properties = new Properties();
		String propertiesName = "C://Users//MyPC//Desktop//cmd//dist//vn.hus.nlp.tokenizer-4.1.1-bin//tokenizer.properties";
		InputStream is = new FileInputStream(new File(propertiesName));
		properties.load(is);
		VietTokenizer tokenizer = new VietTokenizer(properties);

		try {
			File folder = new File("C://Users//MyPC//Desktop//cmd//samples//Dantri_xml_1000");
			File[] listOfFiles = folder.listFiles();

			for (int i = 0; i < 1; i++) {

				// File input = listOfFiles[i];
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(listOfFiles[i]);
				NodeList nList = doc.getElementsByTagName("document");
				
				for (int temp = 0; temp < nList.getLength(); temp++) {

					Node nNode = nList.item(temp);
					Element eElement = (Element) nNode;

					String sloc = null;
					String slocal = null;
					String stitle = null;
					String spublished = null;

					String swriter = null;
					String scategory = null;
					String sbody = null;
					String sdescription = null;
					String skeywords = null;

					String sengine = null;

					DocumentBuilderFactory documentbuilderfactory = DocumentBuilderFactory.newInstance();
					DocumentBuilder documentbuilder = documentbuilderfactory.newDocumentBuilder();
					Document document = documentbuilder.newDocument();
					Element element = document.createElement("Document");
					document.appendChild(element);
					Set<String> set = new HashSet<String>();
					
					String words[] = tokenizer
							.tokenize(eElement.getElementsByTagName("loc").item(0).getTextContent().trim());
					for (String word : words) {
						set.add(word);

						sloc = String.join("", word);
					}
					TreeSet sortedSet = new TreeSet<String>(set);
					System.out.println(sortedSet);
					
					if (eElement.getElementsByTagName("loc").item(0).getTextContent() != null) {
						Element loc = document.createElement("loc");
						loc.appendChild(document.createTextNode(sloc));
						element.appendChild(loc);
					}
					
					String words0[] = tokenizer
							.tokenize(eElement.getElementsByTagName("local").item(0).getTextContent());
					for (String word : words0) {

						slocal = String.join("", word);
					}

					if (eElement.getElementsByTagName("local").item(0).getTextContent() != null) {
						Element local = document.createElement("local");
						local.appendChild(document.createTextNode(slocal));
						element.appendChild(local);
					}
					
					String words1[] = tokenizer
							.tokenize(eElement.getElementsByTagName("title").item(0).getTextContent().trim());
					for (String word : words1) {

						stitle = String.join("", word);
					}
					if (eElement.getElementsByTagName("title").item(0) != null) {
						Element title = document.createElement("title");
						title.appendChild(document.createTextNode(stitle));
						element.appendChild(title);
					}
					
					String words2[] = tokenizer
							.tokenize(eElement.getElementsByTagName("published").item(0).getTextContent().trim());
					for (String word : words2) {

						spublished = String.join("", word);
					}

					if (eElement.getElementsByTagName("published").item(0).getTextContent().trim().equals(null)) {
						Element published = document.createElement("published");
						published.appendChild(document.createTextNode(spublished));
						element.appendChild(published);
					}

					if (eElement.getElementsByTagName("dateSum").item(0).getTextContent() != null) {
						Element dateSum = document
								.createElement("dataSum");
						dateSum.appendChild(document.createTextNode(eElement.getElementsByTagName("dateSum").item(0).getTextContent()));
						element.appendChild(dateSum);
					}
					
					String words4[] = tokenizer
							.tokenize(eElement.getElementsByTagName("writer").item(0).getTextContent());
					for (String word : words4) {

						swriter = String.join("", word);
					}

					if (eElement.getElementsByTagName("writer").item(0).getTextContent().trim().equals(null)) {
						Element writer = document.createElement("writer");
						writer.appendChild(document.createTextNode(swriter));
						element.appendChild(writer);
					}
					
					String words5[] = tokenizer
							.tokenize(eElement.getElementsByTagName("body").item(0).getTextContent());
					for (String word : words5) {

						sbody = String.join("", word);
					}

					if (eElement.getElementsByTagName("body").item(0).getTextContent().trim().equals(null)) {
						Element body = document.createElement("body");
						body.appendChild(document.createTextNode(sbody));
						element.appendChild(body);
					}
					
					String words6[] = tokenizer
							.tokenize(eElement.getElementsByTagName("category").item(0).getTextContent().trim());
					for (String word : words6) {

						scategory = String.join("", word);
					}

					if (eElement.getElementsByTagName("category").item(0).getTextContent().equals(null)) {
						Element category = document.createElement("category");
						category.appendChild(document.createTextNode(scategory));
						element.appendChild(category);
					}
					
					String words7[] = tokenizer
							.tokenize(eElement.getElementsByTagName("description").item(0).getTextContent());
					for (String word : words7) {

						sdescription = String.join("", word);
					}
					if (eElement.getElementsByTagName("description").item(0).getTextContent().trim().equals(null)) {
						Element description = document.createElement("description");
						description.appendChild(document.createTextNode(sdescription));
						element.appendChild(description);
					}
					
					String words8[] = tokenizer
							.tokenize(eElement.getElementsByTagName("keywords").item(0).getTextContent());
					for (String word : words8) {

						skeywords = String.join("", word);
					}
					if (eElement.getElementsByTagName("keywords").item(0).getTextContent().trim().equals(null)) {
						Element keywords = document.createElement("keywords");
						keywords.appendChild(document.createTextNode(skeywords));
						element.appendChild(keywords);
					}
					
					String words9[] = tokenizer
							.tokenize(eElement.getElementsByTagName("engine").item(0).getTextContent().trim());
					for (String word : words9) {

						sengine = String.join("", word);
					}
					if (eElement.getElementsByTagName("engine").item(0).getTextContent().trim().equals(null)) {
						Element keywords = document.createElement("engine");
						keywords.appendChild(document.createTextNode(sengine));
						element.appendChild(keywords);
					}

					TransformerFactory tranformerfactory = TransformerFactory.newInstance();
					Transformer transformer = tranformerfactory.newTransformer();
					DOMSource source = new DOMSource(document);

					StreamResult streamResult = new StreamResult(new File("E:\\XML", listOfFiles[i].getName()));

					transformer.transform(source, streamResult);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

