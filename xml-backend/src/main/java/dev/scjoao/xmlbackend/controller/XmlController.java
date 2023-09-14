package dev.scjoao.xmlbackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import dev.scjoao.xmlbackend.service.XmlService;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;

@RestController
public class XmlController {

    private final XmlService xmlService;

    public XmlController(XmlService xmlService) {
        this.xmlService = xmlService;
    }

    @PostMapping("/process-xml")
    public ResponseEntity uploadAndProcessXml(@RequestParam("xml") MultipartFile xml){
        try {
            this.xmlService.processXml(xml.getInputStream());
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }

}
