package com.epam.yanabogdanovich.servlet;

import com.epam.yanabogdanovich.entity.Tariff;
import com.epam.yanabogdanovich.parser.TariffsBuilder;
import com.epam.yanabogdanovich.parser.TariffsBuilderFactory;
import com.epam.yanabogdanovich.validator.XMLValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ParsingCommand {
    private static final String SAX = "SAX";
    private static final String DOM = "DOM";
    private static final String STAX = "STAX";

    private static final String PARAM_NAME_PARSER = "parser";
    private static final String PARAM_NAME_FILE = "file";

    private Part part;
    private static final Logger LOGGER = LogManager.getLogger(ParsingCommand.class);


    public String execute(HttpServletRequest request) throws IOException, ServletException {
        String page = "/parsing.jsp";
        String parser = request.getParameter(PARAM_NAME_PARSER).toUpperCase();
        boolean check = parser.equalsIgnoreCase(SAX) || parser.equalsIgnoreCase(DOM) || parser.equalsIgnoreCase(STAX);
        if (check) {
            String formedPath = formPath(request);
            validateFile(formedPath);

            TariffsBuilderFactory tariffsBuilderFactory = new TariffsBuilderFactory();
            TariffsBuilder builder = tariffsBuilderFactory.createTariffsBuilder(parser);
            builder.buildTariffs(formedPath);

            Set<Tariff> tariffs = builder.getTariffs();
            List<Tariff> list = new ArrayList<>(tariffs);
            request.setAttribute("list", list);
        } else {
            LOGGER.warn("Incorrect parser name : " + parser);
            page = "/index.jsp";
        }
        return page;
    }

    private String formPath(HttpServletRequest request) throws IOException, ServletException {
        String appPath = request.getServletContext().getRealPath("");
        String formedPath = null;
        part = request.getPart(PARAM_NAME_FILE);
        if (part.getSubmittedFileName() != null) {
            formedPath = appPath + File.separator + part.getSubmittedFileName();
            part.write(formedPath);
        } else {
            LOGGER.error("Haven't choose any *.xml file!");
        }
        return formedPath;
    }

    private void validateFile(String formedPath) throws IOException {
        FileInputStream formedPathStream = new FileInputStream(formedPath);
        XMLValidator validator = new XMLValidator();
        validator.validate(formedPathStream);

    }

}
