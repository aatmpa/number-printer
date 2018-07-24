package numberprinter

object Numbers {

  case class Number(value: Long, stringValue1: String, stringValue2: String = "")

  val oneDigitNumbers = Seq(
    Number(0, ""),
    Number(1, "one", "ten"),
    Number(2, "two", "twenty"),
    Number(3, "three", "thirty"),
    Number(4, "four", "forty"),
    Number(5, "five", "fifty"),
    Number(6, "six", "sixty"),
    Number(7, "seven", "seventy"),
    Number(8, "eight", "eighty"),
    Number(9, "nine", "ninety"))

  val twoDigitNumbers = Seq(
    Number(10, "ten"),
    Number(11, "eleven"),
    Number(12, "twelve"),
    Number(13, "thirteen"),
    Number(14, "fourteen"),
    Number(15, "fifteen"),
    Number(16, "sixteen"),
    Number(17, "seventeen"),
    Number(18, "eighteen"),
    Number(19, "nineteen"))

  val blockValues: Seq[String] = Seq(
    "",
    "thousand",
    "million",
    "billion")
}
