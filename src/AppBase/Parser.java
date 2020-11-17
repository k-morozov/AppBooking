package AppBase;

import AppBase.Message.Request.Request;
import AppBase.Message.Request.AddRequest;
import AppBase.Message.Request.CheckRequest;
import AppBase.Message.Response.CheckResponse;
import AppBase.Message.Response.Response;

public class Parser {

    public Parser() {
        System.out.println("Create Parser()");
    }

    public Request parse_request(String str_command) {
        // System.out.println("get str: " + str_command);
        Request req = null;

        String[] params = str_command.split(" ");
        if (params.length != 0) {
            switch (params[0]) {
                case "add":
                    System.out.println("command add");
                    req = AddRequest.create(Integer.parseInt(params[1]), params[2]);
                    break;
                case "check":
                    System.out.println("command check");
                    req = CheckRequest.create(Integer.parseInt(params[1]), params[2]);
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
        return str.toString();

    }
}
