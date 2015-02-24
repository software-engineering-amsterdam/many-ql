package typechecker

import ast.{UndefinedType, Question, Type, Variable}

import scala.util.parsing.input.Position

// Holds the defined variables and their type.
// Note that we require variables to be declared before being used.
class TypeEnvironment(val typeOfFields: Map[String, Type] = Map(), val labels: List[String] = List(), val errors: List[Error] = List()) {

  // TODO: Return Environment.
  def tryGetVariable(v: Variable): Type = {
    typeOfFields get v.name match {
      case Some(t: Type) => t
      case None => {
        this.addError(Exception(), s"Variable ${v.name} is not defined", v.pos);
        UndefinedType()
      }
    }
  }

  def tryAddVariable(v: Variable, _type: Type): TypeEnvironment = {
    if (typeOfFields contains v.name) {
      this.addError(Exception(), s"Variable ${v.name} is already defined", v.pos)
    } else {
      new TypeEnvironment(typeOfFields + (v.name -> _type), labels, errors)
    }
  }

  def tryAddLabel(label: String, p: Position): TypeEnvironment = {
    if (labels contains label) {
      this.addError(Warning(), s"Label ${label} is already defined", p)
    } else {
      new TypeEnvironment(typeOfFields, labels :+ label, errors)
    }
  }

  def addError(level: Level, message: String, position: Position): TypeEnvironment = {
    new TypeEnvironment(typeOfFields, labels, errors :+ new Error(level, message, position))
  }

  def canEqual(other: Any): Boolean = other.isInstanceOf[TypeEnvironment]

  override def equals(other: Any): Boolean = other match {
    case that: TypeEnvironment =>
      (that canEqual this) &&
        typeOfFields == that.typeOfFields &&
        labels == that.labels &&
        errors == that.errors
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(typeOfFields, labels, errors)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }

  override def toString = s"Environment($typeOfFields, $labels, $errors)"
}
