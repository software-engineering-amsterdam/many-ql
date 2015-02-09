package ast

// Questionaire holds all questions for a particular form
type QuestionaireNode struct {
	Label string
	Stack []*QuestionNode
}
