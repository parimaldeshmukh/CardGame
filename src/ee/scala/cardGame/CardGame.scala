package ee.scala.cardGame

class CardGame(players : List[Player], deck : Deck) {

  def playRound() : Player ={
    players(0) deal(deck, List(players(1), players(2), players(3)))

    findHighCardHolder()
  }

  private def findHighCardHolder() : Player = {

    var highCardHolder : Player = new Player
    highCardHolder take(new Card(CardSuite.Spade, CardFace.Ace))
    players.foreach(player=>

    if(player.showCard.compareTo(highCardHolder showCard) > 0) highCardHolder=player

    )
    highCardHolder
  }

  def play() : Player = {

    1 to 5 foreach(roundNumber=>
    players foreach( _ take deck.topCard )
    )

    1 to 5 foreach {roundNumber=>
      playRound notifyWinner
    }

    var winner = new Player
    players.foreach(player =>
    if (player.roundsWon > winner.roundsWon) winner=player
    )
    winner
  }

}