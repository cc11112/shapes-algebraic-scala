package edu.luc.cs.laufer.cs473.shapealgebra

import java.awt.Graphics2D

class ExtendedDraw extends Draw {

  override def draw(g: Graphics2D)(s: Shape): Unit = s match {
    // TODO: cases for the additional shapes
	// TODO: reduce Circle to Ellipse (avoid code duplication)
  	case _ => super.draw(g)(s)
  }

  def fill(g: Graphics2D)(s: Shape): Unit = s match {
    case Ellipse(hw, hh) => g.fillArc(-hw, -hh, 2 * hw, 2 * hh, 0, 360)
    case Rectangle(w, h) => g.fillRect(0, 0, w, h)
    // TODO: reduce Circle to Ellipse (avoid code duplication)
    case Circle(radius) => Ellipse(radius, radius)
    case _ => draw(g)(s)
  }
}

object ExtendedDraw extends ExtendedDraw {
  def apply(g: Graphics2D) = draw(g)(_)
}