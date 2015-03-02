package visitor

import "github.com/software-engineering-amsterdam/many-ql/carlos.cirello/qlang/interpreter/ast"

// Executer interface describe all functions necessary to iterate through AST
type Executer interface {
	QuestionaireNode(v *Visitor, q *ast.QuestionaireNode)
	ActionNode(v *Visitor, a *ast.ActionNode)
	QuestionNode(v *Visitor, q *ast.QuestionNode)
	IfNode(v *Visitor, i *ast.IfNode)
}
