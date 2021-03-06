package ee.scala.cardGame

import org.junit.{Assert, Test}

class DeckSpecs {

  @Test
  def itShufflesTheDeckOfCards() {
    //given
    val orderedDeck = DeckBuilder buildStandardDeck

    //when
    val shuffledDeck = DeckBuilder buildStandardDeck() shuffle

    //then
    Assert assertNotEquals(orderedDeck topCard, shuffledDeck topCard)
    Assert assertNotEquals(orderedDeck topCard, shuffledDeck topCard)
    Assert assertNotEquals(orderedDeck topCard, shuffledDeck topCard)
  }
}
