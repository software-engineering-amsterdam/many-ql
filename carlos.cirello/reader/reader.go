package reader

import (
	"bufio"
	"io"
	"os"
)

// Reader holds an io.Reader with source code (either from a file, or some
// other medium)
type Reader struct {
	stream io.Reader
}

// New takes the filename, and prepare a io.Reader object to be consumed later
func New(filename string) (*Reader, error) {
	if "-" == filename {
		return &Reader{os.Stdin}, nil
	}

	if _, err := os.Stat(filename); os.IsNotExist(err) {
		return nil, err
	}

	handle, err := os.Open(filename)
	return &Reader{handle}, err
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
