package ee.scala.cardGame

import org.junit.{Assert, Test}

class PlayerSpecs {

  @Test
  def itDrawsACardFromADeck() {

    //given
    val shuffledDeck = DeckBuilder buildStandardDeck() shuffle
    val player = new Player

    //when
    player take shuffledDeck.topCard

    //then
    Assert assertNotNull (player showCard())
  }

  @Test
  def itDistributesGivenDeckToGivenPlayers() {

    //given
    val shuffledDeck = DeckBuilder buildStandardDeck() shuffle
    val players = List(new Player, new Player, new Player)
    val dealer = new Player

    //when
    dealer distribute(shuffledDeck,players)

    //then
   Assert assertNotNull(dealer showCard())
   Assert assertNotNull(players(0) showCard())
   Assert assertNotNull(players(1) showCard())
   Assert assertNotNull(players(2) showCard())

  }
}
