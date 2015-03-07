package ast

import "github.com/software-engineering-amsterdam/many-ql/carlos.cirello/stylelang"

// Visitor is the data structure which converts QLS AST into a set of hash maps
// used by the GUI frontend.
type Visitor struct {
	pages           map[string]*stylelang.Page
	processingStack []*stylelang.Page

	currentRoute  []string
	questionIndex map[string][]string
}

// NewVisitor is the constructor for QLS Visitor
func NewVisitor() *Visitor {
	return &Visitor{
		pages:         make(map[string]*stylelang.Page),
		questionIndex: make(map[string][]string),
	}
}

// Pages returns the tree of pages later to be used by GUI renderer.
func (v *Visitor) Pages() map[string]*stylelang.Page {
	return v.pages
}

// QuestionIndex returns a hashmap resolving the address from the question
// within a page up to root GUI node. It is used by GUI to traverse the QML
// tree faster.
func (v *Visitor) QuestionIndex() map[string][]string {
	return v.questionIndex
}

// Visit is the Visitor pattern implementation
func (v *Visitor) Visit(node Acceptable) {
	node.Accept(v)
}

// StyleNode is the root node for QLS trees
func (v *Visitor) StyleNode(node *StyleNode) {
	pageName := "root"
	v.currentRoute = append(v.currentRoute, pageName)
	page := stylelang.NewPage(pageName)
	v.processingStack = append(v.processingStack, page)
	if node != nil {
		actions := node.Stack()
		for _, action := range actions {
			v.Visit(action)
		}
	}
	tmp := v.processingStack[len(v.processingStack)-1]
	v.processingStack = v.processingStack[:len(v.processingStack)-1]
	v.pages[pageName] = tmp
	v.currentRoute = v.currentRoute[:len(v.currentRoute)-1]
}

// ActionNode represents the ambiguous node which define page, section or
// default
func (v *Visitor) ActionNode(node *ActionNode) {
	v.Visit(node.Action().(Acceptable))
}

// DefaultNode defines a default widget for a question type
func (v *Visitor) DefaultNode(node *DefaultNode) {
	tmp := v.processingStack[len(v.processingStack)-1]
	tmp.SetDefaultFor(node.QuestionType(), node.Widget())
}

// QuestionNode defines a default widget for a question type
func (v *Visitor) QuestionNode(node *QuestionNode) {
	tmp := v.processingStack[len(v.processingStack)-1]
	tmp.SetVisibleFor(node.Identifier())
	v.questionIndex[node.Identifier()] = v.currentRoute
}

// PageNode defines one page within the form, and its nested pages.
func (v *Visitor) PageNode(node *PageNode) {
	v.currentRoute = append(v.currentRoute, node.Label())
	page := stylelang.NewPage(node.Label())
	v.processingStack = append(v.processingStack, page)
	if node != nil {
		actions := node.Stack()
		for _, action := range actions {
			v.Visit(action)
		}
	}
	tmp := v.processingStack[len(v.processingStack)-1]
	v.processingStack = v.processingStack[:len(v.processingStack)-1]
	parent := v.processingStack[len(v.processingStack)-1]
	parent.AddPage(node.Label(), tmp)
	v.currentRoute = v.currentRoute[:len(v.currentRoute)-1]
}
