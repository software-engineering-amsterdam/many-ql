package frontend

// Event carries the communication between VM and Frontend
type Event struct {
	Type    EventType
	Content interface{}
}

// EventType describes the communication protocol between the VM
// and Frontend goroutines.
type EventType int

const (
	// READY_P VM message to confirm readiness of frontend
	READY_P EventType = iota
	// READY_T Frontend confirmation of readiness
	READY_T
	// RENDER forces output refresh with Content
	RENDER
	// ANSWER provides the answer for a question on the scree
	ANSWER
)
