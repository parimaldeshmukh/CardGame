package ee.scala.cardGame

import collection.mutable.ListBuffer
import util.Random

class Deck(cards : ListBuffer[Card] ) {

  def shuffle(): Deck = {
    val shuffledDeck = Random shuffle cards

    if (satisfyConditionsOn(shuffledDeck)) return this else shuffle()
  }

  private def satisfyConditionsOn(shuffledDeck: ListBuffer[Card]): Boolean = {
    (1 to 49) foreach {
      index =>
        if (shuffledDeck(index).suite equals shuffledDeck(index + 1).suite equals shuffledDeck(index + 2).suite) return false
    }
    true
  }

  def drawCard() : Card = {
    cards.remove(0)
  }

}

