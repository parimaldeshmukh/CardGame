package ee.scala.cardGame

import org.junit.Test
import org.junit.Assert

class CardSpecs {


  @Test
  def itComparesTwoCards() {

    //given
    val higherCard =  new Card(CardSuite.Diamond, CardFace.King)
    val lowerCard =  new Card(CardSuite.Diamond, CardFace.Five)

    //when
    val comparison:Int = higherCard.compareTo(lowerCard)

    //then
    Assert assertTrue (comparison > 0)
  }

}
