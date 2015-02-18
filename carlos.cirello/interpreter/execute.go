package interpreter

import (
	"fmt"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"
)

// Execute implements Executer interface, and walks through AST
type Execute struct {
	toFrontend chan *Event
	symbolChan chan *symbolEvent
}

func NewExecute(toFrontend chan *Event, symbolChan chan *symbolEvent) *Visitor {
	return &Visitor{
		&Execute{
			toFrontend: toFrontend,
			symbolChan: symbolChan,
		},
	}
}

// QuestionaireNode execute all actionNodes of a questionaire (form)
func (exec Execute) QuestionaireNode(v *Visitor, q *ast.QuestionaireNode) {
	for _, actionNode := range q.Stack() {
		v.Visit(actionNode)
	}
}

// ActionNode branches to QuestionNode or IfNode executers
func (exec Execute) ActionNode(v *Visitor, a *ast.ActionNode) {
	v.Visit(a.Action())
}

// QuestionNode adds question to symbol table, and dispatch to frontend
// rendering.
func (exec Execute) QuestionNode(v *Visitor, q *ast.QuestionNode) {
	exec.symbolChan <- &symbolEvent{
		command: SymbolCreate,
		name:    q.Identifier(),
		content: q,
	}

	if q.Type() == ast.ComputedQuestionType {
		expr := q.Content().(*ast.ComputedQuestion).Value()
		q.From(fmt.Sprintf("%f", exec.resolveMathNode(expr)))
	}

	questionCopy := q.Clone()
	exec.toFrontend <- &Event{
		Type:     Update,
		Question: questionCopy,
	}
}

// IfNode analyzes condition and run all children (ActionNodes)
func (exec Execute) IfNode(v *Visitor, i *ast.IfNode) {
	if exec.resolveComparisonNode(i.Conditions()) {
		for _, actionNode := range i.Stack() {
			v.Visit(actionNode)
		}
	} else if i.ElseNode() != nil {
		v.Visit(i.ElseNode())
	}
}
