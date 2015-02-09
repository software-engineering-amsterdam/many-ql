/*
Package reader takes the filename param from main.main() ("-source"), and
prepares a io.Reader object which handle possible cases, so far:

1 - Read from STDIN

2 - Read from a file

This reader is used by the VM, and can be extended to accept multiple files, or
different media, such network connections and plumber (Plan9 and Rio).
*/
package reader
