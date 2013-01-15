package ee.scala.cardGame

import collection.mutable.ListBuffer

class Player {
  val cardsInHand: ListBuffer[Card] = new ListBuffer
  var winCount = 0

  def showCard() : Card = {
    cardsInHand.head
  }

  def take(card : Card) = {
    cardsInHand.+=(card)
  }

  def deal(deck : Deck, players : List[Player]) {

   players.foreach(player => player take deck.topCard())

   this take deck.topCard()

  }

  def notifyWinner() {
    winCount+=1
  }


  def roundsWon() : Int = {
    winCount
  }

}
