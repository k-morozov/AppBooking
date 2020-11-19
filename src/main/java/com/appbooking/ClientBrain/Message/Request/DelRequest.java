package com.appbooking.ClientBrain.Message.Request;

import com.appbooking.ClientBrain.Message.Command;

public final class DelRequest extends Request {
    private final int date;
    private final String doing;

    public DelRequest() {
        super(Command.DEL);
        date = 0;
        doing = "none";
    }

    public DelRequest(int date, String doing) {
        super(Command.DEL);
        this.date = date;
        this.doing = doing;
    }

    static public DelRequest create(int date, String doing) {
        return new DelRequest(date, doing);
    }

    public int get_date() {
        return date;
    }

    public String get_doing() {
        return doing;
    }
}
