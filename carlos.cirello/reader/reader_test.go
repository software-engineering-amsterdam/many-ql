package reader

import (
	"io"
	"os"
	"strings"
	"testing"
)

func TestConstructor(t *testing.T) {
	gotStdin, _ := New("-")
	if gotStdin.stream != os.Stdin {
		t.Errorf("Expected os.Stdin. Got %T", gotStdin)
	}

	_, expectError := New("INVALIDFILENAME")
	if expectError == nil {
		t.Errorf("Expected error. Got %T", expectError)
	}

	gotFileHandle, gotError := New("reader_test.go")
	if gotFileHandle.stream.(io.Reader) == nil {
		t.Errorf("Expected os.IsNotExist(). Got %T", gotError)
	}

}

func TestStreamReader(t *testing.T) {
	expect := "SOME CODE\x04"
	buf := strings.NewReader(expect)

	fileReader := &Reader{buf}
	got := fileReader.Read()

	if expect != got {
		t.Errorf("Expected %s (%d). Got %s (%d)", expect, len(expect), got, len(got))
	}
}
