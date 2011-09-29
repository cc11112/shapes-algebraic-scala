package edu.luc.cs.laufer.cs473.shapealgebra

object ShapeSize extends ShapeAlgebra[Int] {
  override def visitEllipse(e: Ellipse) = 1
  override def visitRectangle(r: Rectangle) = 1
  override def visitLocation(r: Int, l: Location) = r
  override def visitGroup(rs: Seq[Int], g: Group) = rs.sum
}

class BoundingBox extends ShapeAlgebra[Location] {
  override def visitEllipse(e: Ellipse) =
    Location(-e.halfWidth, -e.halfHeight, Rectangle(2 * e.halfWidth, 2 * e.halfHeight))
  override def visitRectangle(r: Rectangle) =
    Location(0, 0, r)
  override def visitLocation(b: Location, l: Location) = {
    Location(l.x + b.x, l.y + b.y, b.shape)
  }
  override def visitGroup(rs: Seq[Location], g: Group) = {

    // TODO: implement based on algorithm from previous subproject

    val x: List[Int] = rs.map(s => List(s.x, s.x + s.shape.asInstanceOf[Rectangle].width))
      .flatMap(x => x).toList

    val y: List[Int] = rs.map(s => List(s.y, s.y + s.shape.asInstanceOf[Rectangle].height))
      .flatMap(y => y).toList

    new Location(x.min, y.min, new Rectangle(x.max - x.min, y.max - y.min))
  }
}

object BoundingBox extends BoundingBox