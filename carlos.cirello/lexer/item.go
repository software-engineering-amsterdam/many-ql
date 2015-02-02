package lexer

import "fmt"

type itemType int

const (
	itemError      itemType = iota
	itemEOF                 // End-of-file
	itemForm                // form keyword
	itemString              // quoted string
	itemText                // plain text
	itemWhitespace          // whitespace between tokens
)

func (i item) String() string {
	switch i.typ {
	case itemEOF:
		return "EOF"
	case itemError:
		return i.val
	}
	if len(i.val) > 10 {
		return fmt.Sprintf("%.10q...", i.val)
	}
	return fmt.Sprintf("%q", i.val)
}

type item struct {
	typ itemType // Type, such as itemText.
	val string   // Value, such as "23.2".
}
