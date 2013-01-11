package ee.scala.cardGame

import org.junit.Test
import org.junit.Assert

class CardGameSpecs {

  @Test
  def itPlaysASingleRound() {

    //given
    val shuffledDeck = DeckBuilder buildStandardDeck() shuffle
    val players = List(new Player, new Player, new Player, new Player)
    val cardGame = new CardGame(players, shuffledDeck)

    //when
    val winner = cardGame.playRound()

    //then
    Assert assertNotNull winner
  }
//
//  @Test
//  def itPlaysGameForFiveCards() {
//
//    //given
//    val deck = new DeckBuilder buildStandardDeck()
//    val unShuffledDeck = deck cards
//    val allPlayers = List(new Player, new Player, new Player, new Player)
//    val cardGame = new CardGame(allPlayers)
//    (0 to 4) foreach {
//      time =>
//        cardGame distributeCardTo(allPlayers, unShuffledDeck)
//    }
//    //when
//    val winningPlayer = cardGame play 5
//
//    //then
//    Assert assertEquals(allPlayers(3), winningPlayer)
//  }
}
