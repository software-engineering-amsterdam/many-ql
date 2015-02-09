package ast

// Questionaire holds all questions for a particular form
type Questionaire struct {
	Label     string
	Questions []*Question
}
