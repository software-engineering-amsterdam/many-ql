package ast

import "text/scanner"

// TermNode struct which hold the deepest data in AST
type TermNode struct {
	typ                 TermNodeType
	numericConstant     float32
	stringConstant      string
	identifierReference string
	pos                 scanner.Position
	Evaluatable
}

// NewTermNode factory for TermNode AST node
func NewTermNode(typ TermNodeType, numericConstant float32, stringConstant,
	identifierReference string, pos scanner.Position) *TermNode {
	return &TermNode{
		typ:                 typ,
		numericConstant:     numericConstant,
		stringConstant:      stringConstant,
		identifierReference: identifierReference,
		pos:                 pos,
	}
}

// Type getter method for type property
func (t *TermNode) Type() TermNodeType {
	return t.typ
}

// NumericConstant getter method for numericConstant property
func (t *TermNode) NumericConstant() float32 {
	return t.numericConstant
}

// StringConstant getter method for stringConstant property
func (t *TermNode) StringConstant() string {
	return t.stringConstant
}

// IdentifierReference getter method for identifierReference property
func (t *TermNode) IdentifierReference() string {
	return t.identifierReference
}

// Pos getter method for pos property
func (t *TermNode) Pos() scanner.Position {
	return t.pos
}

// TermNodeType enum to describe possible types of TermNode
type TermNodeType int

const (
	// NumericConstantNodeType is integer or float
	NumericConstantNodeType TermNodeType = iota
	// IdentifierReferenceNodeType is a non-quoted string representing a
	// variable
	IdentifierReferenceNodeType
	// StringConstantNodeType is a quoted string representing literal text
	StringConstantNodeType
)
