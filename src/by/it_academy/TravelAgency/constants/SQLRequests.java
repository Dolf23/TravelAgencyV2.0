package by.it_academy.TravelAgency.constants;

import static by.it_academy.TravelAgency.constants.ColumnNames.*;

public class SQLRequests {
    public static final String GET_ALL_ACTIONS = "SELECT * FROM actions";
    public static final String ADD_ACTION = String.format("INSERT INTO actions(%s, %s, %s) VALUES (?, ?, ?)", ACTIONS_FK_ACTION, ACTIONS_FK_USER, ACTIONS_FK_TOUR);
    public static final String GET_ACTION_BY_ID = String.format("SELECT * FROM actions WHERE %s='?';", ACTIONS_ID);

    public static final String GET_ALL_ACTION_TYPES = "SELECT * FROM action_types";
    public static final String GET_ACTION_TYPE_BY_ID = String.format("SELECT * FROM action_types WHERE %s='?';", TOUR_TYPES_ID);

    public static final String GET_ALL_COUNTRIES = "SELECT * FROM countries";
    public static final String ADD_COUNTRY = String.format("INSERT INTO countries(%s) VALUES (?);", COUNTRIES_COUNTRY);
    public static final String GET_COUNTRY_BY_ID = String.format("SELECT * FROM countries WHERE %s='?';", COUNTRIES_ID);

    public static final String GET_ALL_FOOD_COMPLEXES = "SELECT * FROM food_complexes";
    public static final String GET_FOOD_COMPLEX_BY_ID = String.format("SELECT * FROM food_complexes %s='?';", FOOD_COMPLEXES_ID);

    public static final String GET_ALL_HOTEL_TYPES = "SELECT * FROM hotel_types";
    public static final String GET_HOTEL_TYPE_BY_ID = String.format("SELECT * FROM hotel_types %s='?';", HOTEL_TYPES_ID);

    public static final String GET_ALL_ROLES = "SELECT * FROM roles";
    public static final String GET_ROLE_BY_ID = String.format("SELECT * FROM roles %s='?]", ROLES_ID);
    public static final String GET_ROLE_ID_BY_ROLE = String.format("SELECT * FROM roles %s='?]", ROLES_ROLE);

    public static final String GET_ALL_TOURS = "SELECT * FROM tours";
    public static final String ADD_TOUR = String.format("INSERT INTO tours(%s, %s, %s, %s, %s, %s, %s) VALUES (?, ?, ?, ?, ?, ?, ?);", TOURS_FK_COUNTRY, TOURS_FK_TOUR_TYPE, TOURS_FK_TRANSPORT, TOURS_FK_HOTEL_TYPE, TOURS_FK_FOOD_COMPLEX, TOURS_COST, TOURS_DISCOUNT);
    public static final String GET_TOUR_BY_ID = String.format("SELECT * FROM tours %s='?]", TOURS_ID);

    public static final String GET_ALL_TOUR_TYPES = "SELECT * FROM tour_types";
    public static final String GET_TOUR_TYPE_BY_ID = String.format("SELECT * FROM tour_types %s='?';", ACTION_TYPES_ACTION_TYPE);

    public static final String GET_ALL_TRANSPORTS = "SELECT * FROM transports";
    public static final String GET_TRANSPORT_BY_ID = String.format("SELECT * FROM transports %s='?';", TRANSPORTS_ID);

    public static final String GET_ALL_USERS = "SELECT * FROM users";
    public static final String ADD_USER = String.format("INSERT INTO users(%s, %s, %s, %s, %s, %s) VALUES (?, ?, ?, ?, ?, ?, ?);", USERS_NAME, USERS_SURNAME, USERS_EMAIL, USERS_LOGIN, USERS_PASSWORD, USERS_FK_ROLE);
    public static final String GET_USER_BY_ID = String.format("SELECT * FROM users %s='?'", USERS_ID);
    public static final String GET_USER_BY_LOGIN = String.format("SELECT * FROM users %s='?'", USERS_LOGIN);
    public static final String CHECK_AUTHORIZATION = String.format("SELECT %s,%s FROM users WHERE %s=? AND %s=?;", USERS_LOGIN, USERS_PASSWORD, USERS_LOGIN, USERS_PASSWORD);
    public static final String CHECK_ROLE = String.format("SELECT %s FROM users WHERE %s=?;", USERS_FK_ROLE, USERS_LOGIN);
    public static final String CHECK_LOGIN = String.format("SELECT %s FROM users WHERE %s=?;", USERS_LOGIN, USERS_ID);
}
