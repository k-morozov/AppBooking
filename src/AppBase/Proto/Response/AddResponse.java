package AppBase.Proto.Response;

import AppBase.Proto.Command;

public class AddResponse extends Response {
    public AddResponse(Command command) {
        super(command);

        System.out.println("Create AddResponse");
    }
}
