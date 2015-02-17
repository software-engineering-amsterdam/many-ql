package ast

// QuestionaireNode holds all questions for a particular form
type QuestionaireNode struct {
	label string
	stack []*ActionNode
}

func NewQuestionaireNode(label string, stack []*ActionNode) *QuestionaireNode {
	return &QuestionaireNode{label, stack}
}

func (q *QuestionaireNode) Label() string {
	return q.label
}

func (q *QuestionaireNode) Stack() []*ActionNode {
	return q.stack
}
