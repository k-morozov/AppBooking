package AppBase;

import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.HashMap;

import AppBase.Message.Request.Request;
import AppBase.Message.Request.AddRequest;
import AppBase.Message.Response.Response;
import AppBase.Message.Response.AddResponse;

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
}
