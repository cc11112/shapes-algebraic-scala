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


object ExtendedShapeDepth extends ExtendedShapeAlgebra[Int] {
  // TODO: all methods defined from scratch
  override def visitEllipse(e: Ellipse) = 1
  override def visitRectangle(r: Rectangle) = 1
  override def visitLocation(r: Int, l: Location) = 1 + fold(l.shape)
  override def visitGroup(rs: Seq[Int], g: Group) = 1 + g.shapes.map(s => fold(s)).toList.max
  override def visitStroke(r: Int, s: Stroke) = 1 + fold(s.shape)
  override def visitPoint(p : Point) = 1
  override def visitCircle(c : Circle) = 1
  override def visitPolygon(p: Polygon) = 1
  override def visitFill(r: Int, f : Fill) = 1 + fold(f.shape)
  override def visitOutline(r: Int,o : Outline) = 1 + fold(o.shape)
  override def visitRotate(r: Int, T: Rotate) = 1  + fold(T.shape)
  
}

/*
class ExtendedBoundingBox extends BoundingBox with ExtendedShapeAlgebra[Location] {
  // methods for original shapes inherited at class level
  // TODO: methods for the other additional (extended) shapes
  override def visitStroke(r: Location, s: Stroke) = r
  // TODO: reduce Circle to Ellipse (avoid code duplication)
  // etc.
}


object ExtendedBoundingBox extends ExtendedBoundingBox
*/


