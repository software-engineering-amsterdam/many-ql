package ast

type DefaultNode struct {
	questionType string
	widget       string
}

func NewDefaultNode(questionType, widget string) *DefaultNode {
	return &DefaultNode{questionType, widget}
}

func (d *DefaultNode) QuestionType() string {
	return d.questionType
}

func (d *DefaultNode) Widget() string {
	return d.widget
}
