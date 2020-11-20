package com.appbooking.ClientBrain;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import java.util.*;
import com.appbooking.ClientBrain.Message.Request.*;
import com.appbooking.ClientBrain.Message.*;

public class TestParser {
    
    @Test
    public void RequestEmpty() {
        Parser parser = new Parser();
        ArrayList<Request> requests = parser.parse_request("");
        assertTrue( requests.isEmpty() );
    }

    @Test
    public void RequestOne() {
        Parser parser = new Parser();
        ArrayList<Request> requests = parser.parse_request("add 1 go");
        assertTrue( !requests.isEmpty() );
        assertTrue( requests.size() == 1 );
        assertTrue( requests.get(0).get_command() == Command.ADD );
        assertTrue( requests.get(0) instanceof AddRequest) ;
        AddRequest request = (AddRequest)requests.get(0);
        assertTrue( request.get_date() == 1 );
        assertTrue( request.get_doing().equals("go") );
    }

    @Test
    public void RequestTwo() {
        Parser parser = new Parser();
        ArrayList<Request> requests = parser.parse_request("add 1 go read");
        assertTrue( !requests.isEmpty() );
        assertTrue( requests.size() == 2 );
        assertTrue( requests.get(0) instanceof AddRequest) ;
        assertTrue( requests.get(0).get_command() == Command.ADD );
        assertTrue( requests.get(1) instanceof AddRequest) ;
        assertTrue( requests.get(1).get_command() == Command.ADD );
    }
}
