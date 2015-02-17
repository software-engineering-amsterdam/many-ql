package typechecker

import ast.QLAST

class QLTypeChecker extends {
    import QLAST._

    type Environment = Map[String, Literal]
    val emptyEnvironment = Map[String, Literal]()

    val defaultBooleanValue = BooleanLiteral(false)
    val defaultNumberValue = NumberLiteral(0)
    val defaultStringValue = StringLiteral("")
  
  
//    var warnings: Set[String] = Set()
//    var errors: Set[String] = Set()
//    var questionsList: List[Question] = List()
//
//    def isDuplicateQuestionVariable(questionList: List[Question], question: Question): Boolean = questionList.exists(q => q.v == question.v)
//
//    def isDuplicateQuestionLabel(questionList: List[Question], question: Question): Boolean = questionList.exists(q => q.label == question.label)
//
//    def addQuestion(question: Question) = questionsList = questionsList :+ question
//
//    def checkQuestion(question: Question) = {
//      if (isDuplicateQuestionVariable(questionsList, question)) errors += (s"Error: Duplicate question key: ${question.v.name}")
//      if (isDuplicateQuestionLabel(questionsList, question)) warnings += (s"Warning: Duplicate question label: ${question.label}")
//      addQuestion(question)
//    }

    //def check(form: Form, vars: Variables = List()) = check(form.e, vars)
  
    
    def check(form: Form, env: Environment): Environment = check(form.e, env)
  
    def check(statement: Statement, env: Environment): Environment = statement match {
      case Sequence(statements: List[Statement]) => statements.foldLeft(env) { (env, statement) => check(statement, env) }
      case IfStatement(e: Expression, s1: Statement, None) => check(e, env) match {
        case BooleanLiteral(_) =>
          check(s1, env)
          env // Return environment without the questions in s1.
        case _ => sys.error("Invalid boolean condition")
      }
      case IfStatement(e: Expression, s1: Statement, Some(s2: Statement)) => check(e, env) match {
        case BooleanLiteral(_) =>
          check(s1, env)
          check(s2, env)
          env // Return environment without the questions in s1 and s2.
        case _ => sys.error("Invalid boolean condition")
      }
      case BooleanQuestion(v: Variable, label: String) => env + (v.name -> defaultBooleanValue)
      case NumberQuestion(v: Variable, label: String) => env + (v.name -> defaultNumberValue)
      case StringQuestion(v: Variable, label: String) => env + (v.name -> defaultStringValue)
      case ComputedBooleanQuestion(v: Variable, label: String, e: Expression) => check(e, env) match {
        case BooleanLiteral(_) => env + (v.name -> defaultBooleanValue)
        case _ => sys.error("Invalid expression for computed boolean expression")
      }
      case ComputedNumberQuestion(v: Variable, label: String, e: Expression) => check(e, env) match {
        case NumberLiteral(_) => env + (v.name -> defaultNumberValue)
        case _ => sys.error("Invalid expression for computed number expression")
      }
      case ComputedStringQuestion(v: Variable, label: String, e: Expression) => check(e, env) match {
        case StringLiteral(_) => env + (v.name -> defaultStringValue)
        case _ => sys.error("Invalid expression for computed string expression")
      }
    }
  
    def check(expression: Expression, env: Environment): Literal = expression match {
      case Or(l: Expression, r: Expression) => (check(l, env), check(r, env)) match {
        case (BooleanLiteral(_), BooleanLiteral(_)) => defaultBooleanValue
        case _ => sys.error("Invalid OR expression.")
      }
      case And(l: Expression, r: Expression) => (check(l, env), check(r, env)) match {
        case (BooleanLiteral(_), BooleanLiteral(_)) => defaultBooleanValue
        case _ => sys.error("Invalid AND expression.")
      }
      case Not(e: Expression) => check(e, env) match {
        case BooleanLiteral(_) => defaultBooleanValue
        case _ => sys.error("Invalid NOT expression.")
      }
      case Equal(l: Expression, r: Expression) => (check(l, env), check(r, env)) match {
        case (BooleanLiteral(_), BooleanLiteral(_)) => defaultBooleanValue
        case (NumberLiteral(_), NumberLiteral(_)) => defaultBooleanValue
        case (StringLiteral(_), StringLiteral(_)) => defaultBooleanValue
        case _ => sys.error("Invalid EQUAL expression.")
      }
      case NotEqual(l: Expression, r: Expression) => (check(l, env), check(r, env)) match {
        case (BooleanLiteral(_), BooleanLiteral(_)) => defaultBooleanValue
        case (NumberLiteral(_), NumberLiteral(_)) => defaultBooleanValue
        case (StringLiteral(_), StringLiteral(_)) => defaultBooleanValue
        case _ => sys.error("Invalid NOT EQUAL expression.")
      }
      case LessThan(l: Expression, r: Expression) => (check(l, env), check(r, env)) match {
        case (NumberLiteral(_), NumberLiteral(_)) => defaultBooleanValue
        case _ => sys.error("Invalid LESS THAN expression.")
      }
      case LessThanEqual(l: Expression, r: Expression) => (check(l, env), check(r, env)) match {
        case (NumberLiteral(_), NumberLiteral(_)) => defaultBooleanValue
        case _ => sys.error("Invalid LESS THAN EQUAL expression.")
      }
      case GreaterThan(l: Expression, r: Expression) => (check(l, env), check(r, env)) match {
        case (NumberLiteral(_), NumberLiteral(_)) => defaultBooleanValue
        case _ => sys.error("Invalid GREATER THAN expression.")
      }
      case GreaterThanEqual(l: Expression, r: Expression) => (check(l, env), check(r, env)) match {
        case (NumberLiteral(_), NumberLiteral(_)) => defaultBooleanValue
        case _ => sys.error("Invalid GREATER THAN EQUAL expression.")
      }
      case Add(l: Expression, r: Expression) => (check(l, env), check(r, env)) match {
        case (NumberLiteral(_), NumberLiteral(_)) => defaultBooleanValue
        case _ => sys.error("Invalid ADD expression.")
      }
      case Sub(l: Expression, r: Expression) => (check(l, env), check(r, env)) match {
        case (NumberLiteral(_), NumberLiteral(_)) => defaultBooleanValue
        case _ => sys.error("Invalid SUB expression.")
      }
        
      case Mul(l: Expression, r: Expression) => (check(l, env), check(r, env)) match {
        case (NumberLiteral(_), NumberLiteral(_)) => defaultBooleanValue
        case _ => sys.error("Invalid MUL expression.")
      }
      case Div(l: Expression, r: Expression) => (check(l, env), check(r, env)) match {
        case (NumberLiteral(_), NumberLiteral(_)) => defaultBooleanValue
        case _ => sys.error("Invalid DIV expression.")
      }
      case Variable(name: String) => env getOrElse(name, sys.error(s"Undefined variable: $name"))
      case BooleanLiteral(_) => defaultBooleanValue
      case NumberLiteral(_) => defaultNumberValue
      case StringLiteral(_) => defaultStringValue
    }
}