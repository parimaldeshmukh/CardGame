package ee.scala.cardGame

import org.junit.{Assert, Test}

class DeckBuilderSpecs {
  @Test
  def itChecksForPopulatedDeck() {
    //given
    //when
    val deck = new DeckBuilder buildStandardDeck

    //then
    Assert assertEquals(deck.cards(0).suite, CardSuite.Diamond)
    Assert assertEquals(deck.cards(0).value, CardFaceValue.Ace)

  }
}
