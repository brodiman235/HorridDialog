package Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by derek_modarski on 4/15/15.
 */
public class LoggerImpl implements Logger {

    @Override
    public synchronized void log(String email, String firstName, String lastName) {
        try {
            BufferedWriter out = null;
            try {
                FileWriter fstream = new FileWriter("userdata.csv", true);
                out = new BufferedWriter(fstream);
                out.write(String.format("\n%s, %s, %s", firstName, lastName, email));
            } catch (IOException ioe) {
                System.err.println("Error: " + ioe.getMessage());
            } finally {
                if (out != null) {
                    out.close();
                }
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

}
