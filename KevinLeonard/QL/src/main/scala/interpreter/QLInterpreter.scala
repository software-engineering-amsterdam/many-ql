package interpreter

import parser.QLParser

import scala.io.Source

object QLInterpreter extends QLParser {
  def main(args: Array[String]) {

    val formFile = Source.fromFile(args(0)).mkString

    parseAll(form, formFile) match {
      case Success(result, _) => println(result)
      case Failure(msg, next) => println("Parse failure at line " + next.pos + ": " + msg)
      case Error(msg, next) => println("Parse error at line " + next.pos + ": " + msg)
    }
  }
}
