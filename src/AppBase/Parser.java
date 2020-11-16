package AppBase;

import AppBase.Proto.Request.Request;
import AppBase.Proto.Request.AddRequest;
import AppBase.Proto.Response.Response;

public class Parser {

    public Parser() {
        System.out.println("Create Parser()");
    }

    public Request parse_request(String str_command) {
        System.out.println("get str: " + str_command);
        Request req = null;

        String[] params = str_command.split(" ");
        if (params.length != 0) {
            switch (params[0]) {
                case "add":
                    System.out.println("command add");
                    req = AddRequest.create();
                    break;
                default:
                    System.out.println("Unknown command");
                    break;
            }
        }

        return req;
    }

    public String parse_response(Response response) {
        StringBuilder str = new StringBuilder();
        str.append("parsing response: " + response.get_command().name());

        return str.toString();

    }
}
