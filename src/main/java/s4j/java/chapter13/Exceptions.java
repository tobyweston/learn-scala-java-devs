/*
 * Copyright (c) 2015-2017 Toby Weston
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
