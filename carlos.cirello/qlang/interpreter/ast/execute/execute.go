package execute

import (
	"fmt"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/qlang/interpreter/ast"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/qlang/interpreter/event"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/qlang/interpreter/symboltable"
)

// Execute implements Executer interface, and it is used by Visitor to traverse
// AST
type Execute struct {
	toFrontend  chan *event.Frontend
	symboltable *symboltable.SymbolTable
}

// NewExecute is the factory for Execute struct tree
func NewExecute(toFrontend chan *event.Frontend, symboltable *symboltable.SymbolTable) *Execute {
	return &Execute{
		toFrontend:  toFrontend,
		symboltable: symboltable,
	}
}

// New is the factory for a ast.Visitor with Execute struct tree inside
func New(toFrontend chan *event.Frontend, symboltable *symboltable.SymbolTable) *ast.Visitor {
	return ast.NewVisitor(NewExecute(toFrontend, symboltable))
}

// QuestionaireNode execute all actionNodes of a questionaire (form)
func (exec Execute) QuestionaireNode(v *ast.Visitor, q *ast.QuestionaireNode) {
	for _, actionNode := range q.Stack() {
		v.Visit(actionNode)
	}
}

// ActionNode branches to QuestionNode or IfNode executers
func (exec Execute) ActionNode(v *ast.Visitor, a *ast.ActionNode) {
	v.Visit(a.Action())
}

// QuestionNode adds question to symbol table, and dispatch to frontend
// rendering.
func (exec Execute) QuestionNode(v *ast.Visitor, q *ast.QuestionNode) {
	exec.symboltable.Create(q.Identifier(), q.Label(), q.Type())

	r := exec.symboltable.Read(q.Identifier())

	if q.Type() == ast.ComputedQuestionType {
		expr := q.Content().(*ast.ComputedQuestion).Expression()
		computed := fmt.Sprintf("%f", exec.resolveMathNode(expr))
		r.(symboltable.StringParser).From(computed)
	}

	exec.toFrontend <- &event.Frontend{
		Type:       event.UpdateQuestion,
		Identifier: q.Identifier(),
		Label:      q.Label(),
		FieldType:  q.Type(),
		Value:      r.(fmt.Stringer).String(),
	}
}

// IfNode analyzes condition and run all children (ActionNodes)
func (exec Execute) IfNode(v *ast.Visitor, i *ast.IfNode) {
	if exec.ResolveComparisonNode(i.Conditions()) {
		for _, actionNode := range i.Stack() {
			v.Visit(actionNode)
		}
	} else if i.ElseNode() != nil {
		v.Visit(i.ElseNode())
	}
}
