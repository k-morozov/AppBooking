package com.appbooking.ClientBrain.Message;

public interface Message {
    // Command comand = Command.UNKNOWN;
    
    default Command get_command() {
        return Command.UNKNOWN;
    }
}
