package ee.scala.cardGame

import collection.mutable.ListBuffer

class Player {
  val cards: ListBuffer[Card] = new ListBuffer
  var winCount = 0
  var round = 0

  def acceptCard(card: Card) {
    cards append (card)
  }

  def drawCard(): Card = {
    cards(round)
  }
}
