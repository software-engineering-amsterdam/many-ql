package ast

// DefaultNode defines the default widget for a certain question type. One
// question type may have several defaults depending on their context, namely
// Pages and Sections.
type DefaultNode struct {
	questionType string
	widget       string
}

// NewDefaultNode is the factory for DefaultNode
func NewDefaultNode(questionType, widget string) *DefaultNode {
	return &DefaultNode{questionType, widget}
}

// QuestionType returns the basic question type string
func (d *DefaultNode) QuestionType() string {
	return d.questionType
}

// Widget returns which widget should the frontend renderer use to display a
// specific question type.
func (d *DefaultNode) Widget() string {
	return d.widget
}
