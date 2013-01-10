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
  def itDistributesFromGivenDeckToGivenPlayers() {

    //given
    val shuffledDeck = DeckBuilder buildStandardDeck() shuffle
    val players = List(new Player, new Player, new Player)
    val dealer = new Player

    //when
    dealer distribute(shuffledDeck,players)

    val cardsWithPlayers = List(dealer showCard(), players(0) showCard(), players(1) showCard(), players(2) showCard())

    //then
   Assert assertTrue (cardsWithPlayers.distinct.length==4)

  }
}
