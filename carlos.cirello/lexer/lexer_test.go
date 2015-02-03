package lexer

import (
	"log"
	"testing"
)

type tokenTest struct {
	tokenPosition     int
	expectedTokentype tokenType
}

func TestLexer(t *testing.T) {
	str := `
form taxOfficeExample {
  "Did you sell a house in 2010?"
    hasSoldHouse: boolean
  "Did you buy a house in 2010?"
    hasBoughtHouse: boolean
  "Did you enter a loan?"
    hasMaintLoan: boolean

  if (hasSoldHouse) {
    "What was the selling price?"
      sellingPrice: money
    "Private debts for the sold house:"
      privateDebt: money
    "Value residue:"
      valueResidue: money =
        (sellingPrice - privateDebt)
  }
}
`
	tokens := lex(str)

	for k, v := range tokens {
		t.Log(k, v)
	}

	expectedTokens := [...]*tokenTest{
		&tokenTest{1, FormToken},
		&tokenTest{2, TextToken},
		&tokenTest{3, BlockBeginToken},
		&tokenTest{24, IfToken},
		&tokenTest{25, ParenBeginToken},
		&tokenTest{27, ParenEndToken},
		&tokenTest{57, BlockEndToken},
	}

	for _, v := range expectedTokens {
		pos := v.tokenPosition
		typ := v.expectedTokentype
		got := tokens[pos].Type()

		if got != typ {
			log.Fatalf("Error in lexer. In %d, expected %s, got %s", pos, typ, got)
		}
	}
}
