package execute

import (
	"fmt"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/event"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/visitor"
)

// Execute implements Executer interface, and it is used by Visitor to traverse
// AST
type Execute struct {
	toFrontend chan *event.Frontend
	symbolChan chan *event.Symbol
}

// New is the factory for Execute struct
func New(toFrontend chan *event.Frontend, symbolChan chan *event.Symbol) *visitor.Visitor {
	return &visitor.Visitor{
		&Execute{
			toFrontend: toFrontend,
			symbolChan: symbolChan,
		},
	}
}

// QuestionaireNode execute all actionNodes of a questionaire (form)
func (exec Execute) QuestionaireNode(v *visitor.Visitor, q *ast.QuestionaireNode) {
	for _, actionNode := range q.Stack() {
		v.Visit(actionNode)
	}
}

// ActionNode branches to QuestionNode or IfNode executers
func (exec Execute) ActionNode(v *visitor.Visitor, a *ast.ActionNode) {
	v.Visit(a.Action())
}

// QuestionNode adds question to symbol table, and dispatch to frontend
// rendering.
func (exec Execute) QuestionNode(v *visitor.Visitor, q *ast.QuestionNode) {
	exec.symbolChan <- &event.Symbol{
		Command: event.SymbolCreate,
		Name:    q.Identifier(),
		Content: q,
	}

	if q.Type() == ast.ComputedQuestionType {
		expr := q.Content().(*ast.ComputedQuestion).Value()
		q.From(fmt.Sprintf("%f", exec.resolveMathNode(expr)))
	}

	questionCopy := q.Clone()
	exec.toFrontend <- &event.Frontend{
		Type:     event.UpdateQuestion,
		Question: questionCopy,
	}
}

// IfNode analyzes condition and run all children (ActionNodes)
func (exec Execute) IfNode(v *visitor.Visitor, i *ast.IfNode) {
	if exec.resolveComparisonNode(i.Conditions()) {
		for _, actionNode := range i.Stack() {
			v.Visit(actionNode)
		}
	} else if i.ElseNode() != nil {
		v.Visit(i.ElseNode())
	}
}
