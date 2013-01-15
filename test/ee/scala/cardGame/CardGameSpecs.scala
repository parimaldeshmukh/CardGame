package ee.scala.cardGame

import CardSuite._
import CardFace._
import org.junit.Test
import org.mockito.Mockito._
import org.mockito.BDDMockito._
import org.mockito.Matchers._

class CardGameSpecs {

  @Test
  def itPlaysASingleRound() {

    //given
    val shuffledDeck = DeckBuilder buildStandardDeck() shuffle

    val playerOne = mock (classOf [Player])
    val playerTwo = mock (classOf [Player])
    val playerThree = mock (classOf [Player])
    val playerFour = mock (classOf [Player])

    given (playerOne showCard) willReturn new Card(Diamond, Two)
    given (playerTwo showCard) willReturn new Card(Spade, Ace)
    given (playerThree showCard) willReturn new Card(Club, King)
    given (playerFour showCard) willReturn new Card(Heart, Four)

    val players = List(playerOne, playerTwo, playerThree, playerFour)
    val game = new CardGame(players, shuffledDeck)



    //when
    val winner = game playRound

    //then
    assert (winner equals playerOne)
  }



  @Test
  def itPlaysGameOfFiveRounds() {

    //given

    val playerOne = mock (classOf [Player])
    val playerTwo = mock (classOf [Player])
    val playerThree = mock (classOf [Player])
    val playerFour = mock (classOf [Player])


    given (playerOne showCard) willReturn new Card(Diamond, Two) willReturn new Card(Club, Ace) willReturn new Card(Heart, Queen) willReturn new Card(Diamond, Three) willReturn new Card(Spade, Jack)
    given (playerTwo showCard) willReturn new Card(Spade, Ace) willReturn new Card(Heart, King) willReturn new Card(Heart, Two) willReturn new Card(Spade, Ace) willReturn new Card(Club, Jack)
    given (playerThree showCard) willReturn new Card(Club, King) willReturn new Card(Diamond, Three) willReturn new Card(Heart, Three) willReturn new Card(Spade, Six) willReturn new Card(Heart, Jack)
    given (playerFour showCard) willReturn new Card(Heart, Four) willReturn new Card(Diamond, Five) willReturn new Card(Heart, Five) willReturn new Card(Diamond, Eight) willReturn new Card(Diamond, Jack)

    val players = List(playerOne, playerTwo, playerThree, playerFour)
    val shuffledDeck = DeckBuilder buildStandardDeck() shuffle

    val game = new CardGame(players, shuffledDeck)

    //when
    val winner = game play


    //then
    assert (winner equals playerOne)
  }
}
