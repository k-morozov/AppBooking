package com.appbooking.ClientBrain.Message.Response;

import com.appbooking.ClientBrain.Message.Command;

public class CheckResponse extends Response {
    private final boolean status;

    public CheckResponse() {
        super(Command.CHECK);
        status = false;
    }

    public CheckResponse(boolean status) {
        super(Command.CHECK);
        this.status = status;
    }

    public static CheckResponse create(boolean status) {
        return new CheckResponse(status);
    }

    public boolean get_status() {
        return status;
    }
}
