package org.example;

import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;

import java.io.IOException;

public class XMLValidator {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("sports_data.xml");
            File xsdFile = new File("sports_schema.xsd");

            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(xsdFile);
            Validator validator = schema.newValidator();

            validator.validate(new StreamSource(xmlFile));
            System.out.println("Arquivo XML é válido.");

        } catch (SAXException | IOException e) {
            System.out.println("Erro na validação do XML: " + e.getMessage());
        }
    }
}

