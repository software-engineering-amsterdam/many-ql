package event

import "github.com/software-engineering-amsterdam/many-ql/carlos.cirello/qlang/interpreter/ast"

// Frontend carries the communication between VM and Frontend
type Frontend struct {
	Type FrontendEventType

	Question ast.QuestionNode

	Identifier string
	Label      string
	FieldType  string
	Value      string

	Visible Visibility

	Answers map[string]string
}

// FrontendEventType describes the communication protocol between the VM
// and Frontend goroutines.
type FrontendEventType int

const (
	// ReadyP VM message to confirm readiness of frontend
	ReadyP FrontendEventType = iota
	// ReadyT Frontend confirmation of readiness
	ReadyT
	// DrawQuestion sends to Frontend driver the request for one question
	DrawQuestion
	// UpdateQuestion sends to Frontend ... todo
	UpdateQuestion
	// Flush forces Frontend driver to assemble the screen
	Flush
	// FetchAnswers is the signal from VM to read the current captured
	// answers from Frontend process
	FetchAnswers
	// Answers is the signal from Frontend to VM with the responses from
	// user.
	Answers
	// Redraw is the signal from Frontend to VM asking to redraw the
	// content, mainly used to switch between Frontend drivers
	Redraw
)

// Visibility enum type which determinates whether a new rendered field must be
// shown right away or must wait until some other condition is true. In
// practice, it prFrontends fields within if-blocks to be shown unless their
// if-conditions are true first.
type Visibility int

const (
	// Pristine is the same as do not change the field status
	Pristine Visibility = iota
	// Visible is meant to force the field to be shown
	Visible
	// Hidden is meant to force the field to be hidden
	Hidden
)

// String is the fmt.Stringer for Visibility enum
func (v Visibility) String() string {
	switch v {
	case Pristine:
		return "Pristine"
	case Visible:
		return "Visible"
	case Hidden:
		return "Hidden"
	default:
		return "Unknown"
	}
}
