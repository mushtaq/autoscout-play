package data

import scala.io.Source

object AliceData {
  val bookText = Source.fromFile("/Users/mushtaq/projects/workshops/sony-workshop/assignments/aliceInWonderland.txt").mkString
  val stopWordText = Source.fromFile("/Users/mushtaq/projects/workshops/sony-workshop/assignments/stopWords.txt").mkString
}
