package com.appbooking.ClientBrain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.appbooking.ClientBrain.Message.Request.*;
import com.appbooking.ClientBrain.Message.Response.*;

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

            switch (request.get_command()) {
                case ADD:
                    responses.add(do_AddRequest(request));
                    break;
                case CHECK:
                    // System.out.println("read CheckRequest");
                    responses.add(do_CheckRequest(request));
                    break;
                case DEL:
                    responses.add(do_DelRequest(request));
                default:
                    break;
            }
        }
        return responses;
    }

    private Response do_AddRequest(Request request) {
        Response response;
        if (request instanceof AddRequest) {
            AddRequest add_request = (AddRequest)request;
            if (!db.containsKey(add_request.get_date())) {            
                db.put(add_request.get_date(), new ArrayList<String>());
            }
            ArrayList<String> values = db.get(add_request.get_date());
            values.add(add_request.get_doing());
        }
                
        response = AddResponse.create();
        return response;
    }
    
    private Response do_CheckRequest(Request request) {
        boolean result = false;
        if (request instanceof CheckRequest) {
            CheckRequest check_request = (CheckRequest)request;
            if (db.containsKey(check_request.get_date())) {
                ArrayList<String> value = db.get(check_request.get_date());
                if (value.contains(check_request.get_doing())) {
                    result = true;
                }
            }
        }
        return CheckResponse.create(result);
    }
    
    private Response do_DelRequest(Request request) {
        boolean result = false;
        if (request instanceof DelRequest) {
            DelRequest del_request = (DelRequest)request;
            if (db.containsKey(del_request.get_date())) {
                ArrayList<String> values = db.get(del_request.get_date());
                result = values.remove(del_request.get_doing());
            }
        }
        
        return DelResponse.create(result);
    }
}
