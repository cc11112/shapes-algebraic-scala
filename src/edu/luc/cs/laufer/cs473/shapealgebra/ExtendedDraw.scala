package edu.luc.cs.laufer.cs473.shapealgebra

import java.awt.Graphics2D
import java.awt.Color

class ExtendedDraw extends Draw {

  override def draw(g: Graphics2D)(s: Shape): Unit = s match {
    // TODO: cases for the additional shapes
    // TODO: reduce Circle to Ellipse (avoid code duplication)
    case Circle(radius: Int) => draw(g)(new Ellipse(radius, radius))
    case Point(x: Int, y: Int) => g.drawLine(x, y, x, y)
    case Polygon(points: Seq[Point]) => {
      g.drawPolygon(points.map(s => s.x).toArray[Int], points.map(s => s.y).toArray[Int], points.size)
    }
    case Stroke(color: Color, shape: Shape) => {
      val lastColor: Color = g.getColor();
      g.setColor(color)
      draw(g)(shape)
      g.setColor(lastColor)
    }
    case Fill(shape: Shape) => fill(g)(shape)

    case _ => super.draw(g)(s)
  }

  def fill(g: Graphics2D)(s: Shape): Unit = s match {
    case Ellipse(hw, hh) => g.fillArc(-hw, -hh, 2 * hw, 2 * hh, 0, 360)
    case Rectangle(w, h) => g.fillRect(0, 0, w, h)
    // TODO: reduce Circle to Ellipse (avoid code duplication)
    case Circle(radius) => fill(g)(new Ellipse(radius, radius))
    case Polygon(points: Seq[Point]) =>
      g.fillPolygon(points.map(s => s.x).toArray[Int], points.map(s => s.y).toArray[Int], points.size)

    case _ => draw(g)(s)
  }
}

object ExtendedDraw extends ExtendedDraw {
  def apply(g: Graphics2D) = draw(g)(_)
}