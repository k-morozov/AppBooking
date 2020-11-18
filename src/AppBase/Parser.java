package AppBase;

import AppBase.Message.Request.Request;
import AppBase.Message.Request.AddRequest;
import AppBase.Message.Request.CheckRequest;
import AppBase.Message.Response.CheckResponse;
import AppBase.Message.Response.Response;
import java.util.Iterator;
import java.util.ArrayList;

public class Parser {

    public Parser() {
        System.out.println("Create Parser()");
    }

    public ArrayList<Request> parse_request(String str_command) {
        // System.out.println("get str: " + str_command);
        ArrayList<Request> req = new ArrayList<>();

        String[] strs = str_command.split(" ");
        ArrayList<String> params = new ArrayList<>();
        for(String str : strs) {
            params.add(str);
        }

        if (!params.isEmpty()) {
            switch (params.get(0)) {
                case "add": {
                    System.out.println("command add");

                    Iterator<String> itParams = params.iterator();
                    itParams.next();
                    Integer date;
                    if (itParams.hasNext()) {
                        date = Integer.parseInt(itParams.next());
                        while (itParams.hasNext()) {
                            req.add(AddRequest.create(date, itParams.next()));
                        }
                    }
                    break;
                }
                case "check": {
                    System.out.println("command check");
                    // req.add(CheckRequest.create(Integer.parseInt(params.get(1)), params.get(2)));
                    Iterator<String> itParams = params.iterator();
                    itParams.next();
                    Integer date;
                    if (itParams.hasNext()) {
                        date = Integer.parseInt(itParams.next());
                        while (itParams.hasNext()) {
                            req.add(CheckRequest.create(date, itParams.next()));
                        }
                    }
                    break;
                }
                default:
                    System.out.println("Unknown command");
                    break;
            }
        }

        return req;
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
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
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
