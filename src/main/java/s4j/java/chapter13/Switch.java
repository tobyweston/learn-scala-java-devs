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

public class Switch {
    public static void main(String... args) {
        String month = "August";
        String quarter;
        switch (month) {
            case "January":
            case "February":
            case "March":
                quarter = "1st quarter";
                break;
            case "April":
            case "May":
            case "June":
                quarter = "2nd quarter";
                break;
            case "July":
            case "August":
            case "September":
                quarter = "3rd quarter";
                break;
            case "October":
            case "November":
            case "December":
                quarter = "4th quarter";
                break;
            default:
                quarter = "unknown quarter";
                break;
        }
        System.out.println(quarter);
    }

}
