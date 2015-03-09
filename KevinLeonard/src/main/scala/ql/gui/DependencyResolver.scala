package ql.gui

import ql.ast._
import ql.types.Dependencies

class DependencyResolver {

  def resolve(e: Expression, d: Dependencies = List()): Dependencies = e match {
    case Or(l, r) => resolve(l, d) ++ resolve(r, d)
    case And(l, r) => resolve(l, d) ++ resolve(r, d)
    case Not(e1) => resolve(e1, d)
    case Equal(l, r) => resolve(l, d) ++ resolve(r, d)
    case NotEqual(l, r) => resolve(l, d) ++ resolve(r, d)
    case LessThan(l, r) => resolve(l, d) ++ resolve(r, d)
    case LessThanEqual(l, r) => resolve(l, d) ++ resolve(r, d)
    case GreaterThan(l, r) => resolve(l, d) ++ resolve(r, d)
    case GreaterThanEqual(l, r) => resolve(l, d) ++ resolve(r, d)
    case ql.ast.Add(l, r) => resolve(l, d) ++ resolve(r, d)
    case Sub(l, r) => resolve(l, d) ++ resolve(r, d)
    case Mul(l, r) => resolve(l, d) ++ resolve(r, d)
    case Div(l, r) => resolve(l, d) ++ resolve(r, d)
    case Variable(name) => name :: d
    case Literal(_, v) => d
  }
}
