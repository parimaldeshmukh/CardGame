package ee.scala.cardGame

import collection.mutable.ListBuffer
import util.Random

class Deck(cards : ListBuffer[Card] ) {

  def shuffle(): ListBuffer[Card] = {
    val shuffledDeck = Random shuffle cards

    if (satisfyConditionsOn(shuffledDeck)) return shuffledDeck else shuffle()
    shuffledDeck
  }

  private def satisfyConditionsOn(shuffledDeck: ListBuffer[Card]): Boolean = {
    (1 to 49) foreach {
      index =>
        if (shuffledDeck(index).suite equals shuffledDeck(index + 1).suite equals shuffledDeck(index + 2).suite) return false
    }
    true
  }

}

