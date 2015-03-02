package ast

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
func (v *Visitor) Visit(node Acceptable) {
	node.Accept(v)
}
