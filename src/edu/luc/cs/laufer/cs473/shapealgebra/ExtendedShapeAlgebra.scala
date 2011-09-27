package edu.luc.cs.laufer.cs473.shapealgebra

/**
 * The category of shape algebras extended to support additional shapes.
 */
trait ExtendedShapeAlgebra[R] extends ShapeAlgebra[R] {

  def visitPolygon(p: Polygon): R
  // TODO: add missing visit methods similarly to Location
  
  def visitStroke(r: R, s: Stroke): R = r match {
    case _ => sys.error("need do more thing here")
  }
   
  /**
   * The extended catamorphism for shapes.
   */
  override def fold(s: Shape): R = s match {
    case p: Polygon => visitPolygon(p)
    // TODO: add missing cases similarly to Location
    case _ => super.fold(s)
  }
}
