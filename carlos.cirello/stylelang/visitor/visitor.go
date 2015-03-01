package visitor

import (
	"log"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/stylelang/ast"
)

type Visitor struct {
	defaults map[string]string
}

func New() *Visitor {
	return &Visitor{
		defaults: make(map[string]string),
	}
}

func (v *Visitor) Defaults() map[string]string {
	return v.defaults
}

func (v *Visitor) Visit(node interface{}) {
	switch t := node.(type) {
	default:
		log.Fatalf("unexpected style node type. got: %T", t)
	case *ast.StyleNode:
		v.StyleNode(node.(*ast.StyleNode))
	case *ast.ActionNode:
		v.ActionNode(node.(*ast.ActionNode))
	case *ast.DefaultNode:
		v.DefaultNode(node.(*ast.DefaultNode))
	}
}

func (v *Visitor) StyleNode(node *ast.StyleNode) {
	actions := node.Stack()
	for _, action := range actions {
		v.Visit(action)
	}
}

func (v *Visitor) ActionNode(node *ast.ActionNode) {
	v.Visit(node.Action())
}

func (v *Visitor) DefaultNode(node *ast.DefaultNode) {
	v.setDefaultFor(node.QuestionType(), node.Widget())
}

func (v *Visitor) setDefaultFor(t, w string) {
	if _, ok := v.defaults[t]; !ok {
		v.defaults[t] = w
	}
}
