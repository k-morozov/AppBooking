package AppBase.Proto.Response;

import AppBase.Proto.Command;

public class AddResponse extends Response {
    private AddResponse() {
        super(Command.ADD);
    }

    private AddResponse(Command command) {
        super(command);

        System.out.println("Create AddResponse");
    }

    public static AddResponse create() {
        return new AddResponse();
    }
}
