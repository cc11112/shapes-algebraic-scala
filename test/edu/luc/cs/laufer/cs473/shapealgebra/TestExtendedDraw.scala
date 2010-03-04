package edu.luc.cs.laufer.cs473.shapealgebra

import org.scalatest.FunSuite

import java.awt.{Color,Graphics}
import java.awt.image.BufferedImage

class TestExtendedDraw extends FunSuite with BufferedImageEquality {
  test("complex") {
	val s = Location(50, 100,
		Group(
			Circle(20),
			Rectangle(100, 200),
			Location(150, 50,
				Stroke(Color.RED,
					Group(
						Fill(Rectangle(50, 30)),
						Rectangle(300, 60),
						Location(100, 200,
							Stroke(Color.ORANGE,
								Fill(Circle(50))
							)
						)
					)
				)
			)
		)
	)
	val i = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB)
	ExtendedDraw(i.getGraphics())(s)
	val j = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB)
	val g = j.getGraphics()
	g.translate(50, 100)
	g.drawArc(-20, -20, 40, 40, 0, 360)
	g.drawRect(0, 0, 100, 200)
	g.setColor(Color.RED)
	g.fillRect(150, 50, 50, 30)
	g.drawRect(150, 50, 300, 60)
	g.setColor(Color.ORANGE)
	g.translate(250, 250)
	g.fillArc(-50, -50, 100, 100, 0, 360)
	assertEquals(i, j)
  }
}
