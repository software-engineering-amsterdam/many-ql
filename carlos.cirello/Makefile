all:
	go generate ./...
	go build ./cmd/...
	echo "Build successful"
	./ql -h || echo

test:
	go generate ./...
	go test -v ./...

coverage:
	bash ./coverage.sh

autotest:
	./autotest.sh '.' 'clear; make test; go run ql.go'

todos:
	grep -RHin "// todo" *

doc: .FORCE
	godoc -http=:8080 &
	sleep 2
	open 'http://localhost:8080/pkg/github.com/software-engineering-amsterdam/many-ql/carlos.cirello/'

lint:
	clear
	golint ./... | grep -iv parser.y | head -n 20

.FORCE:
