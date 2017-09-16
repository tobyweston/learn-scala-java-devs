package s4j.scala.chapter13

object BrokenSwitch extends App {

  val month = "August"
  var quarter = "???"
  month match {
    case "January"   =>
    case "February"  =>
    case "March"     => quarter = "1st quarter"
    case "April"     =>
    case "May"       =>
    case "June"      => quarter = "2nd quarter"
    case "July"      =>
    case "August"    =>
    case "September" => quarter = "3rd quarter"
    case "October"   =>
    case "November"  =>
    case "December"  => quarter = "4th quarter"
    case _           => quarter = "unknown quarter"
  }
  System.out.println(month + " is " + quarter)
}

object Switch extends App {
  val month = "August"
  var quarter = "???"

  month match {
    case "January"   => quarter = "1st quarter"
    case "February"  => quarter = "1st quarter"
    case "March"     => quarter = "1st quarter"
    case "April"     => quarter = "2nd quarter"
    case "May"       => quarter = "2nd quarter"
    case "June"      => quarter = "2nd quarter"
    case "July"      => quarter = "3nd quarter"
    case "August"    => quarter = "3rd quarter"
    case "September" => quarter = "3rd quarter"
    case "October"   => quarter = "4th quarter"
    case "November"  => quarter = "4th quarter"
    case "December"  => quarter = "4th quarter"
    case _           => quarter = "unknown quarter"
  }
  println(month + " is " + quarter)
}

object SwitchWithLessDuplication extends App {
  val month = "August"
  var quarter = "???"
  month match {
    case "January" | "February" | "March"    => quarter = "1st quarter"
    case "April" | "May" | "June"            => quarter = "2nd quarter"
    case "July" | "August" | "September"     => quarter = "3rd quarter"
    case "October" | "November" | "December" => quarter = "4th quarter"
    case _                                   => quarter = "unknown quarter"
  }
  println(month + " is " + quarter)
}

object SwitchExpression extends App {
  val month = "August"
  val quarter = month match {
    case "January" | "February" | "March"    => "1st quarter"
    case "April" | "May" | "June"            => "2nd quarter"
    case "July" | "August" | "September"     => "3rd quarter"
    case "October" | "November" | "December" => "4th quarter"
    case _                                   => "unknown quarter"
  }
  println(month + " is " + quarter)
}

object SwitchExpressionInLine extends App {
  val month = "August"
  println(month + " is " + (month match {
    case "January" | "February" | "March"    => "1st quarter"
    case "April" | "May" | "June"            => "2nd quarter"
    case "July" | "August" | "September"     => "3rd quarter"
    case "October" | "November" | "December" => "4th quarter"
    case _                                   => "unknown quarter"
  }))
}
