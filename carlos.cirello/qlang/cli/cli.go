package cli

import "flag"

// Args reads the CLI arguments seeking for parameters relevant to stream
// instantiation.
func Args() (srcFn, inFn, outFn, cpuProfileFn string) {
	srcFnPtr := flag.String("src", "-", `QL code filename or "-" to read from stdin`)
	inFnPtr := flag.String("in", "", `CSV filename`)
	outFnPtr := flag.String("out", "-", `csv output filename or "-" to output to stdout`)
	cpuProfileFnPtr := flag.String("cpuprofile", "", "write cpu profile to file")
	flag.Parse()

	srcFn = *srcFnPtr
	inFn = *inFnPtr
	outFn = *outFnPtr
	cpuProfileFn = *cpuProfileFnPtr
	return srcFn, inFn, outFn, cpuProfileFn
}
