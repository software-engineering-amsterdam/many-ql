package ast

import "log"

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
		pos := node.(Positionable).Pos()
		log.Fatalf("%s: unexpected execution node type. got: %T", pos, t)
	case *QuestionaireNode:
		v.Tree.QuestionaireNode(v, node.(*QuestionaireNode))
	case *ActionNode:
		v.Tree.ActionNode(v, node.(*ActionNode))
	case *QuestionNode:
		v.Tree.QuestionNode(v, node.(*QuestionNode))
	case *IfNode:
		v.Tree.IfNode(v, node.(*IfNode))
	}
}
