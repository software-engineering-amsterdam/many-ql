package ast

type TermNode struct {
	typ                 TermNodeType
	numericConstant     float32
	stringConstant      string
	identifierReference string
	Evaluatable
}

func NewTermNode(typ TermNodeType, numericConstant float32, stringConstant,
	identifierReference string) *TermNode {
	return &TermNode{
		typ:                 typ,
		numericConstant:     numericConstant,
		stringConstant:      stringConstant,
		identifierReference: identifierReference,
	}
}

func (t *TermNode) Type() TermNodeType {
	return t.typ
}

func (t *TermNode) NumericConstant() float32 {
	return t.numericConstant
}

func (t *TermNode) StringConstant() string {
	return t.stringConstant
}

func (t *TermNode) IdentifierReference() string {
	return t.identifierReference
}

type TermNodeType int

const (
	NumericConstantNodeType TermNodeType = iota
	IdentifierReferenceNodeType
	StringConstantNodeType
)
