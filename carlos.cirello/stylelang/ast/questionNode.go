package ast

// QuestionNode defines that a question must be visible in a scope.
type QuestionNode struct {
	identifier string
}

// NewQuestionNode is the factory for QuestionNode
func NewQuestionNode(identifier string) *QuestionNode {
	return &QuestionNode{identifier}
}

// Identifier returns which symbol table identifier which the frontend
// renderer must use to display a specific question.
func (d *QuestionNode) Identifier() string {
	return d.identifier
}
