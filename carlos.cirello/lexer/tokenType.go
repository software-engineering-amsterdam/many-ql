package lexer

type tokenType int

const (
	// FormToken - "form ..."
	FormToken tokenType = iota
	// TextToken - Any other non reserved word
	TextToken
	// BlockBeginToken - {...
	BlockBeginToken
	// BlockEndToken - ...}
	BlockEndToken
	// IfToken - if ...
	IfToken
	// ParenBeginToken - (...
	ParenBeginToken
	// ParenEndToken - ...)
	ParenEndToken
)

const (
	// FormTokenText - Reserved Word
	FormTokenText = "form"
	// BlockBeginTokenText - Reserved Word
	BlockBeginTokenText = "{"
	// BlockEndTokenText - Reserved Word
	BlockEndTokenText = "}"
	// IfTokenText - Reserved Word
	IfTokenText = "if"
	// ParenBeginTokenText - Reserved Word
	ParenBeginTokenText = "("
	// ParenEndTokenText - Reserved Word
	ParenEndTokenText = ")"
)
