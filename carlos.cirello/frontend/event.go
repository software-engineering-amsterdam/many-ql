package frontend

import "github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"

// Event carries the communication between VM and Frontend
type Event struct {
	Type     EventType
	Question ast.Question
	Answers  map[string]string
}

// EventType describes the communication protocol between the VM
// and Frontend goroutines.
type EventType int

const (
	// ReadyP VM message to confirm readiness of frontend
	ReadyP EventType = iota
	// ReadyT Frontend confirmation of readiness
	ReadyT
	// Render sends to Frontend driver the request for one question
	Render
	// Flush forces Frontend driver to assemble the screen
	Flush
	// FetchAnswers is the signal from VM to read the current captured
	// answers from Frontend process
	FetchAnswers
	// Answers is the signal from Frontend to VM with the responses from
	// user.
	Answers
)
