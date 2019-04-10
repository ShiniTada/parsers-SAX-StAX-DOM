package com.epam.yanabogdanovich.servlet;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/Controller")
@MultipartConfig(fileSizeThreshold = 1024 * 1024)
public class Controller extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(Controller.class);

    @Override
    public void init() throws ServletException {
        super.init();
        LOGGER.info(getClass().getSimpleName() + " has been initialized.");
    }

    @Override
    public void destroy() {
        super.destroy();
        LOGGER.info(getClass().getSimpleName() + " has been destroyed.");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String page;
        ParsingCommand command = new ParsingCommand();
            page = command.execute(request);
            request.getRequestDispatcher(page).forward(request, response);
    }

}
