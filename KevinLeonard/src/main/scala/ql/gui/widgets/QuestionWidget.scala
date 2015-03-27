package ql.gui.widgets

import ql.ast.{BooleanValue, Expression, Question, Value}
import ql.evaluator.Evaluator
import ql.gui.DependencyResolver
import types.{Dependencies, EvalEnvironment, VariableName}

import scalafx.collections.ObservableMap.{Replace, Add}
import scalafx.geometry.Insets
import scalafx.scene.control.Label
import scalafx.scene.layout.VBox

abstract class QuestionWidget(q: Question, visibilityExpressions: List[Expression], env: EvalEnvironment) extends VBox {

  // Constants
  val DefaultPadding: Int = 0
  val PaddingBottom: Int = 10
  val DefaultMargin: Int = 0
  val MarginBottom: Int = 10
  val InvalidStyle = "-fx-background-color: -fx-focus-color," +
    "linear-gradient(from 0px 0px to 0px 5px, derive(-fx-control-inner-background, -9%)," +
    "-fx-control-inner-background); -fx-focus-color: red;"
  val ValidStyle = "-fx-focus-color: dodgerblue;"

  // Fields
  val evaluator = new Evaluator()
  val dependencyResolver = new DependencyResolver()
  val valueDependencies: Dependencies = q.expression.fold[Dependencies](List())(e => dependencyResolver.resolve(e))
  val visibilityDependencies: Dependencies = visibilityExpressions.flatMap(e => dependencyResolver.resolve(e))
  val label = Label(q.label)

  // Initialize VBox and Label properties
  visible = shouldBeVisible
  managed = isVisible
  padding = Insets(DefaultPadding, DefaultPadding, PaddingBottom, DefaultPadding)
  label.margin = Insets(DefaultMargin, DefaultMargin, MarginBottom, DefaultMargin)
  children.add(label)

  // Observer for environment
  env.onChange((map, change) => change match {
    case Add(addedName, _) => updateProperties(addedName)
    case Replace(replacedName, _, _) => updateProperties(replacedName)
  })

  // Methods
  def updateEnvironment(newValue: Value): Unit = env += (q.variable.name -> newValue)

  def updateProperties(updatedVariable: VariableName): Unit = {
    val becameVisible = updateVisibility(updatedVariable)
    if (isVisible) {
      updateValue(updatedVariable, becameVisible)
    }
  }

  def updateVisibility(updatedVariable: VariableName): Boolean = {
    val wasVisible = isVisible
    if (visibilityDependencies contains updatedVariable) {
      visible = shouldBeVisible
      managed = isVisible
    }
    !wasVisible && isVisible
  }

  def updateValue(updatedVariable: VariableName, becameVisible: Boolean): Unit

  def isVisible: Boolean = visible.value

  def shouldBeVisible: Boolean = visibilityExpressions.forall(evaluatesToTrue)

  def evaluatesToTrue(e: Expression): Boolean = evaluator.eval(e, env) match {
    case BooleanValue(b) => b
    case _ => false
  }

  def isQuestionWithSameKey(updatedVariable: VariableName): Boolean = updatedVariable == q.variable.name
}
