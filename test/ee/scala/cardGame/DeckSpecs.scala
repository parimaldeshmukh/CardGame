package ee.scala.cardGame
import org.junit.{Assert, Test}

class DeckSpecs{

  @Test
  def itShufflesTheDeckOfCards() {
    //given
    val deck = new DeckBuilder buildDeck()
    val card0 = deck cards (0)
    val card1 = deck cards (1)
    val card2 = deck cards (2)

    //when
    val shuffledDeck = deck shuffle

    //then
    Assert assertNotEquals(card0, shuffledDeck(0))
    Assert assertNotEquals(card1, shuffledDeck(1))
    Assert assertNotEquals(card2, shuffledDeck(2))
  }
}
