package AppBase;

import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;

import AppBase.Message.Request.Request;
import AppBase.Message.Request.AddRequest;
import AppBase.Message.Request.CheckRequest;
import AppBase.Message.Response.Response;
import AppBase.Message.Response.AddResponse;
import AppBase.Message.Response.CheckResponse;

public class Worker {
    private Map<Integer, String> db;

    public Worker() {
        db = new HashMap<Integer, String>();
    }

    public void print_db() {
		for(Entry<Integer, String> entry : db.entrySet()  ) {
            System.out.println("[" + entry.getKey() + ", " + entry.getValue() + "]");
        }
    }

    public Response do_request(Request request) {
        System.out.println("Worker do: " + request.get_command().name());

        Response response = null;
        switch (request.get_command()) {
            case ADD:
                System.out.println("read AddRequest");
                response = do_AddRequest((AddRequest)request);
                break;
            case CHECK:
                System.out.println("read CheckRequest");
                response = do_CheckRequest((CheckRequest)request);
                break;
            default:
                break;
        }

        return response;
    }

    private Response do_AddRequest(AddRequest request) {
        System.out.println("working with AddRequest");
        db.put(request.get_date(), request.get_doing());

        Response response;
        response = AddResponse.create();

        return response;
    }
    
    private Response do_CheckRequest(CheckRequest request) {
        // System.out.println("working with CheckRequest");
        System.out.println("working with CheckRequest: " + request.get_date() + " " + request.get_doing());
        Response response;
        String value = db.get(request.get_date());
        response = CheckResponse.create(value != null && value.equals(request.get_doing()));
        
        return response;
    } 
}
