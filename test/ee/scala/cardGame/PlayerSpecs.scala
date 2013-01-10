package ee.scala.cardGame

import org.junit.{Assert, Test}

class PlayerSpecs {

  @Test
  def itDistributesACardToASinglePlayer() {

    //given
    val shuffledDeck = DeckBuilder buildStandardDeck() shuffle
    val player = new Player

    //when
    player drawCardFrom shuffledDeck

    //then
    Assert assertNotNull (player showCard())
  }
}
