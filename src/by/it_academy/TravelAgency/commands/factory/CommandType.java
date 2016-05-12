package by.it_academy.TravelAgency.commands.factory;

import by.it_academy.TravelAgency.commands.Command;
import by.it_academy.TravelAgency.commands.guest.*;

public enum CommandType {
    //guest commands
    LOGIN, LOGOUT, REGISTRATION, BACK, GO_TO_REGISTRATION,

    //user command
    RESERV,

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

            default:
                throw new EnumConstantNotPresentException(this.getDeclaringClass(), this.name());
        }
    }
}
