package interpreter

import ast.QLAST.Form
import evaluator.QLEvaluator
import parser.QLParser

import scala.io.Source

object QLInterpreter {
  def main(args: Array[String]) {
    val parser = new QLParser()
    val evaluator = new QLEvaluator()
    val formFile = Source.fromFile(args(0)).mkString

    parser.parseAll(parser.form, formFile) match {
      case parser.Success(ast, _) => ast match {
        case f: Form => evaluator.eval(f)
      }
      case parser.Failure(msg, next) => println("Parse failure at line " + next.pos + ": " + msg)
      case parser.Error(msg, next) => println("Parse error at line " + next.pos + ": " + msg)
    }
  }
}
