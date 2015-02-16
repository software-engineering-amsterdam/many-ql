package typechecker

import ast.QLAST

class QLTypeChecker extends QLAST{
  
    def check(expression: Expression): Literal = expression match {
      case Or(l: Expression, r: Expression) => (check(l), check(r)) match {
        case (BooleanLiteral(true), BooleanLiteral(true)) => BooleanLiteral(true)
        case _ => sys.error("Invalid OR expression.")
      }
      case And(l: Expression, r: Expression) => (check(l), check(r)) match {
        case (BooleanLiteral(true), BooleanLiteral(true)) => BooleanLiteral(true)
        case _ => sys.error("Invalid AND expression.")
      }
      case Not(e: Expression) => check(e) match {
        case BooleanLiteral(true) => BooleanLiteral(true)
        case _ => sys.error("Invalid NOT expression.")
      }
      case Equal(l: Expression, r: Expression) => (check(l), check(r)) match {
        case (BooleanLiteral(_), BooleanLiteral(_)) => BooleanLiteral(true)
        case (NumberLiteral(_), NumberLiteral(_)) => BooleanLiteral(true)
        case (StringLiteral(_), StringLiteral(_)) => BooleanLiteral(true)
        case _ => sys.error("Invalid EQUAL expression.")
      }
      case NotEqual(l: Expression, r: Expression) => (check(l), check(r)) match {
        case (BooleanLiteral(_), BooleanLiteral(_)) => BooleanLiteral(true)
        case (NumberLiteral(_), NumberLiteral(_)) => BooleanLiteral(true)
        case (StringLiteral(_), StringLiteral(_)) => BooleanLiteral(true)
        case _ => sys.error("Invalid NOT EQUAL expression.")
      }
      case LessThan(l: Expression, r: Expression) => (check(l), check(r)) match {
        case (NumberLiteral(_), NumberLiteral(_)) => BooleanLiteral(true)
        case _ => sys.error("Invalid LESS THAN expression.")
      }
      case LessThanEqual(l: Expression, r: Expression) => (check(l), check(r)) match {
        case (NumberLiteral(_), NumberLiteral(_)) => BooleanLiteral(true)
        case _ => sys.error("Invalid LESS THAN EQUAL expression.")
      }
      case GreaterThan(l: Expression, r: Expression) => (check(l), check(r)) match {
        case (NumberLiteral(_), NumberLiteral(_)) => BooleanLiteral(true)
        case _ => sys.error("Invalid GREATER THAN expression.")
      }
      case GreaterThanEqual(l: Expression, r: Expression) => (check(l), check(r)) match {
        case (NumberLiteral(_), NumberLiteral(_)) => BooleanLiteral(true)
        case _ => sys.error("Invalid GREATER THAN EQUAL expression.")
      }
      case Add(l: Expression, r: Expression) => (check(l), check(r)) match {
        case (NumberLiteral(_), NumberLiteral(_)) => BooleanLiteral(true)
        case _ => sys.error("Invalid ADD expression.")
      }
      case Sub(l: Expression, r: Expression) => (check(l), check(r)) match {
        case (NumberLiteral(_), NumberLiteral(_)) => BooleanLiteral(true)
        case _ => sys.error("Invalid SUB expression.")
      }
        
      case Mul(l: Expression, r: Expression) => (check(l), check(r)) match {
        case (NumberLiteral(_), NumberLiteral(_)) => BooleanLiteral(true)
        case _ => sys.error("Invalid MUL expression.")
      }
      case Div(l: Expression, r: Expression) => (check(l), check(r)) match {
        case (NumberLiteral(_), NumberLiteral(_)) => BooleanLiteral(true)
        case _ => sys.error("Invalid DIV expression.")
      }

      // TODO: Variable
        
      // Literals
      case BooleanLiteral(_) => BooleanLiteral(true)
      case NumberLiteral(_) => NumberLiteral(1)
      case StringLiteral(_) => StringLiteral("")
    }
    
  
}