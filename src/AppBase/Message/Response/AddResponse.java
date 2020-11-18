package AppBase.Message.Response;

import AppBase.Message.Command;

public class AddResponse extends Response {
    public AddResponse() {
        super(Command.ADD);
    }

    public AddResponse(Command command) {
        super(command);

        System.out.println("Create AddResponse");
    }

    public static AddResponse create() {
        return new AddResponse();
    }
}