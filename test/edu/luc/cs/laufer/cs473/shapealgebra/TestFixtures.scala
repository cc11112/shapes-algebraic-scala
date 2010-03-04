package edu.luc.cs.laufer.cs473.shapealgebra

object TestFixtures {

  val simpleCircle = Circle(50)

  val simpleRectangle = Rectangle(80, 120)

  val simpleLocation = Location(70, 30, Rectangle(80, 120))

  val simpleGroup = Group(
    Location(200, 100, Circle(50)),
	Location(400, 300, Rectangle(100, 50))
  )

  val complexGroup = Location(50, 100,
    Group(
	  Circle(20),
	  Location(150, 50,
        Group(
	      Rectangle(50, 30),
	      Rectangle(300, 60),
	      Location(100, 200,
	        Circle(50)
	      )
	    )
	  ),
      Rectangle(100, 200)
    )
  )
}
