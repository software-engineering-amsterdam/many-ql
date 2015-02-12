package interpreter

import (
	"log"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend"
)

type execute struct {
	toFrontend chan *frontend.Event
	symbolChan chan *symbolEvent
}

func (exec execute) Exec(node interface{}) {
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

func (exec execute) QuestionaireNode(q *ast.QuestionaireNode) {
	for _, actionNode := range q.Stack {
		exec.Exec(actionNode)
	}
}

func (exec execute) ActionNode(a *ast.ActionNode) {
	if nil != a.QuestionNode {
		exec.Exec(a.QuestionNode)
	} else if nil != a.IfNode {
		exec.Exec(a.IfNode)
	} else {
		log.Fatalf("Impossible ActionNode type or empty ActionNode. %#v", a)
	}
}

func (exec execute) QuestionNode(q *ast.QuestionNode) {
	exec.symbolChan <- &symbolEvent{
		command: SymbolCreate,
		name:    q.Identifier,
		content: q,
	}

	if !q.Rendered {
		questionCopy := q.Clone()
		exec.toFrontend <- &frontend.Event{
			Type:     frontend.Render,
			Question: questionCopy,
		}
		q.Rendered = true
	}
}

func (exec execute) IfNode(i *ast.IfNode) {
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
	} else {
		log.Println("Please, nuke all the way down to turtles!")
	}
}
