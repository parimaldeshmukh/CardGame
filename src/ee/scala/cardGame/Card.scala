package ee.scala.cardGame

class Card(suite1: CardSuite.Value, value1: CardFaceValue.Value) {
  val suite = suite1
  val value = value1

  def compareTo(suite: CardSuite.Value, value: CardFaceValue.Value): Int = {
    if ((this.suite compareTo suite) == 0) {
      return this.value compareTo value
    }
    -1
  }
}
