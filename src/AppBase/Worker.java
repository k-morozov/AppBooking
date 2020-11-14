package AppBase;

import AppBase.Proto.Command;
import AppBase.Proto.Request.Request;
import AppBase.Proto.Response.Response;
import AppBase.Proto.Response.AddResponse;

public class Worker {
    public Response do_request(Request request) {
        System.out.println("Worker do: " + request.get_command().name());

        Response response = null;
        switch (request.get_command()) {
            case ADD:
                System.out.println("read AddRequest");
                response = do_AddRequest(request);
                break;
            default:
                break;
        }

        return response;
    }

    private Response do_AddRequest(Request request) {
        System.out.println("working with AddRequest");
        Response response;
        response = new AddResponse(Command.ADD);

        return response;
    } 
}
