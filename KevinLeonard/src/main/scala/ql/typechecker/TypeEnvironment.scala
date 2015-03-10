package ql.typechecker

import ql.ast.{Type, Variable}
import types.VariableName

// Holds the defined variables and their type.
// Note that we require variables to be declared before being used.
class TypeEnvironment(val env: Map[VariableName, Type] = Map()) {

  def tryGetVariable(v: Variable): Either[Error, Type] = {
    env get v.name match {
      case Some(t) => Right(t)
      case None => Left(new Error(s"Variable ${v.name} is not defined", v.pos))
    }
  }

  def tryAddVariable(v: Variable, t: Type): Either[Error, TypeEnvironment] = {
    if (env contains v.name) {
      Left(new Error(s"Variable ${v.name} is already defined", v.pos))
    } else {
      Right(new TypeEnvironment(env + (v.name -> t)))
    }
  }

  def canEqual(other: Any): Boolean = other.isInstanceOf[TypeEnvironment]

  override def equals(other: Any): Boolean = other match {
    case that: TypeEnvironment =>
      (that canEqual this) &&
        env == that.env
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(env)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}
