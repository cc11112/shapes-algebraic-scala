package edu.luc.cs.laufer.cs473.shapealgebra

import org.scalatest.FunSuite

import java.awt.{Color,Graphics}
import java.awt.image.BufferedImage

import TestFixturesExtended.{extendedGroup,paintExtendedGroup}

class TestExtendedDraw extends FunSuite with BufferedImageEquality {
  test("complex") {
	val s = extendedGroup
	val i = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB)
	ExtendedDraw(i.getGraphics())(s)
	val j = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB)
	paintExtendedGroup(j.getGraphics())
	assertEquals(i, j)
  }
}
