package cli

import "flag"

// Args reads the CLI arguments seeking for parameters relevant to stream
// instantiation.
func Args() (srcFn, inFn, outFn string) {
	srcFnPtr := flag.String("src", "-", `QL code filename or "-" to read from stdin`)
	inFnPtr := flag.String("in", "", `CSV filename`)
	outFnPtr := flag.String("out", "-", `csv output filename or "-" to output to stdout`)
	flag.Parse()

	srcFn = *srcFnPtr
	inFn = *inFnPtr
	outFn = *outFnPtr
	return srcFn, inFn, outFn
}
