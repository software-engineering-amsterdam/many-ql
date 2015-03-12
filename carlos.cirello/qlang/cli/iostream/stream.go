package iostream

import (
	"fmt"
	"io"
	"os"
)

// New instantiates streams according to parameters input. As Unix convention,
// "-" always means stdin/stdout.
func New(srcFn, inFn, outFn string) (srcReader, inReader io.Reader,
	outWriter io.Writer) {
	srcReader = setupSrcReader(srcFn)
	inReader = setupInReader(inFn)
	outWriter = setupOutReader(outFn)
	return srcReader, inReader, outWriter
}

func setupSrcReader(srcFn string) (srcReader io.Reader) {
	srcReader = os.Stdin
	if "-" != srcFn {
		srcReader = openFile(srcFn)
	}
	return srcReader
}

func setupInReader(inFn string) (inReader io.Reader) {
	inReader = nil
	if "" != inFn {
		inReader = openFile(inFn)
	}
	return inReader
}

func setupOutReader(outFn string) (outWriter io.Writer) {
	outWriter = os.Stdout
	if "-" != outFn {
		writer, err := os.Create(outFn)
		if nil != err {
			panic(fmt.Sprint("Error creating output file: ", err))
		}
		outWriter = writer
	}
	return outWriter
}

func openFile(fn string) (reader io.Reader) {
	if _, err := os.Stat(fn); os.IsNotExist(err) {
		panic(fmt.Sprint("File does not exist: ", err))
	}

	reader, _ = os.Open(fn)

	return reader
}
