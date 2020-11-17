package AppBase.Message.Request;

import AppBase.Message.Command;

public final class CheckRequest extends Request {
    private final int date;
    private final String doing;

    public CheckRequest() {
        super(Command.CHECK);
        date = 0;
        doing = "none";
    }

    public CheckRequest(int date, String doing) {
        super(Command.CHECK);
        this.date = date;
        this.doing = doing;
    }

    public static CheckRequest create(int date, String doing) {
        return new CheckRequest(date, doing);
    }

    public int get_date() {
        return date;
    }

    public String get_doing() {
        return doing;
    }

    
}
