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

func (vst execute) QuestionaireNode(q *ast.QuestionaireNode) {
	for _, actionNode := range q.Stack {
		vst.ActionNode(actionNode)
	}
}

func (vst execute) ActionNode(a *ast.ActionNode) {
	if nil != a.QuestionNode {
		vst.QuestionNode(a.QuestionNode)
	} else if nil != a.IfNode {
		vst.IfNode(a.IfNode)
	} else {
		log.Fatalf("Impossible ActionNode type or empty ActionNode. %#v", a)
	}
}

func (vst execute) QuestionNode(q *ast.QuestionNode) {
	vst.symbolChan <- &symbolEvent{
		command: SymbolCreate,
		name:    q.Identifier,
		content: q,
	}

	if !q.Rendered {
		questionCopy := q.Clone()
		vst.toFrontend <- &frontend.Event{
			Type:     frontend.Render,
			Question: questionCopy,
		}
		q.Rendered = true
	}
}

func (vst execute) IfNode(i *ast.IfNode) {
	ret := make(chan *ast.QuestionNode)
	vst.symbolChan <- &symbolEvent{
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
			vst.ActionNode(actionNode)
		}
	} else {
		log.Println("Please, nuke all the way down to turtles!")
	}
}
