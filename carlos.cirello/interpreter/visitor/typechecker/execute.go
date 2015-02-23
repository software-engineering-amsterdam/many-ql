package typechecker

import (
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/event"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/symboltable"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/visitor"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/visitor/execute"
)

// New is the factory for Typechecker visitor struct
func New() (*visitor.Visitor, *symboltable.SymbolTable) {
	toFrontend := make(chan *event.Frontend)
	symbolChan := make(chan *event.Symbol)
	st := symboltable.New(symbolChan)

	go func(toFrontend chan *event.Frontend) {
		for {
			<-toFrontend
		}
	}(toFrontend)

	tc := &Typechecker{
		execute: execute.NewExecute(toFrontend, symbolChan),
	}
	return visitor.NewVisitor(tc), st
}

// Typechecker is the delegation structure for Execute and typechecking visitors
type Typechecker struct {
	execute *execute.Execute
}

// QuestionaireNode execute all actionNodes of a questionaire (form)
func (tc Typechecker) QuestionaireNode(v *visitor.Visitor, q *ast.QuestionaireNode) {
	for _, actionNode := range q.Stack() {
		v.Visit(actionNode)
	}
}

// ActionNode branches to QuestionNode or IfNode executers
func (tc Typechecker) ActionNode(v *visitor.Visitor, a *ast.ActionNode) {
	tc.execute.ActionNode(v, a)
}

// QuestionNode adds question to symbol table, and dispatch to frontend
// rendering.
func (tc Typechecker) QuestionNode(v *visitor.Visitor, q *ast.QuestionNode) {
	tc.execute.QuestionNode(v, q)
}

// IfNode analyzes condition and run all children (ActionNodes)
func (tc Typechecker) IfNode(v *visitor.Visitor, i *ast.IfNode) {
	tc.execute.ResolveComparisonNode(i.Conditions())

	for _, actionNode := range i.Stack() {
		v.Visit(actionNode)
	}

	if i.ElseNode() != nil {
		v.Visit(i.ElseNode())
	}
}
