FORM Questionnaire {
	hasSoldHouse "Have you sold any damn house?" choice
	priceSoldHouse "How much did you pay for new house?" digits
	hasBoughtHouse "How much did you get for old house?" digits
	howIsLife "Are you still happy:" text
	finalPrice "Are you still happy:" digits (priceSoldHouse * hasBoughtHouse)
	newPrice "Let's test this:" digits ((priceSoldHouse + finalPrice) * hasBoughtHouse)
	testint1 "Integer 1" digits
	testint2 "Integer 2" digits
	test1 "==:" choice (testint1 == hasSoldHouse)
	test2 "-1:" digits (-testint1)
	test3 "&&:" choice (hasSoldHouse && priceSoldHouse)
	
} END	


