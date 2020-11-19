package com.appbooking.ClientBrain.Message.Request;

import com.appbooking.ClientBrain.Message.Command;

public final class AddRequest extends Request {
    private final int date;
    private final String doing;

    public AddRequest() {
        super(Command.ADD);
        date = 0;
        doing = "none";
    }

    public AddRequest(int date, String doing) {
        super(Command.ADD);
        this.date = date;
        this.doing = doing;
    }

    public static AddRequest create(int date, String doing) {
        return new AddRequest(date, doing);
    }

    public int get_date() {
        return date;
    }

    public String get_doing() {
        return doing;
    }

    
}
