package by.it_academy.TravelAgency.commands;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public interface Command {
    String execute(HttpServletRequest request) throws SQLException;
}
