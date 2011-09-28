package edu.luc.cs.laufer.cs473.shapealgebra

  
object ExtendedShapeSize extends ExtendedShapeAlgebra[Int] {
  // forward methods for original shapes at object level
  override def visitEllipse(e: Ellipse) = ShapeSize.visitEllipse(e)
  // TODO: methods for the other original shapes
  // new methods for extended shapes
  override def visitRectangle(r: Rectangle) = ShapeSize.visitRectangle(r)
  override def visitLocation(r: Int, l: Location) = ShapeSize.visitLocation(r, l)
  override def visitGroup(rs: Seq[Int], g: Group) = ShapeSize.visitGroup(rs, g)
  
  override def visitStroke(r: Int, s: Stroke) = r
  // TODO: methods for the other additional (extended) shapes
  override def visitPoint(p : Point) = 1
  override def visitCircle(c : Circle) = 1
  override def visitPolygon(p: Polygon) = 1
  override def visitFill(r: Int, f : Fill) = r
  override def visitOutline(r: Int,o : Outline) = r
  override def visitRotate(r: Int, T: Rotate) = r 
}

/*
object ExtendedShapeDepth extends ExtendedShapeAlgebra[Int] {
  // TODO: all methods defined from scratch
}

class ExtendedBoundingBox extends BoundingBox with ExtendedShapeAlgebra[Location] {
  // methods for original shapes inherited at class level
  // TODO: methods for the other additional (extended) shapes
  override def visitStroke(r: Location, s: Stroke) = r
  // TODO: reduce Circle to Ellipse (avoid code duplication)
  // etc.
}


object ExtendedBoundingBox extends ExtendedBoundingBox
*/

