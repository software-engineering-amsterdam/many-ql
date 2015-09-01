form Trouwerij
  "Wat is uw naam?" naam : string
  "Komt u naar de trouwerij?" aanwezig : boolean
  if (aanwezig)
    "Hoeveel personen neemt u mee?" aantal_personen : integer
    "Hoeveel kinderen neemt u mee?" aantal_kinderen : integer
    if (aantal_personen > 6)
      "Blijft u overnachten?" overnachten : boolean
    end
  end
  "Heeft u er zin in?" zin_in : boolean
  "Totaal aantal" aantal_personen + aantal_kinderen + 1 : integer

end
