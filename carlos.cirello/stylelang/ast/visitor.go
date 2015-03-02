package ast

// Visitor is the data structure which converts QLS AST into a set of hash maps
// used by the GUI frontend.
type Visitor struct {
	defaults map[string]string
	visible  map[string]bool
}

// NewVisitor is the constructor for QLS Visitor
func NewVisitor() *Visitor {
	return &Visitor{
		defaults: make(map[string]string),
		visible:  make(map[string]bool),
	}
}

// Defaults returns the processed hashmap of default widgets for each question
// type.
func (v *Visitor) Defaults() map[string]string {
	return v.defaults
}

// Visit is the Visitor pattern implementation
func (v *Visitor) Visit(node Acceptable) {
	node.Accept(v)
}

// StyleNode is the root node for QLS trees
func (v *Visitor) StyleNode(node *StyleNode) {
	if node != nil {
		actions := node.Stack()
		for _, action := range actions {
			v.Visit(action)
		}
	}
}

// ActionNode represents the ambiguous node which define page, section or
// default
func (v *Visitor) ActionNode(node *ActionNode) {
	v.Visit(node.Action().(Acceptable))
}

// DefaultNode defines a default widget for a question type
func (v *Visitor) DefaultNode(node *DefaultNode) {
	v.setDefaultFor(node.QuestionType(), node.Widget())
}

// QuestionNode defines a default widget for a question type
func (v *Visitor) QuestionNode(node *QuestionNode) {
	// todo(carlos): should there be an option for hidden field?
	v.setVisibleFor(node.Identifier())
}
