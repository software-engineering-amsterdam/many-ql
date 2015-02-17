package typechecker

import ast.QLAST

class QLTypeChecker extends {
    import QLAST._

    //type Variables = List[String]
  
    var warnings: Set[String] = Set()
    var errors: Set[String] = Set()
    var questionsList: List[Question] = List()
    
    def isDuplicateQuestionVariable(questionList: List[Question], question: Question): Boolean = questionList.exists(q => q.v == question.v)

    def isDuplicateQuestionLabel(questionList: List[Question], question: Question): Boolean = questionList.exists(q => q.label == question.label)

    def addQuestion(question: Question) = questionsList = questionsList :+ question
  
    def checkQuestion(question: Question) = {
      if (isDuplicateQuestionVariable(questionsList, question)) errors += (s"Error: Duplicate question key: ${question.v.name}")
      if (isDuplicateQuestionLabel(questionsList, question)) warnings += (s"Warning: Duplicate question label: ${question.label}")
      addQuestion(question)
    }

    //def check(form: Form, vars: Variables = List()) = check(form.e, vars)
  
    // TODO: Add Tests
    def check(statement: Statement): Literal = statement match {
      case question @ BooleanQuestion(v: Variable, label: String) => checkQuestion(question); BooleanLiteral(true)
      case question @ IntegerQuestion(v: Variable, label: String) => checkQuestion(question); BooleanLiteral(true)
      case question @ StringQuestion(v: Variable, label: String) => checkQuestion(question); BooleanLiteral(true)
      case question @ ComputedBooleanQuestion(v: Variable, label: String, e: Expression) => checkQuestion(question); check(e) match {
        case BooleanLiteral(true) => BooleanLiteral(true)
        case _ => sys.error("Invalid expression for computed boolean expression")
      }
      case question @ ComputedIntegerQuestion(v: Variable, label: String, e: Expression) => checkQuestion(question); check(e) match {
        case BooleanLiteral(true) => BooleanLiteral(true)
        case _ => sys.error("Invalid expression for computed integer expression")
      }
      case question @ ComputedStringQuestion(v: Variable, label: String, e: Expression) => checkQuestion(question); check(e) match {
        case BooleanLiteral(true) => BooleanLiteral(true)
        case _ => sys.error("Invalid expression for computed string expression")
      }
    }
  
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

      case BooleanLiteral(_) => BooleanLiteral(true)
      case NumberLiteral(_) => NumberLiteral(1)
      case StringLiteral(_) => StringLiteral("")

    }
}