package qls.interpreter

import ql.ast.Form
import ql.interpreter.{Interpreter => QLInterpreter}
import ql.typechecker.Error
import qls.ast.StyleSheet
import qls.gui.FormBuilder
import qls.parser.Parser
import qls.typechecker.{DuplicatePlacementChecker, QuestionPlacementChecker, ReferenceChecker, TypeChecker}
import types.TypeEnvironment

import scala.io.Source

object Interpreter {

  def main(args: Array[String]) {
    val qlSource = Source.fromFile(args(0)).mkString
    val qlsSource = Source.fromFile(args(1)).mkString

    val optionalQlAst = QLInterpreter.parse(qlSource)
    val optionalQlsAst = parse(qlsSource)

    (optionalQlAst, optionalQlsAst) match {
      case (Some(qlAst), Some(qlsAst)) =>
        val (qlTypeChecks, env) = QLInterpreter.checkTypes(qlAst)
        val qlsTypeChecks = checkTypes(qlsAst, env)

        if (qlTypeChecks && qlsTypeChecks) {
          render(qlAst, qlsAst)
        }
      case _ => ()
    }
  }

  def parse(source: String): Option[StyleSheet] = {
    val parser = new Parser()

    parser.parseAll(parser.styleSheet, source) match {
      case parser.Success(ast: StyleSheet, _) => Some(ast)
      case parser.Failure(msg, next) => println("Parse failure at line " + next.pos + ": " + msg); None
      case parser.Error(msg, next) => println("Parse error at line " + next.pos + ": " + msg); None
    }
  }

  // TODO: Show errors in GUI instead of console? This function does now two things.
  // TODO: 1) Checking for errors & 2) Printing errors.
  def checkTypes(ast: StyleSheet, env: TypeEnvironment): Boolean = {
    val referenceErrors = getReferenceErrors(ast, env)
    val placementErrors = getPlacementErrors(ast, env)
    val typeErrors = getTypeErrors(ast, env)
    val duplicatePlacementErrors = getDuplicatePlacementErrors(ast)

    val errors = referenceErrors ++ placementErrors ++ typeErrors ++ duplicatePlacementErrors
    errors.foreach(println)
    errors.isEmpty
  }

  def getReferenceErrors(ast: StyleSheet, env: TypeEnvironment): List[Error] = {
    val referenceChecker = new ReferenceChecker()
    referenceChecker.check(ast, env)
  }

  def getPlacementErrors(ast: StyleSheet, env: TypeEnvironment): Option[Error] = {
    val questionPlacementChecker = new QuestionPlacementChecker()
    questionPlacementChecker.check(ast, env)
  }

  def getTypeErrors(ast: StyleSheet, env: TypeEnvironment): List[Error] = {
    val typeChecker = new TypeChecker()
    typeChecker.check(ast, env)
  }

  def getDuplicatePlacementErrors(ast: StyleSheet): List[Error] = {
    val duplicatePlacementChecker = new DuplicatePlacementChecker()
    duplicatePlacementChecker.check(ast)
  }

  def render(ast: Form, stylesheet: StyleSheet): Unit = {
    // TODO: Style cascading
    val formBuilder = new FormBuilder(stylesheet)

    formBuilder.build(ast).main(Array())
  }
}
