package by.it_academy.TravelAgency.commands.factory;

import by.it_academy.TravelAgency.commands.Command;
import by.it_academy.TravelAgency.commands.guest.*;
import by.it_academy.TravelAgency.commands.user.GoToSelectTourCommand;
import by.it_academy.TravelAgency.commands.user.SelectTourCommand;

public enum CommandType {
    //guest commands
    LOGIN, LOGOUT, REGISTRATION, BACK, GO_TO_REGISTRATION,

    //user command
    GO_TO_SELECT_TOUR, SELECT_TOUR, RESERVE,

    //admin command
    GREATETOUR, SETDISCOUNT;

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
            default:
                throw new EnumConstantNotPresentException(this.getDeclaringClass(), this.name());
        }
    }
}
