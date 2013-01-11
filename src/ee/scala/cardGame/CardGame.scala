package ee.scala.cardGame


//
//import collection.mutable.{ListBuffer, MultiMap, HashMap, Set}
//
//class CardGame(players: List[Player]) {
//
//  private val suiteValues = new HashMap[CardSuite.Value, Set[CardFace.Value]] with MultiMap[CardSuite.Value, CardFace.Value]
//
//  def distributeCardTo(players: List[Player], shuffledDeck: ListBuffer[Card]) {
//    players foreach {
//      _ showCard shuffledDeck.remove(0)
//    }
//  }
//
//  def play(times: Int): Player = {
//    var winningPlayer = new Player
//    (1 to times) foreach {
//      time =>
//        drawCardForEveryPlayer()
//        winningPlayer = selectWinnerBySuitePriority()
//    }
//    winningPlayer
//  }
//
//  private def drawCardForEveryPlayer() {
//    players foreach {
//      player =>
//        val card = player topCard()
//        suiteValues addBinding(card suite, card value)
//    }
//  }
//
//  private def selectWinnerBySuitePriority(): Player = {
//    CardSuite.values foreach {
//      suite =>
//        if (suiteValues contains (suite)) {
//          val winnerValue = suiteValues.get(suite).get.max
//          return selectWinnerByHighestValue(suite, winnerValue)
//        }
//    }
//    new Player
//  }
//
//  private def selectWinnerByHighestValue(winningSuite: CardSuite.Value, winningValue: CardFace.Value): Player = {
//    players foreach {
//      player =>
//        if ((player.cardsInHand(player round).compareTo(winningSuite, winningValue) == 0)) {
//          player.winCount += 1
//          player.round += 1
//          return showWinner()
//        }
//        player.round += 1
//    }
//    showWinner()
//  }
//
//  private def showWinner(): Player = {
//    val win: ListBuffer[Int] = new ListBuffer
//    players foreach {
//      player => win append (player winCount)
//    }
//    players foreach {
//      player => if (player.winCount equals win.max) return player
//    }
//    new Player
//  }
//}

class CardGame(players : List[Player], deck : Deck) {

  def playRound() : Player ={
    players(0) deal(deck, List(players(1), players(2), players(3)))

    findHighCardHolder()
  }

  def findHighCardHolder() : Player = {

    var highCardHolder : Player = new Player
    highCardHolder take(new Card(CardSuite.Spade, CardFace.Ace))
    players.foreach(player=>

    if(player.showCard.compareTo(highCardHolder showCard) > 0) highCardHolder=player

    )
    highCardHolder
  }

}