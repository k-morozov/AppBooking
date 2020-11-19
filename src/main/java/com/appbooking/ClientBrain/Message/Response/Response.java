package com.appbooking.ClientBrain.Message.Response;

import com.appbooking.ClientBrain.Message.Command;
import com.appbooking.ClientBrain.Message.Message;

public abstract class Response implements Message {
    protected final Command m_command;

    public Response(Command a_command) {
        m_command = a_command;
    }

    public final Command get_command() {
        return m_command;
    }
}
