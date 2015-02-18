package interpreter

import (
	"log"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"
)

type Visitor struct {
	tree Executer
}

func NewVisitor(tree Executer) *Visitor {
	return &Visitor{
		tree: tree,
	}
}

// Exec type switch through all possible root AST node types
func (v *Visitor) Visit(node interface{}) {
	switch t := node.(type) {
	default:
		pos := node.(ast.Positionable).Pos()
		log.Fatalf("%s: unexpected execution node type. got: %T", pos, t)
	case *ast.QuestionaireNode:
		v.tree.QuestionaireNode(v, node.(*ast.QuestionaireNode))
	case *ast.ActionNode:
		v.tree.ActionNode(v, node.(*ast.ActionNode))
	case *ast.QuestionNode:
		v.tree.QuestionNode(v, node.(*ast.QuestionNode))
	case *ast.IfNode:
		v.tree.IfNode(v, node.(*ast.IfNode))
	}
}
