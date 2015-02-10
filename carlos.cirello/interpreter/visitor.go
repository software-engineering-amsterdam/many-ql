package interpreter

import (
	"log"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend"
)

type visitor struct {
	toFrontend chan *frontend.Event
}

func (vst visitor) QuestionaireNode(q *ast.QuestionaireNode) {
	for _, actionNode := range q.Stack {
		vst.ActionNode(actionNode)
	}
}

func (vst visitor) ActionNode(a *ast.ActionNode) {
	if nil != a.QuestionNode {
		vst.QuestionNode(a.QuestionNode)
	} else if nil != a.IfNode {
		vst.IfNode(a.IfNode)
	} else {
		log.Panicf("Impossible ActionNode type or empty ActionNode. %#v", a)
	}
}

func (vst visitor) QuestionNode(q *ast.QuestionNode) {
	questionCopy := q.Clone()
	vst.toFrontend <- &frontend.Event{
		Type:     frontend.Render,
		Question: questionCopy,
	}
}

func (vst visitor) IfNode(i *ast.IfNode) {
	log.Println("Ignoring IfNodes for now")
}
