package ee.scala.cardGame

import collection.mutable.ListBuffer

class Player {
  val cardsInHand: ListBuffer[Card] = new ListBuffer
  var winCount = 0
  var round = 0

  def showCard() : Card = {
    cardsInHand.remove(0)
  }

  def drawCardFrom(deck : Deck) = {
    cardsInHand.+=(deck.drawCard)
  }
}
