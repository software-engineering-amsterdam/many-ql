package visitor

import (
	"log"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/stylelang/ast"
)

// Visitor is the data structure which converts QLS AST into a set of hash maps
// used by the GUI frontend.
type Visitor struct {
	defaults map[string]string
}

// New is the constructor for Visitor
func New() *Visitor {
	return &Visitor{
		defaults: make(map[string]string),
	}
}

// Defaults returns the processed hashmap of default widgets for each question
// type.
func (v *Visitor) Defaults() map[string]string {
	return v.defaults
}

// Visit is the Visitor pattern implementation
func (v *Visitor) Visit(node interface{}) {
	switch t := node.(type) {
	default:
		log.Fatalf("unexpected style node type. got: %T", t)
	case *ast.StyleNode:
		v.styleNode(node.(*ast.StyleNode))
	case *ast.ActionNode:
		v.actionNode(node.(*ast.ActionNode))
	case *ast.DefaultNode:
		v.defaultNode(node.(*ast.DefaultNode))
	}
}

func (v *Visitor) styleNode(node *ast.StyleNode) {
	if node != nil {
		actions := node.Stack()
		for _, action := range actions {
			v.Visit(action)
		}
	}
}

func (v *Visitor) actionNode(node *ast.ActionNode) {
	v.Visit(node.Action())
}

func (v *Visitor) defaultNode(node *ast.DefaultNode) {
	v.setDefaultFor(node.QuestionType(), node.Widget())
}

func (v *Visitor) setDefaultFor(t, w string) {
	if _, ok := v.defaults[t]; !ok {
		v.defaults[t] = w
	}
}
