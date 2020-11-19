package com.appbooking.ClientBrain;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import java.util.*;
import com.appbooking.ClientBrain.Parser;
import com.appbooking.ClientBrain.Message.Request.*;

public class TestParser {
    
    @Test
    public void checkParseRequest() {
        Parser parser = new Parser();
        ArrayList<Request> requests = parser.parse_request("add 1 go");
        assertTrue( !requests.isEmpty() );
    }
}
