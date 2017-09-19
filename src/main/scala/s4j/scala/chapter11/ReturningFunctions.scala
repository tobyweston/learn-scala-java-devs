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

package s4j.scala.chapter11

object ReturningFunctions {

  // first order function (a.k.a not a higher order function)
  def dollarTo(currency: String, dollar: Double): Double = {
    if (currency == "GBP") dollar * 0.76
    else if (currency == "EUR") dollar * 0.83
    else dollar
  }

  // higher order function
  def dollarTo(currency: String): Double => Double = {
    if (currency == "GBP") dollar => dollar * 0.76
    else if (currency == "EUR") dollar => dollar * 0.83
    else dollar => dollar
  }

  // rather than tie yourself into this
  def calculateTicketPrice(targetCurrency: String) = {
    dollarTo(targetCurrency, 199.99)
    // ...
  }

  // do this
  def calculateTicketPrice(currencyConversion: Double => Double) = {
    currencyConversion(199.99)
    // ...
  }

  calculateTicketPrice(dollarTo("GBP"))
  calculateTicketPrice(yahooFxRateFor("GBP"))
  calculateTicketPrice(historicalRateFor("GBP"))


  def yahooFxRateFor(currency: String): Double => Double = {
    // imagine this goes off to Yahoo for an FX rate
    ???
  }

  def historicalRateFor(currency: String): Double => Double = {
    // imagine this goes and gets historical rates and gets an
    // average for, lets say, a week
    ???
  }

}
