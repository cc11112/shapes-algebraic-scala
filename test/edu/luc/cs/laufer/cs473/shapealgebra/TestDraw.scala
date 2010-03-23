package edu.luc.cs.laufer.cs473.shapealgebra

import org.scalatest.FunSuite

import java.awt.image.BufferedImage

import TestFixtures.simpleLocation

class TestDraw extends FunSuite with BufferedImageEquality {
  test("simple") {
	val s = simpleLocation
	val i = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB)
	Draw(i.getGraphics())(s)
	val j = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB)
	val g = j.getGraphics()
	g.translate(70, 30)
	g.drawRect(0, 0, 80, 120)
	assertEquals(i, j)
  }
}
