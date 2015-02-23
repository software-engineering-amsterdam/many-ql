all:
	go generate ./...
	go build
	echo "Build successful"
	./carlos.cirello -h || echo

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

talk:
	cd doc
	present -play=true &
	sleep 2
	open 'http://127.0.0.1:3999/doc/carlos.cirello.ql.HoC.20150223.slide'

lint:
	clear
	golint ./... | head -n 20

.FORCE:
