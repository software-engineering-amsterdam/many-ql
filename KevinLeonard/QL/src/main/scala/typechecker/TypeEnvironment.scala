package typechecker

import ast.{Type, Variable}

import scala.util.parsing.input.Position

// Holds the defined variables and their type.
// Note that we require variables to be declared before being used.
class TypeEnvironment(val typeOfFields: Map[String, Type] = Map(), val labels: List[String] = List()) {

  def tryGetVariable(v: Variable): Either[Error, Type] = {
    typeOfFields get v.name match {
      case Some(t: Type) => Right(t)
      case None => Left(new Error(Exception(), s"Variable ${v.name} is not defined", v.pos))
    }
  }

  def tryAddVariable(v: Variable, _type: Type): Either[Error, TypeEnvironment] = {
    if (typeOfFields contains v.name) {
      Left(new Error(Exception(), s"Variable ${v.name} is already defined", v.pos))
    } else {
      Right(new TypeEnvironment(typeOfFields + (v.name -> _type), labels))
    }
  }

  def tryAddLabel(label: String, p: Position): Either[Error, TypeEnvironment] = {
    if (labels contains label) {
      Left(new Error(Warning(), s"Label ${label} is already defined", p))
    } else {
      Right(new TypeEnvironment(typeOfFields, labels :+ label))
    }
  }

  override def toString = s"Environment($typeOfFields, $labels)"

  def canEqual(other: Any): Boolean = other.isInstanceOf[TypeEnvironment]

  override def equals(other: Any): Boolean = other match {
    case that: TypeEnvironment =>
      (that canEqual this) &&
        typeOfFields == that.typeOfFields &&
        labels == that.labels
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(typeOfFields, labels)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}
