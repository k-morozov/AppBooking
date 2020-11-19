package com.appbooking.ClientBrain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.appbooking.ClientBrain.Message.Request.AddRequest;
import com.appbooking.ClientBrain.Message.Request.CheckRequest;
import com.appbooking.ClientBrain.Message.Request.DelRequest;
import com.appbooking.ClientBrain.Message.Request.Request;
import com.appbooking.ClientBrain.Message.Response.AddResponse;
import com.appbooking.ClientBrain.Message.Response.CheckResponse;
import com.appbooking.ClientBrain.Message.Response.DelResponse;
import com.appbooking.ClientBrain.Message.Response.Response;
import com.appbooking.ClientBrain.Message.Command;

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
                case DEL:
                    responses.add(do_DelRequest((DelRequest)request));
                default:
                    break;
            }
        }
        return responses;
    }

    private Response do_AddRequest(AddRequest request) {
        // System.out.println("working with AddRequest");
        if (!db.containsKey(request.get_date())) {            
            db.put(request.get_date(), new ArrayList<String>());
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
        boolean result = false;
        if (db.containsKey(request.get_date())) {
            ArrayList<String> value = db.get(request.get_date());
            if (value.contains(request.get_doing())) {
                result = true;
            }
        }
        return CheckResponse.create(result);
    }
    
    private Response do_DelRequest(DelRequest request) {
        boolean result = false;
        if (db.containsKey(request.get_date())) {
            ArrayList<String> values = db.get(request.get_date());
            result = values.remove(request.get_doing());
        }
        
        return DelResponse.create(result);
    }
}