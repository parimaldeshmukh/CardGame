package ee.scala.cardGame

import ee.scala.cardGame.Card
import collection.mutable.ListBuffer

object DeckBuilder {

  val cards : ListBuffer[Card] = new ListBuffer[Card]

  def buildStandardDeck() : Deck = {
    CardSuite.values.foreach(suite =>
      CardFaceValue.values.foreach(faceValue =>
        cards +=(new Card(suite, faceValue))
      )
    )
    new Deck(cards)
  }
}