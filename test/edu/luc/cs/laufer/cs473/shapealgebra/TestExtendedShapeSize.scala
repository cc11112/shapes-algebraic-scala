package edu.luc.cs.laufer.cs473.shapealgebra

import org.scalatest.FunSuite

import TestFixturesExtended._

class TestExtendedShapeSize extends FunSuite {

  def test(description: String, s: Shape, d: Int): Unit = {
    test(description) {
	  assert(d === ExtendedShapeSize(s))
    }
  }

  test("simple stroke", simpleStroke, 1)
  test("simple fill", simpleFill, 1)
  test("simple outline", simpleOutline, 1)
  test("simple polygon", simplePolygon, 1)
  test("complex polygon", complexPolygon, 1)
  test("extended group", extendedGroup, 5)
}
