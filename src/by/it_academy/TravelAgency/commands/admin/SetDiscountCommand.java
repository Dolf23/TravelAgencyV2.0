package by.it_academy.TravelAgency.commands.admin;

import by.it_academy.TravelAgency.commands.AbstractCommand;
import by.it_academy.TravelAgency.constants.ConfigsConstants;
import by.it_academy.TravelAgency.constants.MessageConstants;
import by.it_academy.TravelAgency.constants.Parameters;
import by.it_academy.TravelAgency.dao.TourDAO;
import by.it_academy.TravelAgency.dto.Tour;
import by.it_academy.TravelAgency.logger.logger;
import by.it_academy.TravelAgency.managers.ConfigurationManager;
import by.it_academy.TravelAgency.managers.MessageManager;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class SetDiscountCommand extends AbstractCommand {
    private static String idTourString = "";
    private static String amountDiscountString = "";
    @Override
    public String execute(HttpServletRequest request) {
        String page;
        try{
            idTourString = request.getParameter(Parameters.DISCOUNTING_TOUR);
            amountDiscountString = request.getParameter(Parameters.AMOUNT_DISCOUNT);
            if (isFieldsFull()){
                int idTour = Integer.parseInt(idTourString);
                int amountDiscount = Integer.parseInt(amountDiscountString);
                makeDiscount(idTour, amountDiscount);

                page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ADMIN_PAGE_PATH);
                request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.SUCCESS_OPERATION));
            }
            else {
                page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ADMIN_PAGE_PATH);
                request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.EMPTY_FIELDS));
            }
        } catch (SQLException e) {
            logger.writeLog(e.getMessage());
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ERROR_PAGE_PATH);
            request.setAttribute(Parameters.ERROR_DATABASE, MessageManager.INSTANCE.getProperty(MessageConstants.ERROR_DATABASE));
        }
        return page;
    }

    private boolean isFieldsFull(){
        boolean is = false;
        if (null != amountDiscountString && null != idTourString)
            is = true;
        return is;
    }

    private void makeDiscount(int idTour, int amountDiscount) throws SQLException {
        Tour tour = TourDAO.INSTANCE.getEntityByID(idTour);
        tour.setDiscount(amountDiscount);
        TourDAO.INSTANCE.setDiscountById(tour);
    }
}
