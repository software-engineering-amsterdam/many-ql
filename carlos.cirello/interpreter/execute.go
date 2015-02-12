package interpreter

import (
	"log"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"
)

type Execute struct {
	toFrontend chan *Event
	symbolChan chan *symbolEvent
}

func (exec Execute) Exec(node interface{}) {
	switch t := node.(type) {
	default:
		log.Fatalf("unexpected execution node type. got: %T", t)
	case *ast.QuestionaireNode:
		exec.QuestionaireNode(node.(*ast.QuestionaireNode))
	case *ast.ActionNode:
		exec.ActionNode(node.(*ast.ActionNode))
	case *ast.QuestionNode:
		exec.QuestionNode(node.(*ast.QuestionNode))
	case *ast.IfNode:
		exec.IfNode(node.(*ast.IfNode))
	}
}

func (exec Execute) QuestionaireNode(q *ast.QuestionaireNode) {
	for _, actionNode := range q.Stack {
		exec.Exec(actionNode)
	}
}

func (exec Execute) ActionNode(a *ast.ActionNode) {
	if nil != a.QuestionNode {
		exec.Exec(a.QuestionNode)
	} else if nil != a.IfNode {
		exec.Exec(a.IfNode)
	} else {
		log.Fatalf("Impossible ActionNode type or empty ActionNode. %#v", a)
	}
}

func (exec Execute) QuestionNode(q *ast.QuestionNode) {
	exec.symbolChan <- &symbolEvent{
		command: SymbolCreate,
		name:    q.Identifier,
		content: q,
	}

	questionCopy := q.Clone()
	exec.toFrontend <- &Event{
		Type:     Render,
		Question: questionCopy,
	}
}

func (exec Execute) IfNode(i *ast.IfNode) {
	ret := make(chan *ast.QuestionNode)
	exec.symbolChan <- &symbolEvent{
		command: SymbolRead,
		name:    i.Condition,
		ret:     ret,
	}

	q := <-ret
	if q.Type() != "bool" {
		log.Fatalf("Error parsing expression: %s. Not a boolean value", i.Condition)
	}

	content := q.Content.(*ast.BoolQuestion)
	if content.Value() {
		for _, actionNode := range i.Stack {
			exec.Exec(actionNode)
		}
	}
}
