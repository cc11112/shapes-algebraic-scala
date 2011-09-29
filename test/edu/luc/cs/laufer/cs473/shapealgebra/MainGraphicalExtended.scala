package edu.luc.cs.laufer.cs473.shapealgebra

import scala.swing._

import java.awt.{Point => AWTPoint,Color,Dimension,Graphics2D}

import TestFixturesExtended._


object MainGraphicalExtended {
  def main(args : Array[String]) { }

  val s = extendedGroupRotate
//  val s = Rotate(190, Location(100, 100, Ellipse(200, 100)))
  val b @ Location(x, y, Rectangle(w, h)) = ExtendedBoundingBox(s)
  println("shape = " + s)
  println("bounding box = " + b)
  val padding = 20

  val f = new MainFrame {
    override def closeOperation() { System.exit(0) }
    title = "drawn by ExtendedDraw function"
    location = new AWTPoint(0, 0)
    contents = new Panel {
      preferredSize = new Dimension(w + 2 * padding, h + 2 * padding)
	  override def paint(g: Graphics2D) = {
		g.translate(-x + padding, -y + padding)
		ExtendedDraw(g)(s)
		ExtendedDraw(g)(b)
	  }
    }
	pack()
	visible = true
  }

  // now draw the same complex group of shapes by hand
  // (without the bounding box)
  val top2 = new MainFrame {
    override def closeOperation() { System.exit(0) }
    title = "drawn directly"
    location = new AWTPoint(w + 2 * padding, 0)
    contents = new Panel {
      preferredSize = new Dimension(512 + 2 * padding, 567 + 2 * padding)
	  override def paint(g: Graphics2D) = {
    	g.translate(239, -53)
   		paintExtendedGroupRotate(g)
	  }
    }
	pack()
	visible = true
  }
}

