package s4j.java.chapter13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Exceptions {

    public static void main(String... args) {
        try {
            URL url = new URL("http://baddotrobot.com");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            try {
                String line;
                while ((line = reader.readLine()) != null)
                    System.out.println(line);
            } finally {
                reader.close();
            }
        } catch (MalformedURLException e) {
            System.out.println("Bad URL");
        } catch (IOException e) {
            System.out.println("Problem reading data from the web: " + e.getMessage());
        }
    }
}
