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
