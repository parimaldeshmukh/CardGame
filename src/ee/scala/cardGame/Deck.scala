package ee.scala.cardGame

import collection.mutable.ListBuffer
import util.Random

class Deck(cards : ListBuffer[Card] ) {

  def shuffle(): Deck = {
    Random shuffle cards
    if (satisfyRandomiseConditionsOn(cards)) this else shuffle
  }

  private def satisfyRandomiseConditionsOn(shuffledCards: ListBuffer[Card]): Boolean = {
    (1 to 49) foreach {
      index =>
        if (shuffledCards(index).getSuite() equals shuffledCards(index + 1).getSuite() equals
          shuffledCards(index + 2).getSuite())
          return false
    }
    true
  }

  def topCard() : Card = {
    cards.remove(0)
  }

}

