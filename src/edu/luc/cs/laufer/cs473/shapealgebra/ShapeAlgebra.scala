package edu.luc.cs.laufer.cs473.shapealgebra

/**
 * The category of shape algebras.
 */
trait ShapeAlgebra[R] {

  def visitCircle(c: Circle): R
  def visitRectangle(r: Rectangle): R
  def visitLocation(r: R, l: Location): R
  def visitGroup(rs: Seq[R], g: Group): R

  /**
   * The catamorphism for shapes.
   */
  def fold(s: Shape): R = s match {
    case c: Circle => visitCircle(c)
    case r: Rectangle => visitRectangle(r)
    case l: Location => visitLocation(fold(l.shape), l)
    case g: Group => visitGroup(g.shapes.map(fold(_)), g)
  }

  def apply(s: Shape) = fold(s)
}
