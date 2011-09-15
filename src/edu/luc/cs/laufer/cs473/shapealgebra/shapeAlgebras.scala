package edu.luc.cs.laufer.cs473.shapealgebra

object ShapeSize extends ShapeAlgebra[Int] {
  override def visitCircle(c: Circle) = 1
  override def visitRectangle(r: Rectangle) = 1
  override def visitLocation(r: Int, l: Location) = r
  override def visitGroup(rs: Seq[Int], g: Group) = rs.reduceLeft(_+_)
}

class BoundingBox extends ShapeAlgebra[Location] {
  override def visitCircle(c: Circle) =
    Location(-c.radius, -c.radius, Rectangle(2 * c.radius, 2 * c.radius))
  override def visitRectangle(r: Rectangle) =
    Location(0, 0, r)
  override def visitLocation(b: Location, l: Location) = {
    Location(l.x + b.x, l.y + b.y, b.shape)
  }
  override def visitGroup(rs: Seq[Location], g: Group) = {
	throw new UnsupportedOperationException("nyi")
  }
}

object BoundingBox extends BoundingBox