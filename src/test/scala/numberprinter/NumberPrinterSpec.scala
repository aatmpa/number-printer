package numberprinter

import org.scalatest.{Matchers, WordSpec}
import org.scalatest.prop.TableDrivenPropertyChecks._

class NumberPrinterSpec extends WordSpec with Matchers {

  "NumberPrinter" should {

    val testCases = Table[Long,String](
      ("input", "expectedOutput"),
      (0, ""),
      (1, "one"),
      (14, "fourteen"),
      (21, "twenty one"),
      (99, "ninety nine"),
      (105, "one hundred and five"),
      (3000, "three thousand"),
      (3043, "three thousand, forty three"),
      (50010, "fifty thousand, ten"),
      (50023, "fifty thousand, twenty three"),
      (102004, "one hundred and two thousand, four"),
      (56945781, "fifty six million, nine hundred and forty five thousand, seven hundred and eighty one"),
      (999999999, "nine hundred and ninety nine million, nine hundred and ninety nine thousand, nine hundred and ninety nine"),
      (9256945781l, "nine billion, two hundred and fifty six million, nine hundred and forty five thousand, seven hundred and eighty one"))

    "print correct value" in {
      forAll (testCases) { (input: Long, expectedOutput: String) =>
        NumberPrinter.print(input) shouldBe expectedOutput
      }
    }
  }
}