package ee.scala.cardGame

import collection.mutable.ListBuffer

class Player {
  val cardsInHand: ListBuffer[Card] = new ListBuffer
  var winCount = 0
  var round = 0

  def showCard() : Card = {
    cardsInHand.remove(0)
  }

  def take(card : Card) = {
    cardsInHand.+=(card)
  }

  def distribute(deck : Deck, players : List[Player]) {

   players.foreach(player => player take deck.topCard())

   this take deck.topCard()

  }


}
