package edu.luc.cs.laufer.cs473.shapealgebra

/**
 * The category of shape algebras extended to support additional shapes.
 */
trait ExtendedShapeAlgebra[R] extends ShapeAlgebra[R] {
  
  def visitPolygon(p: Polygon): R
  // TODO: add missing visit methods similarly to Location
  def visitCircle(c: Circle): R
  def visitStroke(r: R, s: Stroke): R
  def visitFill(r: R, f: Fill): R
  def visitOutline(r: R, o: Outline): R
  def visitRotate(r: R, T: Rotate): R
  
  /**
   * The extended catamorphism for shapes.
   */
  override def fold(s: Shape): R = s match {
    // TODO: add missing cases similarly to Location
    case p: Polygon => visitPolygon(p)
    case c: Circle => visitCircle(c)
    case s: Stroke => visitStroke(fold(s.shape), s)
    case f: Fill => visitFill(fold(f.shape), f)
    case o: Outline => visitOutline(fold(o.shape), o)
    case r: Rotate => visitRotate(fold(r.shape), r)
    case _ => super.fold(s)
  }
}
