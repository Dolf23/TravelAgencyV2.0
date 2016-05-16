package test.by.it_academy.TravelAgency.commands.factory;

import by.it_academy.TravelAgency.commands.factory.CommandType;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommandTypeTest {

    @Test
    public void testGetCurrentCommand() throws Exception {
        String command = "login";
        CommandType type = CommandType.valueOf(command.toUpperCase());
        assertEquals(CommandType.LOGIN, type);
    }
}