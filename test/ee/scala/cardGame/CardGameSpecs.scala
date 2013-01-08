package ee.scala.cardGame

import org.junit.Test
import org.junit.Assert

class CardGameSpecs {

  @Test
  def itPlaysGameForSingleCard() {

    //given
    val deck = new DeckBuilder buildDeck()
    val unShuffledDeck = deck cards

    val allPlayers = List(new Player, new Player, new Player, new Player)
    val cardGame=new CardGame(allPlayers)
    cardGame distributeCardTo(allPlayers, unShuffledDeck)

    //when
    val winningPlayer = cardGame play(1)
    //then
    Assert assertEquals(allPlayers(3), winningPlayer)
  }

  @Test
  def itPlaysGameForFiveCards() {

    //given
    val deck = new DeckBuilder buildDeck()
    val unShuffledDeck = deck cards
    val allPlayers = List(new Player, new Player, new Player, new Player)
    val cardGame=new CardGame(allPlayers)
    (0 to 4) foreach {
      i =>
        cardGame distributeCardTo(allPlayers, unShuffledDeck)
    }
    //when
    val winningPlayer = cardGame play(5)

    //then
    Assert assertEquals(allPlayers(3), winningPlayer)
  }
}
