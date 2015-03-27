package qls.interpreter

import ql.interpreter.{Interpreter => QLInterpreter}
import ql.typechecker.Error
import qls.ast.StyleSheet
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
          QLInterpreter.render(qlAst)
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

  // TODO: refactor 'returns'
  def checkTypes(ast: StyleSheet, env: TypeEnvironment): Boolean = {
    val referenceErrors = getReferenceErrors(ast, env)
    referenceErrors.foreach(println)
    if (referenceErrors.nonEmpty) return false

    val placementErrors = getPlacementErrors(ast, env)
    placementErrors.foreach(println)
    if (placementErrors.nonEmpty) return false

    val typeErrors = getTypeErrors(ast, env)
    typeErrors.foreach(println)
    if (typeErrors.nonEmpty) return false

    val duplicatePlacementErrors = getDuplicatePlacementErrors(ast)
    duplicatePlacementErrors.foreach(println)
    duplicatePlacementErrors.isEmpty
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
}
