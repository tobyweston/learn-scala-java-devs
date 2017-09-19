
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

package s4j.java.chapter14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LowerBounds {

    public static <A extends Comparable<? super A>> void sort(List<A> list) {
        Collections.sort(list);
    }

    public static void main(String... args) {
        List<Animal> zoo = new ArrayList<>();
        zoo.add(new Wolf());
        zoo.add(new Lion());
        zoo.add(new Wolf());
        System.out.println(zoo);
        sort(zoo);
        System.out.println(zoo);

        List<Cat> cattery = new ArrayList<>();
        sort(cattery);
    }

    interface Animal extends Comparable<Animal> {
        default int compareTo(Animal o) {
            return this.getFoodChainRanking().compareTo(o.getFoodChainRanking());
        }
        Integer getFoodChainRanking();
    }

    static class Lion implements Animal {
        @Override
        public Integer getFoodChainRanking() {
            return 10;
        }
    }

    static class Wolf implements Animal {
        @Override
        public Integer getFoodChainRanking() {
            return 8;
        }
    }

    static class DomesticPet {}

    static class Cat extends DomesticPet implements Comparable<DomesticPet>{
        @Override
        public int compareTo(DomesticPet o) {
            return 0;
        }
    }
}
