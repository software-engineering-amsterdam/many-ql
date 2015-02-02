package lexer

type tokenType int

const (
	FormToken tokenType = iota
	TextToken
	BlockBeginToken
	BlockEndToken
	IfToken
	ParenBeginToken
	ParenEndToken
)

const (
	FormTokenText       = "form"
	BlockBeginTokenText = "{"
	BlockEndTokenText   = "}"
	IfTokenText         = "if"
	ParenBeginTokenText = "("
	ParenEndTokenText   = ")"
)
