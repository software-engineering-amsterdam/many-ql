package interpreter

import (
	"log"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend"
)

func visitQuestionaire(q *ast.QuestionaireNode, toFrontend chan *frontend.Event) {
	for _, actionNode := range q.Stack {
		visitActionNode(actionNode, toFrontend)
	}
}

func visitActionNode(a *ast.ActionNode, toFrontend chan *frontend.Event) {
	if nil != a.QuestionNode {
		visitQuestionNode(a.QuestionNode, toFrontend)
	} else if nil != a.IfNode {
		visitIfNode(a.IfNode, toFrontend)
	}
}

func visitQuestionNode(q *ast.QuestionNode, toFrontend chan *frontend.Event) {
	questionCopy := q.Clone()
	toFrontend <- &frontend.Event{
		Type:     frontend.Render,
		Question: questionCopy,
	}
}

func visitIfNode(i *ast.IfNode, toFrontend chan *frontend.Event) {
	log.Println("Ignoring IfNodes for now")
}
