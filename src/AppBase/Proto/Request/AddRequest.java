package AppBase.Proto.Request;

import AppBase.Proto.Command;

public final class AddRequest extends Request {
    public AddRequest() {
        super(Command.ADD);
    }

    public AddRequest(Command command) {
        super(command);
        System.out.println("Create AddRequest");
    }

    public static AddRequest create() {
        return new AddRequest();
    }
}
