package ee.scala.cardGame

class Card(suite: CardSuite.Value, face: CardFace.Value) {

  def compareTo(other: Card):Int = {
    val suiteComparison = suite compareTo(other getSuite)
    if (suiteComparison!=0) suiteComparison else face compareTo(other getFace)
  }

  def getSuite() : CardSuite.Value = {
    suite
  }
  def getFace() : CardFace.Value = {
    face
  }

}
