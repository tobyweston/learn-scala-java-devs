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

import java.util.Arrays;
import java.util.List;

public class Loops {

    public static class Do {
        public static void main(String... args) {
            int i = 0;
            do {
                System.out.println(i);
                i++;
            } while (i < 10);
        }
    }

    public static class While {
        public static void main(String... args) {
            int i = 0;
            while (i < 10) {
                System.out.println(i);
                i++;
            }
        }
    }

    public static class For {
        public static void main(String... args) {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        }
    }

    public static class EnhancedFor {
        public static void main(String... args) {
            List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
            for (Integer i : numbers) {
                System.out.println(i);
            }

            numbers.forEach(i -> System.out.println(i));
            numbers.forEach(System.out::println);
        }
    }

}
