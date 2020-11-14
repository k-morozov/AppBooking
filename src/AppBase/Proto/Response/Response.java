package AppBase.Proto.Response;

import AppBase.Proto.Message;
import AppBase.Proto.Command;

public abstract class Response implements Message {
    protected final Command m_command;

    public Response(Command a_command) {
        m_command = a_command;
    }

    public final Command get_command() {
        return m_command;
    }
}
