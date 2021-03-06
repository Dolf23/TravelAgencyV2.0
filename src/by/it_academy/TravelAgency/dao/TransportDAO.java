package by.it_academy.TravelAgency.dao;

import by.it_academy.TravelAgency.connectionpool.ConnectionPool;
import by.it_academy.TravelAgency.constants.SQLRequests;
import by.it_academy.TravelAgency.dto.Transport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.it_academy.TravelAgency.constants.ColumnNames.TRANSPORTS_ID;
import static by.it_academy.TravelAgency.constants.ColumnNames.TRANSPORTS_TRANSPORT;

public enum TransportDAO implements DAO<Transport> {
    INSTANCE;

    @Override
    public List<Transport> getAll() throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.GET_ALL_TRANSPORTS);
        ResultSet resultSet = statement.executeQuery();
        List<Transport> list = new ArrayList<>();
        while (resultSet.next()){
            Transport transport = new Transport();
            transport.setId(resultSet.getInt(TRANSPORTS_ID));
            transport.setTransport(resultSet.getString(TRANSPORTS_TRANSPORT));
            list.add(transport);
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return list;
    }

    @Override
    public void createEntity(Transport transport) throws SQLException {

    }

    @Override
    public Transport getEntityByID(int id) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.GET_TRANSPORT_BY_ID);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        Transport transport = new Transport();
        while (resultSet.next()){
            transport.setId(resultSet.getInt(TRANSPORTS_ID));
            transport.setTransport(resultSet.getString(TRANSPORTS_TRANSPORT));
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return transport;
    }

    public int getIdByTransport(String transport) throws SQLException{
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.GET_ID_BY_TRANSPORT);
        statement.setString(1, transport);
        ResultSet resultSet = statement.executeQuery();

        int id;
        if (resultSet.next())
            id = resultSet.getInt(TRANSPORTS_ID);
        else
            id = 0;
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return id;
    }
}
