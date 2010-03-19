package edu.luc.cs.laufer.cs473.shapealgebra

import java.awt.{Dimension,Graphics}
import javax.swing.{JFrame,JPanel}

import TestFixtures.complexGroup

object MainGraphical {
  def main(args : Array[String]) : Unit = {
	val s = complexGroup
    val b @ Location(x, y, Rectangle(w, h)) = BoundingBox(s)
    println("shape = " + s)
    println("bounding box = " + b)
	val f = new JFrame
	f.setTitle("drawn by Draw function")
    f.setLocation(0, 0)
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
	val padding = 20
	val p = new JPanel {
	  override def paintComponent(g: Graphics) {
		g.translate(-x + padding, -y + padding)
		Draw(g)(s)
		Draw(g)(b)
	  }
	}
	p.setPreferredSize(new Dimension(w + 2 * padding, h + 2 * padding))
	f.setContentPane(p)
	f.pack()
	f.setVisible(true)
	// now draw the same complex group of shapes by hand
	// (without the bounding box)
	val g = new JFrame
	g.setTitle("drawn directly")
    g.setLocation(w + 2 * padding, 0)
	g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
	val q = new JPanel {
	  override def paintComponent(g: Graphics) {
		g.translate(-10, -60)
		g.translate(50, 100)
		g.drawArc(-20, -20, 40, 40, 0, 360)
		g.drawRect(0, 0, 100, 200)
		g.drawRect(150, 50, 50, 30)
		g.drawRect(150, 50, 300, 60)
		g.translate(250, 250)
		g.drawArc(-50, -50, 100, 100, 0, 360)
	  }
	}
	q.setPreferredSize(new Dimension(470 + 2 * padding, 320 + 2 * padding))
	g.setContentPane(q)
	g.pack()
	g.setVisible(true)
  }
}
