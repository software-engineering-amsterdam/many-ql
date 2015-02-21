package ast

import "text/scanner"

// Positionable interface meant to be used in error message rendering
type Positionable interface {
	Pos() scanner.Position
}
