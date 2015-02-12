package stream

import (
	"io"
	"log"
	"os"
)

// New instantiates streams according to parameters input. As Unix convention,
// "-" always means stdin/stdout.
func New(srcFn, inFn, outFn string) (srcReader, inReader io.Reader, outWriter io.Writer) {
	srcReader = os.Stdin
	if "-" != srcFn {
		if _, err := os.Stat(srcFn); os.IsNotExist(err) {
			log.Fatalln("Input file does not exist: ", err)
		}

		reader, err := os.Open(srcFn)
		if nil != err {
			log.Fatalln("Error reading input file: ", err)
		}
		srcReader = reader
	}

	inReader = nil
	if "" != inFn {
		if _, err := os.Stat(inFn); os.IsNotExist(err) {
			log.Fatalln("Input file does not exist: ", err)
		}

		reader, err := os.Open(inFn)
		if nil != err {
			log.Fatalln("Error reading input file: ", err)
		}
		inReader = reader
	}

	outWriter = os.Stdout
	if "-" != outFn {
		writer, err := os.Create(outFn)
		if nil != err {
			log.Fatalln("Error creating output file: ", err)
		}
		outWriter = writer
	}

	return srcReader, inReader, outWriter
}
