package edu.luc.cs.laufer.cs473.shapealgebra

import java.awt.Graphics2D

class Draw {
  def draw(g: Graphics2D)(s: Shape): Unit = s match {
    case Ellipse(hw, hh) => g.drawArc(-hw, -hh, 2 * hw, 2 * hh, 0, 360)
    case Rectangle(w, h) => g.drawRect(0, 0, w, h)
    // TODO: Location and Group
    case Location(x: Int, y: Int, shape: Shape) => {
      g.translate(x, y)
      draw(g)(shape)
      g.translate(-x, -y)
    }
    case Group(shapes @ _*) => {
      for (s <- shapes)
        draw(g)(s)
    }
  }
}

object Draw extends Draw {
  def apply(g: Graphics2D) = draw(g)(_)
}