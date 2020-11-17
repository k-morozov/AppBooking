import java.util.Scanner;
import java.util.logging.*;

import AppBase.Parser;
import AppBase.Worker;
import AppBase.Message.Request.Request;
import AppBase.Message.Response.Response;

public class App {
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        config_logger();

        LOGGER.log(Level.FINE, "Start AppBooking");

        Parser m_parser = new Parser();
        Worker worker = new Worker();
        Scanner sc = new Scanner(System.in);

        try {
            int count_commands = sc.nextInt();

            sc.nextLine();
            LOGGER.log(Level.INFO, "read count command: {0}", count_commands);

            for(int i=0; i<count_commands; ++i) {
                String command = sc.nextLine();
                LOGGER.log(Level.INFO, "read command: {0}", command);

                Request request = m_parser.parse_request(command);
                if (request != null) {
                    Response response = worker.do_request(request);
                    String answer = m_parser.parse_response(response);
                    System.out.println(answer);
                } else {
                    System.out.println("Failed parse");
                }
            }

            worker.print_db();
        } 
        catch (Exception ex){
            LOGGER.log(Level.WARNING, "Exception " + ex);
            ex.printStackTrace();
        }

        sc.close();

        LOGGER.log(Level.FINE, "Finished successfully");
    }


    private static void config_logger() {
        Handler handler;
        LOGGER.setUseParentHandlers(false);

        try {
            handler = new FileHandler("log.txt");
            LOGGER.setLevel(Level.OFF);

        } catch (Exception ex) {
            handler = new ConsoleHandler();
            LOGGER.setLevel(Level.WARNING);
        }

        LOGGER.addHandler(handler);
        Formatter formatter = new SimpleFormatter();
        // String format = "[%1$tF %1$tT] [%2$-7s] %3$s %n";
        handler.setFormatter(formatter);
        LOGGER.setLevel(Level.ALL);
    }
}
