package com.appbooking.ClientBrain.Message.Response;

import com.appbooking.ClientBrain.Message.Command;
import com.appbooking.ClientBrain.Message.Message;

public abstract class Response implements Message {
    protected final Command command;

    public Response(Command a_command) {
        this.command = a_command;
    }

    @Override
    public final Command get_command() {
        return command;
    }
}
