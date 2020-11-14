package AppBase.Proto.Request;

import AppBase.Proto.Command;

public final class AddRequest extends Request {
    public AddRequest(Command command) {
        super(command);
        System.out.println("Create AddRequest");
    }
}
