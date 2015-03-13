package ast

import "text/scanner"

// QuestionaireNode holds all questions for a particular form
type QuestionaireNode struct {
	label string
	stack []*ActionNode
	pos   scanner.Position
}

// NewQuestionaireNode factory for QuestionaireNode struct
func NewQuestionaireNode(label string, stack []*ActionNode,
	pos scanner.Position) *QuestionaireNode {
	return &QuestionaireNode{label, stack, pos}
}

// Label getter method for label property
func (q *QuestionaireNode) Label() string {
	return q.label
}

// Stack getter method for stack property
func (q *QuestionaireNode) Stack() []*ActionNode {
	return q.stack
}

func DelegateQuestionaireNodeExecution(e Executer, q *QuestionaireNode) {
	for _, actionNode := range q.Stack() {
		e.ActionNode(actionNode)
	}
}
