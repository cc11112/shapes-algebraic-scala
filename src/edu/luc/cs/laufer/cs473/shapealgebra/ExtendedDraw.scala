package edu.luc.cs.laufer.cs473.shapealgebra

import java.awt.Graphics

class ExtendedDraw extends Draw {

  override def draw(g: Graphics)(s: Shape): Unit = s match {
    // TODO: cases for the additional shapes
    case _ => super.draw(g)(s)
  }

  def fill(g: Graphics)(s: Shape): Unit = s match {
    case Circle(r) => g.fillArc(-r, -r, 2 * r, 2 * r, 0, 360)
    case Rectangle(w, h) => g.fillRect(0, 0, w, h)
    case _ => draw(g)(s)
  }
}

object ExtendedDraw extends ExtendedDraw {
  def apply(g: Graphics) = draw(g)(_)
}