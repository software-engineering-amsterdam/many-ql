package reader

import (
	"bufio"
	"io"
)

// Reader holds an io.Reader with source code (either from a file, or some
// other medium)
type Reader struct {
	stream io.Reader
}

// New takes in a reader stream, and prepare an object to be consumed later.
func New(reader io.Reader) *Reader {
	return &Reader{
		stream: reader,
	}
}

// Read consumes the internal io.Reader object returning a string ready to use.
func (r Reader) Read() string {
	buf := bufio.NewReader(r.stream)
	code := ""
	for {
		content, err := buf.ReadString('\x04')
		code += string(content)
		if err == io.EOF {
			break
		}
	}
	return code
}
