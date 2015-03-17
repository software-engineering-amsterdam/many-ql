age "How old are you?" int

if(age >= 18) 
{
	canShowId "Can you provide an ID?" bool
	
	if(canShowId) 
	{
		nrOfWine "Number of glasses of wine? (€ 5)" int
		nrOfBeer "Number of glasses of beer? (€ 3)" int
	}
}
else 
{
	nrOfFristi "Number of glasses of Fristi (€ 2)" int
}

nrOfTea "Number of glasses of Tea? (€ 1)" int
nrOfCoffee "Number of glasses of coffee? (€ 1)" int

totalNrOfGlasses "Total number of glasses: " int = 
	nrOfTea + nrOfCoffee + nrOfWine + nrOfBeer + nrOfFristi

totalPrice "Total price: " int = 
   (nrOfTea * 1) + (nrOfCoffee * 1) + (nrOfFristi * 2) + (nrOfWine * 5) + (nrOfBeer * 3)