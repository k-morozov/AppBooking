package com.appbooking.ClientBrain.Message.Request;

import com.appbooking.ClientBrain.Message.Command;
import com.appbooking.ClientBrain.Message.Message;

public abstract class Request implements Message {
    protected final Command command;

    public Request(Command command) {
        this.command = command;
    }

    @Override
    public final Command get_command() {
        return command;
    }
}
