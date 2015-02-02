test:
	go test -v ./...

cover:
	go test -coverprofile=./questionaire/coverage.out ./questionaire
	go tool cover -html=./questionaire/coverage.out

autotest:
	./autotest.sh '.' 'clear; make cover; go run ql.go'