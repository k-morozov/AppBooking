package AppBase.Message.Request;

import AppBase.Message.Command;

public final class AddRequest extends Request {
    private int date;
    private String doing;

    public AddRequest() {
        super(Command.ADD);
        date = 0;
        doing = "none";
    }

    public static AddRequest create() {
        return new AddRequest();
    }

    public AddRequest set_date(int date) {
        this.date = date;
        return this;
    }

    public int get_date() {
        return date;
    }

    public AddRequest set_doing(String doing) {
        this.doing = doing;
        return this;
    }

    public String get_doing() {
        return doing;
    }

    
}
