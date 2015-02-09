package reader

import (
	"strings"
	"testing"
)

func TestStreamReader(t *testing.T) {
	expect := "SOME CODE\x04"
	buf := strings.NewReader(expect)

	fileReader := &Reader{buf}
	got := fileReader.Read()

	if expect != got {
		t.Errorf("Expected %s (%d). Got %s (%d)", expect, len(expect), got, len(got))
	}
}
