package lexer

import (
	"strings"
	"text/scanner"
)

type token struct {
	typ tokenType
	val string
}

func (t *token) Type() tokenType {
	return t.typ
}

func (t *token) Value() string {
	return t.val
}

func lex(code string) []*token {
	var tokenStack []*token

	var s scanner.Scanner
	s.Init(strings.NewReader(code))
	s.Whitespace = 1<<'\t' | 1<<'\r' | 1<<' '
	tok := s.Scan()
	for tok != scanner.EOF {
		txt := s.TokenText()

		typ := TextToken

		if strings.HasPrefix(txt, FormTokenText) {
			typ = FormToken
		} else if strings.HasPrefix(txt, BlockBeginTokenText) {
			typ = BlockBeginToken
		} else if strings.HasPrefix(txt, BlockEndTokenText) {
			typ = BlockEndToken
		} else if strings.HasPrefix(txt, IfTokenText) {
			typ = IfToken
		} else if strings.HasPrefix(txt, ParenBeginTokenText) {
			typ = ParenBeginToken
		} else if strings.HasPrefix(txt, ParenEndTokenText) {
			typ = ParenEndToken
		}
		tokenStack = append(tokenStack, &token{typ, txt})

		tok = s.Scan()
	}

	return tokenStack
}
