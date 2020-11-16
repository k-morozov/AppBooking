package AppBase.Proto.Request;

import AppBase.Proto.Command;

public final class AddRequest extends Request {
    private AddRequest() {
        super(Command.ADD);
    }

    private AddRequest(Command command) {
        super(command);
        System.out.println("Create AddRequest");
    }

    public static AddRequest create() {
        return new AddRequest();
    }
}
