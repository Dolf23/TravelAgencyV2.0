package by.it_academy.TravelAgency.commands.factory;

import by.it_academy.TravelAgency.commands.Command;
import by.it_academy.TravelAgency.commands.admin.CreateTourCommand;
import by.it_academy.TravelAgency.commands.admin.GoToCreateTourCommand;
import by.it_academy.TravelAgency.commands.guest.*;
import by.it_academy.TravelAgency.commands.user.GoToSelectTourCommand;
import by.it_academy.TravelAgency.commands.user.SelectTourCommand;

public enum CommandType {
    //guest commands
    LOGIN, LOGOUT, REGISTRATION, BACK, GO_TO_REGISTRATION,

    //user command
    GO_TO_SELECT_TOUR, SELECT_TOUR, RESERVE, SHOW_RESERVED_TOURS,

    //admin command
    SHOW_TOURS, GO_TO_CREATE_TOUR, CREATE_TOUR, GO_TO_SET_DISCOUNT, SETDISCOUNT;

    public Command getCurrentCommand(){
        switch (this){
            case LOGIN:
                return new LoginCommand();

            case LOGOUT:
                return new LogoutCommand();

            case REGISTRATION:
                return new RegistrationCommand();

            case BACK:
                return new GoBackCommand();

            case GO_TO_REGISTRATION:
                return new GoToRegistrationCommand();

            case GO_TO_SELECT_TOUR:
                return new GoToSelectTourCommand();

            case SELECT_TOUR:
                return new SelectTourCommand();

            case GO_TO_CREATE_TOUR:
                return new GoToCreateTourCommand();

            case CREATE_TOUR:
                return new CreateTourCommand();
            default:
                throw new EnumConstantNotPresentException(this.getDeclaringClass(), this.name());
        }
    }
}
