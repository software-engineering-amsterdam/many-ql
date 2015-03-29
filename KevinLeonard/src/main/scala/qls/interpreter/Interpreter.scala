package qls.interpreter

import ql.ast.Form
import ql.interpreter.{Interpreter => QLInterpreter}
import ql.typechecker.Error
import qls.ast.StyleSheet
import qls.gui.{StyleCascading, FormBuilder}
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
        val (qlErrors, qlWarnings, env) = QLInterpreter.checkTypes(qlAst)
        val qlsErrors = checkTypes(qlsAst, env)

        qlWarnings.foreach(println)
        if (qlErrors.isEmpty && qlsErrors.isEmpty) {
          render(qlAst, qlsAst, env)
        } else {
          qlErrors.foreach(println)
          qlsErrors.foreach(println)
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

  def checkTypes(ast: StyleSheet, env: TypeEnvironment): List[Error] = {
    val referenceErrors = getReferenceErrors(ast, env)
    val placementErrors = getPlacementErrors(ast, env)
    val typeErrors = getTypeErrors(ast, env)
    val duplicatePlacementErrors = getDuplicatePlacementErrors(ast)

    referenceErrors ++ placementErrors ++ typeErrors ++ duplicatePlacementErrors
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

  def render(qlAst: Form, qlsAst: StyleSheet, env: TypeEnvironment): Unit = {
    val styleCascading = new StyleCascading
    val formBuilder = new FormBuilder(styleCascading.cascadeStyles(s = qlsAst, typeEnv = env))

    formBuilder.build(qlAst).main(Array())
  }
}
