package plumbing

// Frontend carries the communication between Interpreter and Frontend. The
// basic structure of question is repeated here, so occasional extensions of AST
// or Symbol Table internals do not affect internals of Frontend.
type Frontend struct {
	Type FrontendEventType

	Identifier string
	Label      string
	FieldType  string
	Value      string

	Visible Visibility

	Answers map[string]string
}

// FrontendEventType describes the communication protocol between the
// Interpreter and Frontend goroutines.
type FrontendEventType int

const (
	// ReadyP Interpreter message to confirm readiness of frontend.
	ReadyP FrontendEventType = iota
	// ReadyT Frontend confirmation of readiness.
	ReadyT
	// DrawQuestion sends to Frontend driver the request for render one
	// question.
	DrawQuestion
	// UpdateQuestion sends to Frontend driver the request to update the
	// content of an already rendered question.
	UpdateQuestion
	// Flush forces Frontend driver to assemble the screen.
	Flush
	// FetchAnswers is the signal from Interpreter to read the current
	// captured answers from Frontend process.
	FetchAnswers
	// Answers is the signal from Frontend to Interpreter with the responses
	// from user.
	Answers
	// Redraw is the signal from Frontend to Interpreter asking to redraw
	// the content, mainly used to switch between Frontend drivers.
	Redraw
)

// Visibility enum type which determinates whether a new rendered field must be
// shown right away or must wait until some other condition is true. In
// practice, it prFrontends fields within if-blocks to be shown unless their
// if-conditions are true first.
type Visibility int

const (
	// Hidden is meant to force the field to be hidden.
	Hidden Visibility = iota
	// Visible is meant to force the field to be shown.
	Visible
)

// String is the fmt.Stringer for Visibility enum
func (v Visibility) String() string {
	switch v {
	case Hidden:
		return "Hidden"
	case Visible:
		return "Visible"
	default:
		return "Unknown"
	}
}
