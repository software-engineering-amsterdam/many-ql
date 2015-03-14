package cli

import (
	"testing"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/cli/iostream"
)

func TestArgs(t *testing.T) {
	srcFn, inFn, outFn := Args()

	if srcFn != iostream.Stdio {
		t.Error("srcFn must be " + iostream.Stdio)
	}
	if inFn != "" {
		t.Error("inFn must be empty")
	}
	if outFn != iostream.Stdio {
		t.Error("outFn must be " + iostream.Stdio)
	}
}
