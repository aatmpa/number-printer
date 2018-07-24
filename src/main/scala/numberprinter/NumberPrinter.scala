package numberprinter

import numberprinter.Numbers._

import scala.annotation.tailrec

object NumberPrinter {

  def print(number: Long): String = {
   val blocks = toWords(to3DigitBlocks(number), List.empty)
   (blocks.reverse zip blockValues).reverse.map { case (num,block) => (num + " " + block).trim } filter(_.nonEmpty) mkString ", "
  }

  @tailrec
  def toWords(numericBlocks: => List[String], wordBlocks: List[String]): List[String] = numericBlocks match {
    case Nil => wordBlocks
    case block :: tail => toWords(tail, wordBlocks :+ numericBlockToWords(block.toList))
  }

  private def numericBlockToWords(numbers: List[Char]): String =
    numbers match {
      case Nil => ""
      case last :: Nil => oneDigitNumbers(s"$last".toInt).stringValue1
      case prev1 :: last :: Nil if s"$prev1".toInt == 1 => twoDigitNumbers(s"$prev1$last".toInt - 10).stringValue1
      case prev1 :: last :: Nil if s"$prev1".toInt != 1 => (oneDigitNumbers(s"$prev1".toInt).stringValue2 + " " + oneDigitNumbers(s"$last".toInt).stringValue1).trim
      case '0' :: tail => numericBlockToWords(tail)
      case head :: tail => (oneDigitNumbers(s"$head".toInt).stringValue1 + " hundred and ") + numericBlockToWords(tail)
    }

  private def to3DigitBlocks(number: Long) = number.toString.reverse.grouped(3).toList.reverse.map(_.reverse)
}