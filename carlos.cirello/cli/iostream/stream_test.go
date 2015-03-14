package iostream

import (
	"os"
	"testing"
)

func TestDefaults(t *testing.T) {
	srcFn, inFn, outFn := Open(Stdio, "", Stdio)

	if srcFn != os.Stdin {
		t.Errorf("Expected os.Stdin for srcFn. Got: %#v", srcFn)
	}
	if inFn != nil {
		t.Errorf("Expected nil for inFn. Got: %#v", inFn)
	}
	if outFn != os.Stdout {
		t.Errorf("Expected os.Stdout for outFn. Got: %#v", outFn)
	}
}

func TestSpecifiedFiles(t *testing.T) {
	srcFn, inFn, outFn := Open("stream_test.go", "stream_test.go", "tmpfile")

	if got, ok := srcFn.(*os.File); !ok {
		t.Errorf("Expected *os.File for srcFn. Got: %#v", got)
	}
	if got, ok := inFn.(*os.File); !ok {
		t.Errorf("Expected *os.File for inFn. Got: %#v", got)
	}
	if got, ok := outFn.(*os.File); !ok {
		t.Errorf("Expected *os.File for outFn. Got: %#v", got)
	}
	os.Remove("tmpfile")
}

func TestOpenNonExistingFile(t *testing.T) {
	defer func() {
		recover()
	}()
	openFile("non-existing")

	t.Error("Error when opening a non-existing file: it should panic.")
}

func TestOutputFileError(t *testing.T) {
	defer func() {
		recover()
	}()
	Open(Stdio, "", os.TempDir())

	t.Error("Error when creating invalid file: it should panic.")
}
