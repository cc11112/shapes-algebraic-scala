package edu.luc.cs.laufer.cs473.shapealgebra

object ExtendedShapeSize extends ExtendedShapeAlgebra[Int] {
  // forward methods for original shapes at object level
  override def visitEllipse(e: Ellipse) = ShapeSize.visitEllipse(e)
  // TODO: methods for the other original shapes
  // new methods for extended shapes
  override def visitStroke(r: Int, s: Stroke) = r
  // TODO: methods for the other additional (extended) shapes
}

object ExtendedShapeDepth extends ExtendedShapeAlgebra[Int] {
  // TODO: all methods defined from scratch
}

class ExtendedBoundingBox extends BoundingBox with ExtendedShapeAlgebra[Location] {
  // methods for original shapes inherited at class level
  // TODO: methods for the other additional (extended) shapes
  override def visitStroke(r: Location, s: Stroke) = r
  // etc.
}

object ExtendedBoundingBox extends ExtendedBoundingBox