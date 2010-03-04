package edu.luc.cs.laufer.cs473.shapealgebra

import java.awt.Color

object TestFixturesExtended {

  val simpleStroke = Stroke(Color.ORANGE, Circle(50))

  val simpleFill = Fill(Rectangle(80, 120))

  val simpleOutline = Outline(Rectangle(80, 120))

  val simplePolygon = Polygon(
    Point(20, 20),
    Point(10, 80),
    Point(50, 110),
    Point(90, 70),
    Point(80, 10)
  )

  val complexPolygon = Location(30, 40,
    Stroke(Color.ORANGE,
      Fill(
        Polygon(
	      Point(20, 20),
	      Point(10, 80),
	      Point(50, 110),
	      Point(90, 70),
	      Point(80, 10)
        )
      )
    )
  )

  val extendedGroup = Location(50, 100,
	Group(
      Circle(20),
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
	  ),
	  Rectangle(100, 200)
	)
  )

}
