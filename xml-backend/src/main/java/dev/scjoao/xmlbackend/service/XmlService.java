package dev.scjoao.xmlbackend.service;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

public interface XmlService {
    void processXml(InputStream file) throws ParserConfigurationException, IOException, SAXException;
}
