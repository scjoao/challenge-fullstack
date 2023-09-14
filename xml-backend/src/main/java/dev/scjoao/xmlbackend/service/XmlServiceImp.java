package dev.scjoao.xmlbackend.service;

import dev.scjoao.xmlbackend.model.Agente;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class XmlServiceImp implements XmlService{

    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder;

    @Override
    public void processXml(InputStream xml) {
        try{
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xml);

            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("agente");

            List<Agente> agenteList = new ArrayList<Agente>();

            for (int i = 0; i < nodeList.getLength(); i++) {
                agenteList.add(getAgenteCode(nodeList.item(i)));
            }
            for (Agente agente: agenteList) {
                System.out.println(agente.toString());
            }
        }
        catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }

    private Agente getAgenteCode(Node node) {
        Agente agente = new Agente();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            agente.setCodigo(Integer.parseInt(getTagValue("codigo", element)));
        }
        return agente;
    }

    private String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }
}
