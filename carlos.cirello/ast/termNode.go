package ast

import "text/scanner"

type TermNode struct {
	typ                 TermNodeType
	numericConstant     float32
	stringConstant      string
	identifierReference string
	pos                 scanner.Position
	Evaluatable
}

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

func (t *TermNode) Pos() scanner.Position {
	return t.pos
}

type TermNodeType int

const (
	NumericConstantNodeType TermNodeType = iota
	IdentifierReferenceNodeType
	StringConstantNodeType
)
