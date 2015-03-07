age "How old are you?" int
bool isAdult = age >= 18


int nrOfAlcoholicDrinks = 0
int nrOfSoftDrinks = 0
int costsOfAlcoholicDrinks = 0
int costOfSoftDrinks = 0

if(isAdult) 
{
	canShowId "Can you provide an ID?" bool
	
	if(canShowId) 
	{
		nrOfWine "Number of glasses of wine? (€ 5)" int
		nrOfBeer "Number of glasses of beer? (€ 3)" int

		nrOfAlcoholicDrinks = nrOfWine + nrOfBeer
		costsOfAlcoholicDrinks = nrOfWine * 5 + nrOfBeer * 3
	}
}
else 
{
	nrOfFristi "Number of glasses of Fristi (€ 2)" int
	
	nrOfSoftDrinks = nrOfFristi
	costOfSoftDrinks = nrOfFristi * 2
}

nrOfTea "Number of glasses of Tea? (€ 1)" int
nrOfCoffee "Number of glasses of coffee? (€ 1)" int


totalNrOfGlasses "Total number of glasses: " int = 
	nrOfTea + nrOfCoffee + nrOfAlcoholicDrinks + nrOfSoftDrinks

totalPrice "Total price: " int = 
   (nrOfTea * 1) + (nrOfCoffee * 1) + costOfSoftDrinks + costsOfAlcoholicDrinks