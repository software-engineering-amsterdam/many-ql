package cli

import "testing"

func TestArgs(t *testing.T) {
	srcFn, inFn, outFn, _ := Args()

	if srcFn != "-" {
		t.Error("srcFn must be -")
	}
	if inFn != "" {
		t.Error("inFn must be empty")
	}
	if outFn != "-" {
		t.Error("outFn must be -")
	}
}
