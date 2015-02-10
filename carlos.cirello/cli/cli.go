package cli

import "flag"

// Args reads the CLI arguments seeking for parameters relevant to stream
// instantiation.
func Args() (inFn, outFn string) {
	inFnPtr := flag.String("in", "-", `QL code filename or "-" to read from stdin`)
	outFnPtr := flag.String("out", "-", `csv output filename or "-" to output to stdout`)
	flag.Parse()

	inFn = *inFnPtr
	outFn = *outFnPtr
	return inFn, outFn
}
