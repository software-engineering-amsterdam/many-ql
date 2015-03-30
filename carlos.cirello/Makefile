all:
	go generate ./...
	go build -o ql
	go build -tags json -o ql-json
	echo "Build successful"
	./ql -h || echo

test:
	go generate ./...
	go test -v ./...

doc: .FORCE
	godoc -http=:8080 &
	sleep 2
	open 'http://localhost:8080/pkg/github.com/software-engineering-amsterdam/many-ql/carlos.cirello/'

.FORCE:
