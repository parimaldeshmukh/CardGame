package ee.scala.cardGame

import org.junit.{Assert, Test}

class PlayerSpecs {

  @Test
  def itDistributesTheCardsToSinglePlayer() {

    //given
    val deck = new DeckBuilder buildDeck()
    val shuffledDeck = deck shuffle()
    val expected = shuffledDeck(0)
    val players = List(new Player)
    val cardGame=new CardGame(players)
    //when
    cardGame distributeCardTo(players, shuffledDeck)
    //then
    Assert assertEquals(expected, players(0) cards 0)
  }

  @Test
  def itDistributesTheCardsToMultiplePlayers() {

    //given
    val deck = new DeckBuilder buildDeck()
    val shuffledDeck = deck shuffle()

    val expected0 = shuffledDeck(0)
    val expected1 = shuffledDeck(1)
    val expected2 = shuffledDeck(2)
    val expected3 = shuffledDeck(3)
    val players = List(new Player, new Player, new Player, new Player)
    val cardGame=new CardGame(players)
    //when
    cardGame distributeCardTo(players, shuffledDeck)
    //then
    Assert assertEquals(expected0, players(0) cards 0)
    Assert assertEquals(expected1, players(1) cards 0)
    Assert assertEquals(expected2, players(2) cards 0)
    Assert assertEquals(expected3, players(3) cards 0)
  }
}
