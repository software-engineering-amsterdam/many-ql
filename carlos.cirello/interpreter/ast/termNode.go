package ast

import "text/scanner"

// TermNode struct which hold the deepest data in AST.
type TermNode struct {
	typ                 TermNodeType
	booleanLiteral      bool
	numericLiteral      float32
	stringLiteral       string
	identifierReference string
	pos                 scanner.Position
	Evaluatable
}

// NewTermNode factory for TermNode AST node.
func NewTermNode(typ TermNodeType, booleanLiteral bool, numericLiteral float32,
	stringLiteral, identifierReference string,
	pos scanner.Position) *TermNode {
	return &TermNode{
		typ:                 typ,
		booleanLiteral:      booleanLiteral,
		numericLiteral:      numericLiteral,
		stringLiteral:       stringLiteral,
		identifierReference: identifierReference,
		pos:                 pos,
	}
}

// Type getter method for type property.
func (t *TermNode) Type() TermNodeType {
	return t.typ
}

// NumericLiteral getter method for numericLiteral property.
func (t *TermNode) NumericLiteral() float32 {
	return t.numericLiteral
}

// StringLiteral getter method for stringLiteral property.
func (t *TermNode) StringLiteral() string {
	return t.stringLiteral
}

// IdentifierReference getter method for identifierReference property.
func (t *TermNode) IdentifierReference() string {
	return t.identifierReference
}

// BooleanLiteral getter method for booleanLiteral property.
func (t *TermNode) BooleanLiteral() bool {
	return t.booleanLiteral
}

// Pos getter method for pos property.
func (t *TermNode) Pos() scanner.Position {
	return t.pos
}

// TermNodeType enum to describe possible types of TermNode.
type TermNodeType int

const (
	// NumericLiteralNodeType is integer or float.
	NumericLiteralNodeType TermNodeType = iota
	// IdentifierReferenceNodeType is a non-quoted string representing a
	// variable.
	IdentifierReferenceNodeType
	// StringLiteralNodeType is a quoted string representing literal text.
	StringLiteralNodeType
	// BooleanLiteralNodeType is a quoted string representing literal
	// booleans.
	BooleanLiteralNodeType
)
