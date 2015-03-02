package visitor

import (
	"log"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/qlang/interpreter/ast"
)

// Visitor is the base visitor struct which all other Executer AST tree are
// injected for traversal
type Visitor struct {
	Tree Executer
}

// NewVisitor factory for Visitor AST traversal struct
func NewVisitor(tree Executer) *Visitor {
	return &Visitor{
		Tree: tree,
	}
}

// Visit type switch through all possible root AST node types
func (v *Visitor) Visit(node interface{}) { // node AcceptableInterface
	//node.Accept(v.Tree);
	switch t := node.(type) {
	default:
		pos := node.(ast.Positionable).Pos()
		log.Fatalf("%s: unexpected execution node type. got: %T", pos, t)
	case *ast.QuestionaireNode:
		v.Tree.QuestionaireNode(v, node.(*ast.QuestionaireNode))
	case *ast.ActionNode:
		v.Tree.ActionNode(v, node.(*ast.ActionNode))
	case *ast.QuestionNode:
		v.Tree.QuestionNode(v, node.(*ast.QuestionNode))
	case *ast.IfNode:
		v.Tree.IfNode(v, node.(*ast.IfNode))
	}
}
