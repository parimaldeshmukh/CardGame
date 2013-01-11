package ee.scala.cardGame

import org.junit.Test
import org.junit.Assert

class CardSpecs {


  @Test
  def itComparesTwoCards() {

    //given
    val higherFaceCard =  new Card(CardSuite.Diamond, CardFace.King)
    val lowerFaceCard =  new Card(CardSuite.Diamond, CardFace.Five)

    val higherSuiteCard =  new Card(CardSuite.Diamond, CardFace.Four)
    val lowerSuiteCard =  new Card(CardSuite.Spade, CardFace.Five)

    //when
    val faceComparison:Int = higherFaceCard.compareTo(lowerFaceCard)
    val suiteComparison:Int = higherSuiteCard.compareTo(lowerSuiteCard)

    //then
    Assert assertTrue (faceComparison > 0)
    Assert assertTrue (suiteComparison > 0)
  }

}
