package edu.luc.cs.laufer.cs473.shapealgebra

import java.awt.Graphics

class Draw {
  def draw(g: Graphics)(s: Shape): Unit = s match {
    case Circle(r) => g.drawArc(-r, -r, 2 * r, 2 * r, 0, 360)
    case Rectangle(w, h) => g.drawRect(0, 0, w, h)
    // TODO: Location and Group
  }
}

object Draw extends Draw {
  def apply(g: Graphics) = draw(g)(_)
}