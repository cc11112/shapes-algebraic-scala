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
    val xl = rs.map(_.x).reduceLeft(Math.min)
    val xr = rs.map((b: Location) => b.x + b.shape.asInstanceOf[Rectangle].width).reduceLeft(Math.max)
    val yd = rs.map(_.y).reduceLeft(Math.min)
    val yu = rs.map((b: Location) => b.y + b.shape.asInstanceOf[Rectangle].height).reduceLeft(Math.max)
    Location(xl, yd, Rectangle(xr - xl, yu - yd))
  }
}

object BoundingBox extends BoundingBox