package com.epam.yanabogdanovich.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class XMLValidator {
    private final static Logger LOGGER = LogManager.getLogger(XMLValidator.class);

    public void validate(InputStream inputStream) {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        String schemaName = "/tariffs.xsd";
        ClassLoader classLoader = getClass().getClassLoader();

        try {
            File schemaLocation = new File(classLoader.getResource(schemaName).getFile());
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(inputStream);
            validator.validate(source);
            LOGGER.info("File is valid");
        } catch (SAXException | IOException | NullPointerException e) {
            LOGGER.error("File is not valid.", e.getLocalizedMessage());
        }
    }
}
