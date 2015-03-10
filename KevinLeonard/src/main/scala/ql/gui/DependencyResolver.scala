package ql.gui

import ql.ast._
import types.Dependencies

class DependencyResolver {

  def resolve(e: Expression, ds: Dependencies = List()): Dependencies = e match {
    case Or(lhs, rhs) => resolve(lhs, ds) ++ resolve(rhs, ds)
    case And(lhs, rhs) => resolve(lhs, ds) ++ resolve(rhs, ds)
    case Not(e1) => resolve(e1, ds)
    case Equal(lhs, rhs) => resolve(lhs, ds) ++ resolve(rhs, ds)
    case NotEqual(lhs, rhs) => resolve(lhs, ds) ++ resolve(rhs, ds)
    case LessThan(lhs, rhs) => resolve(lhs, ds) ++ resolve(rhs, ds)
    case LessThanEqual(lhs, rhs) => resolve(lhs, ds) ++ resolve(rhs, ds)
    case GreaterThan(lhs, rhs) => resolve(lhs, ds) ++ resolve(rhs, ds)
    case GreaterThanEqual(lhs, rhs) => resolve(lhs, ds) ++ resolve(rhs, ds)
    case ql.ast.Add(lhs, rhs) => resolve(lhs, ds) ++ resolve(rhs, ds)
    case Sub(lhs, rhs) => resolve(lhs, ds) ++ resolve(rhs, ds)
    case Mul(lhs, rhs) => resolve(lhs, ds) ++ resolve(rhs, ds)
    case Div(lhs, rhs) => resolve(lhs, ds) ++ resolve(rhs, ds)
    case Variable(name) => name :: ds
    case _: Literal => ds
  }
}
