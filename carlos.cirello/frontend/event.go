package frontend

import "github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"

// Event carries the communication between VM and Frontend
type Event struct {
	Type     EventType
	Question ast.Question
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
	// Answer provides the answer for a question on the scree
	Answer
	// Flush forces Frontend driver to assemble the screen
	Flush
)
