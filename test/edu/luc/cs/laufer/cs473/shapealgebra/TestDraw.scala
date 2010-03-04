package edu.luc.cs.laufer.cs473.shapealgebra

import org.scalatest.FunSuite

import java.awt.image.BufferedImage

class TestDraw extends FunSuite with BufferedImageEquality {
  test("simple") {
	val s = Location(50, 100, Circle(20))
	val i = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB)
	Draw(i.getGraphics())(s)
	val j = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB)
	val g = j.getGraphics()
	g.translate(50, 100)
	g.drawArc(-20, -20, 40, 40, 0, 360)
	assertEquals(i, j)
  }
}
