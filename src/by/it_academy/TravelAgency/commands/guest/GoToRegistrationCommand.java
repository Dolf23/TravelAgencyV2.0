package by.it_academy.TravelAgency.commands.guest;

import by.it_academy.TravelAgency.constants.ConfigsConstants;
import by.it_academy.TravelAgency.commands.AbstractCommand;
import by.it_academy.TravelAgency.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class GoToRegistrationCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request) throws SQLException {
        String page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.REGISTRATION_PAGE_PATH);
        return page;
    }
}
