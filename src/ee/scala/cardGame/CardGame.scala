package ee.scala.cardGame

import collection.mutable.{ListBuffer, MultiMap, HashMap, Set}

class CardGame(players: List[Player]) {

  private val suiteValues = new HashMap[CardSuite.Value, Set[CardFaceValue.Value]] with MultiMap[CardSuite.Value, CardFaceValue.Value]

  def distributeCardTo(players: List[Player], shuffledDeck: ListBuffer[Card]) {
    players foreach {
      _ acceptCard shuffledDeck.remove(0)
    }
  }

  def play(times: Int): Player = {
    var winningPlayer = new Player
    (1 to times) foreach {
      time =>
        drawCardForEveryPlayer()
        winningPlayer = selectWinnerBySuitePriority()
    }
    winningPlayer
  }

  private def drawCardForEveryPlayer() {
    players foreach {
      player =>
        val card = player drawCard()
        suiteValues addBinding(card suite, card.value)
    }
  }

  private def selectWinnerBySuitePriority(): Player = {
    CardSuite.values foreach {
      suite =>
        if (suiteValues contains (suite)) {
          val winnerValue = suiteValues.get(suite).get.max
          return decideWinnerByHighestValue(suite, winnerValue)
        }
    }
    new Player
  }

  private def decideWinnerByHighestValue(winningSuite: CardSuite.Value, winningValue: CardFaceValue.Value): Player = {
    players foreach {
      player =>
        if ((player.cards(player round).compareTo(winningSuite, winningValue) == 0)) {
          player.winCount += 1
          player.round += 1
          return showWinner()
        }
        player.round += 1
    }
    showWinner()
  }

  private def showWinner(): Player = {
    val win: ListBuffer[Int] = new ListBuffer
    players foreach {
      player => win append (player winCount)
    }
    players foreach {
      player => if (player.winCount equals win.max) return player
    }
    new Player
  }
}
