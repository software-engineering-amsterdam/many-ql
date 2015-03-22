package utils

import "github.com/software-engineering-amsterdam/many-ql/carlos.cirello/plumbing"

func OutputHandshake(receive, send chan *plumbing.Frontend) {
	readyT := &plumbing.Frontend{
		Type: plumbing.ReadyT,
	}

readyTLoop:
	for {
		select {
		case <-receive:
		case send <- readyT:
			break readyTLoop
		}
	}
}
