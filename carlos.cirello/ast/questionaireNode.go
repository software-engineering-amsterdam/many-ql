package ast

import "text/scanner"

// QuestionaireNode holds all questions for a particular form
type QuestionaireNode struct {
	label string
	stack []*ActionNode
	pos   scanner.Position
}

func NewQuestionaireNode(label string, stack []*ActionNode,
	pos scanner.Position) *QuestionaireNode {
	return &QuestionaireNode{label, stack, pos}
}

func (q *QuestionaireNode) Label() string {
	return q.label
}

func (q *QuestionaireNode) Stack() []*ActionNode {
	return q.stack
}
