package qls.interpreter

import ql.ast.Form
import ql.gui.FormBuilder
import ql.parser.{Parser => QLParser}
import ql.typechecker.{TypeChecker => QLTypeChecker, TypeEnvironment, DuplicateLabelsChecker}
import qls.ast.Section
import qls.parser.{Parser => QLSParser}
import qls.typechecker.{ReferenceChecker => QLSTypeChecker}

import scala.io.Source

object Interpreter {

  val qlParser = new QLParser()
  val qlsParser = new QLSParser()
  val qlTypeChecker = new QLTypeChecker()
  val qlsTypeChecker = new QLSTypeChecker()
  val duplicateLabelsChecker = new DuplicateLabelsChecker()
  val formBuilder = new FormBuilder()

  def main(args: Array[String]) {
    val qlSource = Source.fromFile(args(0)).mkString
    val qlsSource = Source.fromFile(args(1)).mkString

    qlParser.parseAll[Form](qlParser.form, qlSource) match {
      case qlParser.Success(ast: Form, _) =>
        qlsParser.parseAll(qlsParser.section, qlsSource)
        val typeCheckErrors = qlTypeChecker.check(ast)
        typeCheckErrors.foreach(println)
        duplicateLabelsChecker.check(ast).foreach(println)
        if (typeCheckErrors.isEmpty) {
          formBuilder.build(ast).main(Array())
        }
      case qlParser.Failure(msg, next) => println("Parse failure at line " + next.pos + ": " + msg)
      case qlParser.Error(msg, next) => println("Parse error at line " + next.pos + ": " + msg)
    }
  }

  // TODO: probably this method should be in the QL Interpreter
  def parseQL(qlSource: String, qlsSource: String): Unit = {
    qlParser.parseAll[Form](qlParser.form, qlSource) match {
      case qlParser.Success(ast: Form, _) => parseQLS(qlsSource, ast)
      case qlParser.Failure(msg, next) => println("Parse failure at line " + next.pos + ": " + msg)
      case qlParser.Error(msg, next) => println("Parse error at line " + next.pos + ": " + msg)
    }
  }

  def parseQLS(qlsSource: String, qlAst: Form): Unit = {
    qlsParser.parseAll(qlsParser.section, qlsSource) match {
      case qlsParser.Success(ast: Section, _) => typeCheckQL(qlAst, ast)
      case qlsParser.Failure(msg, next) => println("Parse failure at line " + next.pos + ": " + msg)
      case qlsParser.Error(msg, next) => println("Parse error at line " + next.pos + ": " + msg)
    }
  }

  // TODO: probably this method should be in the QL Interpreter
  def typeCheckQL(qlAst: Form, qlsAst: Section) : Unit = {
    val typeCheckErrors = qlTypeChecker.check(qlAst)
    typeCheckErrors.foreach(println)
    duplicateLabelsChecker.check(qlAst).foreach(println)
    typeCheckQLS(qlsAst)
    if (typeCheckErrors.isEmpty) {
      buildFormQL(qlAst)
    }
  }

  def typeCheckQLS(qlsAst: Section) : Unit = {
    val typeCheckErrors = qlsTypeChecker.check(qlsAst, new TypeEnvironment())
    typeCheckErrors.foreach(println)
  }

  // TODO: probably this method should be in the QL Interpreter
  def buildFormQL(qlAst: Form) : Unit = {
    formBuilder.build(qlAst).main(Array())
  }
}
