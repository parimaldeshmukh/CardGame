package ee.scala.cardGame

import org.junit.Test
import org.junit.Assert

class CardSpecs {


  @Test
  def itComparesTwoCards() {

    //given
    val deck = new DeckBuilder buildStandardDeck()
    val unShuffledDeck = deck cards
    val card1 = unShuffledDeck(0)
    val card2 = unShuffledDeck(1)
    //when
    val actual1 = card1.compareTo(card2.suite, card2.value)
    val actual2 = card2.compareTo(card2.suite, card2.value)
    //then
    Assert assertEquals(actual1, -1)
    Assert assertEquals(actual2, 0)
  }

}
