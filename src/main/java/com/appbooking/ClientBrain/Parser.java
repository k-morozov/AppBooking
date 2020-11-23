package com.appbooking.ClientBrain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import com.appbooking.ClientBrain.Message.Request.*;
import com.appbooking.ClientBrain.Message.Response.*;

public class Parser {

    public Parser() {
        System.out.println("Create Parser()");
    }

    public ArrayList<Request> parse_request(String str_command) {
        ArrayList<Request> requests = new ArrayList<>();

        ArrayList<String> params = new ArrayList<>(Arrays.asList(str_command.split(" ")));
        if (!params.isEmpty()) {
            Iterator<String> itParams = params.iterator();

            switch (itParams.next()) {
                case "add": {
                    Integer date;
                    if (itParams.hasNext()) {
                        date = Integer.parseInt(itParams.next());
                        while (itParams.hasNext()) {
                            requests.add(AddRequest.create(date, itParams.next()));
                        }
                    }
                    break;
                }
                case "check": {
                    Integer date;
                    if (itParams.hasNext()) {
                        date = Integer.parseInt(itParams.next());
                        while (itParams.hasNext()) {
                            requests.add(CheckRequest.create(date, itParams.next()));
                        }
                    }
                    break;
                }

                case "del": {
                    Integer date;
                    if (itParams.hasNext()) {
                        date = Integer.parseInt(itParams.next());
                        while (itParams.hasNext()) {
                            requests.add(DelRequest.create(date, itParams.next()));
                        }
                    }
                    break;
                }
                default:
                    System.out.println("Unknown command");
                    break;
            }
        }

        return requests;
    }

    public ArrayList<String> parse_response(ArrayList<Response> responses) {
        ArrayList<String> results = new ArrayList<>();
        StringBuilder str = new StringBuilder();

        for(Response response : responses) {
            
            str.append("parsing response: " + response.get_command().name());
            switch (response.get_command()) {
                case ADD:
                    System.out.println("Succesfully ADD");
                    break;
                case CHECK: {
                    CheckResponse res = (CheckResponse)response;
                    if (res.get_status()) {
                        System.out.println("Check: YES");
                    } else {
                        System.out.println("Check: NO");
                    }
                    break;
                }

                case DEL: {
                    DelResponse res = (DelResponse)response;
                    if (res.get_status()) {
                        System.out.println("Del: YES");
                    } else {
                        System.out.println("Del: NO");
                    }
                    break;
                }
                default:
                    System.out.print("Unknown response");
                    break;
            }

            results.add(str.toString());
        }
        return results;

    }
}