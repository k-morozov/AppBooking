package com.appbooking.ClientBrain.Message.Request;

import com.appbooking.ClientBrain.Message.Command;
import com.appbooking.ClientBrain.Message.Message;

public abstract class Request implements Message {
    protected final Command m_command;

    public Request(Command a_command) {
        m_command = a_command;
    }

    public final Command get_command() {
        return m_command;
    }
}
