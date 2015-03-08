FORM Questionnaire {
	hasSoldHouse "Have you sold any damn house?" choice
	priceSoldHouse "How much did you pay for new house?" digits
	hasBoughtHouse "How much did you get for old house?" digits
	howIsLife "Are you still happy:" text
	finalPrice "Are you still happy:" digits (hasSoldHouse * hasBoughtHouse)

} END	


