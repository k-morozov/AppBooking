package com.appbooking.ClientBrain.Message.Response;

import com.appbooking.ClientBrain.Message.Command;

public class DelResponse extends Response {
    private final boolean status;

    public DelResponse() {
        super(Command.DEL);
        status = false;
    }

    public DelResponse(boolean status) {
        super(Command.DEL);
        this.status = status;

        System.out.println("Create DelResponse");
    }

    public static DelResponse create(boolean status) {
        return new DelResponse(status);
    }

    public boolean get_status() {
        return this.status;
    }
}
