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
import java.util.ArrayList;

public class Worker {
    private Map<Integer, ArrayList<String>> db;

    public Worker() {
        db = new HashMap<Integer, ArrayList<String>>();
    }

    public void print_db() {
		for(Entry<Integer, ArrayList<String>> entry : db.entrySet()  ) {

            for(String value : entry.getValue()) {
                System.out.println("[" + entry.getKey() + ", " + value + "]");
            }
            
        }
    }

    public ArrayList<Response> do_request(ArrayList<Request> requests) {
        ArrayList<Response> responses = new ArrayList<>();
        for(Request request : requests) {
            // System.out.println("Worker do: " + request.get_command().name());

            switch (request.get_command()) {
                case ADD:
                    // System.out.println("read AddRequest");
                    responses.add(do_AddRequest((AddRequest)request));
                    break;
                case CHECK:
                    // System.out.println("read CheckRequest");
                    responses.add(do_CheckRequest((CheckRequest)request));
                    break;
                default:
                    break;
            }
        }
        return responses;
    }

    private Response do_AddRequest(AddRequest request) {
        // System.out.println("working with AddRequest");
        if (!db.containsKey(request.get_date())) {            
            db.put(request.get_date(), new ArrayList<>());
        }
        ArrayList<String> values = db.get(request.get_date());
        values.add(request.get_doing());

        Response response;
        response = AddResponse.create();

        return response;
    }
    
    private Response do_CheckRequest(CheckRequest request) {
        // System.out.println("working with CheckRequest");
        // System.out.println("working with CheckRequest: " + request.get_date() + " " + request.get_doing());
        Response response;
        boolean result = false;
        if (db.containsKey(request.get_date())) {
            ArrayList<String> value = db.get(request.get_date());
            if (value.contains(request.get_doing())) {
                result = true;
            }
        }
        response = CheckResponse.create(result);
        return response;
    } 
}
