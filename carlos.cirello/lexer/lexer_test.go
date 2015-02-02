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

	expectedTokens := [...]*tokenTest{
		&tokenTest{0, FormToken},
		&tokenTest{1, TextToken},
		&tokenTest{2, BlockBeginToken},
		&tokenTest{15, IfToken},
		&tokenTest{16, ParenBeginToken},
		&tokenTest{18, ParenEndToken},
		&tokenTest{39, BlockEndToken},
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
