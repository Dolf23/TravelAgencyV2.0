package by.it_academy.TravelAgency.commands.user;

import by.it_academy.TravelAgency.commands.AbstractCommand;
import by.it_academy.TravelAgency.constants.ConfigsConstants;
import by.it_academy.TravelAgency.constants.MessageConstants;
import by.it_academy.TravelAgency.constants.Parameters;
import by.it_academy.TravelAgency.dao.TourDAO;
import by.it_academy.TravelAgency.logger.logger;
import by.it_academy.TravelAgency.managers.ConfigurationManager;
import by.it_academy.TravelAgency.managers.MessageManager;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.Map;

import static by.it_academy.TravelAgency.constants.Parameters.*;

public class SelectTourCommand extends AbstractCommand {
    private static int fk_tourType;
    private static int fk_country;
    private static int fk_transport;
    private static int fk_hotelType;
    private static int fk_foodComplex;

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        fk_tourType = Integer.parseInt(request.getParameter(TOUR_TYPE));
        fk_country = Integer.parseInt(request.getParameter(COUNTRY));
        fk_transport = Integer.parseInt(request.getParameter(TRANSPORT));
        fk_hotelType = Integer.parseInt(request.getParameter(HOTEL_TYPE));
        fk_foodComplex = Integer.parseInt(request.getParameter(FOOD_COMPLEX));

        try {
            Map<Integer, String> map = TourDAO.INSTANCE.getMapToursByRequest(fk_tourType, fk_country, fk_transport, fk_hotelType, fk_foodComplex);
            if (!map.isEmpty()){
                request.setAttribute(TOURS_MAP, map);
                page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.USER_RESERVE_PAGE_PATH);

            }
            else {
                page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.USER_SELECT_TOUR_PAGE_PATH);
                request.setAttribute(ERROR_TOUR_LIST_IS_EMPTY, MessageManager.INSTANCE.getProperty(MessageConstants.ERROR_TOURS_LIST));
            }
        }
        catch (SQLException e) {
            logger.writeLog(e.getMessage());
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ERROR_PAGE_PATH);
            request.setAttribute(Parameters.ERROR_DATABASE, MessageManager.INSTANCE.getProperty(MessageConstants.ERROR_DATABASE));
        }
        return page;
    }
}
