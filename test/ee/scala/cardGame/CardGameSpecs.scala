package ee.scala.cardGame

import org.junit.Test
import org.junit.Assert
import org.mockito.Mockito._
import org.mockito.Matchers._
import org.mockito.BDDMockito._

class CardGameSpecs {

  @Test
  def itPlaysASingleRound() {

    //given
    val shuffledDeck = DeckBuilder buildStandardDeck() shuffle

    val playerOne = mock(classOf[Player])
    val playerTwo = mock(classOf[Player])
    val playerThree = mock(classOf[Player])
    val playerFour = mock(classOf[Player])

    given(playerOne showCard) willReturn new Card(CardSuite.Diamond, CardFace.Two)
    given(playerTwo showCard) willReturn new Card(CardSuite.Spade, CardFace.Ace)
    given(playerThree showCard) willReturn new Card(CardSuite.Club, CardFace.King)
    given(playerFour showCard) willReturn new Card(CardSuite.Heart, CardFace.Four)

    val players = List(playerOne, playerTwo, playerThree, playerFour)
    val cardGame = new CardGame(players, shuffledDeck)



    //when
    val winner = cardGame.playRound()

    //then
    assert(winner equals playerOne)
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
