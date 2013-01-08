package ee.scala.cardGame

class DeckBuilder {
  var deck = new Deck

  def buildDeck() = {
    CardSuite.values.foreach(suite =>
      CardFaceValue.values.foreach(faceValue =>
        deck.cards += new Card(suite, faceValue)
      )
    )
    deck
  }
}
