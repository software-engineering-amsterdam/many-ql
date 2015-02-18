package interpreter

import "github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"

// Event carries the communication between VM and Frontend
type Event struct {
	Type EventType

	Question ast.QuestionNode
	Visible  Visibility

	Answers map[string]string
}

// EventType describes the communication protocol between the VM
// and Frontend goroutines.
type EventType int

const (
	// ReadyP VM message to confirm readiness of frontend
	ReadyP EventType = iota
	// ReadyT Frontend confirmation of readiness
	ReadyT
	// Draw sends to Frontend driver the request for one question
	Draw
	// Update sends to Frontend ... todo
	Update
	// Flush forces Frontend driver to assemble the screen
	Flush
	// FetchAnswers is the signal from VM to read the current captured
	// answers from Frontend process
	FetchAnswers
	// Answers is the signal from Frontend to VM with the responses from
	// user.
	Answers
)

type Visibility int

const (
	Pristine Visibility = iota
	Visible
	Hidden
)

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
