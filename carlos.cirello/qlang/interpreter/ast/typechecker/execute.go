package typechecker

import (
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/qlang/interpreter/ast"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/qlang/interpreter/ast/execute"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/qlang/interpreter/event"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/qlang/interpreter/symboltable"
)

// New is the factory for Typechecker visitor struct
func New() (*ast.Visitor, *symboltable.SymbolTable) {
	toFrontend := make(chan *event.Frontend)
	st := symboltable.New()

	go func(toFrontend chan *event.Frontend) {
		for {
			<-toFrontend
		}
	}(toFrontend)

	tc := &Typechecker{
		execute: execute.NewExecute(toFrontend, st),
	}
	return ast.NewVisitor(tc), st
}

// Typechecker is the delegation structure for Execute and typechecking visitors
type Typechecker struct {
	execute *execute.Execute
}

// QuestionaireNode execute all actionNodes of a questionaire (form)
func (tc Typechecker) QuestionaireNode(v *ast.Visitor, q *ast.QuestionaireNode) {
	for _, actionNode := range q.Stack() {
		v.Visit(actionNode)
	}
}

// ActionNode branches to QuestionNode or IfNode executers
func (tc Typechecker) ActionNode(v *ast.Visitor, a *ast.ActionNode) {
	tc.execute.ActionNode(v, a)
}

// QuestionNode adds question to symbol table, and dispatch to frontend
// rendering.
func (tc Typechecker) QuestionNode(v *ast.Visitor, q *ast.QuestionNode) {
	tc.execute.QuestionNode(v, q)
}

// IfNode analyzes condition and run all children (ActionNodes)
func (tc Typechecker) IfNode(v *ast.Visitor, i *ast.IfNode) {
	tc.execute.ResolveComparisonNode(i.Conditions())

	for _, actionNode := range i.Stack() {
		v.Visit(actionNode)
	}

	if i.ElseNode() != nil {
		v.Visit(i.ElseNode())
	}
}
