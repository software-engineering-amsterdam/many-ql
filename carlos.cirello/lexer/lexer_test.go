package lexer

import "testing"

func TestLexer(t *testing.T) {
	str := `form Name`

	lexer := lex(str)
	lexer.run()

	for item := range lexer.items {
		t.Logf("%v %s \n", item, item)
	}
}
