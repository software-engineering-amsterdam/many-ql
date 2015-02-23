package interpreter

import ast.Form
import evaluator.Evaluator
import parser.Parser
import typechecker.TypeChecker

import scala.io.Source

object Interpreter {
  def main(args: Array[String]) {
    val parser = new Parser()
    val evaluator = new Evaluator()
    val typeChecker = new TypeChecker()
    val formFile = Source.fromFile(args(0)).mkString

    parser.parseAll(parser.form, formFile) match {
      case parser.Success(ast, _) => ast match {
        case f: Form =>
          typeChecker.check(f)
          evaluator.eval(f)
      }
      case parser.Failure(msg, next) => println("Parse failure at line " + next.pos + ": " + msg)
      case parser.Error(msg, next) => println("Parse error at line " + next.pos + ": " + msg)
    }
  }
}
