package edu.luc.cs.laufer.cs473.shapealgebra

import scala.math
import scala.Tuple2;

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
  override def visitCircle(c: Circle) = 1
  override def visitPolygon(p: Polygon) = 1
  override def visitFill(r: Int, f: Fill) = r
  override def visitOutline(r: Int, o: Outline) = r
  override def visitRotate(r: Int, s: Rotate) = r
}

object ExtendedShapeDepth extends ExtendedShapeAlgebra[Int] {
  // TODO: all methods defined from scratch
  override def visitEllipse(e: Ellipse) = 1
  override def visitRectangle(r: Rectangle) = 1
  override def visitLocation(r: Int, l: Location) = 1 + r
  override def visitGroup(rs: Seq[Int], g: Group) = 1 + g.shapes.map(s => fold(s)).toList.max
  override def visitStroke(r: Int, s: Stroke) = 1 + r
  override def visitCircle(c: Circle) = 1
  override def visitPolygon(p: Polygon) = 1
  override def visitFill(r: Int, f: Fill) = 1 + r
  override def visitOutline(r: Int, o: Outline) = 1 + r
  override def visitRotate(r: Int, s: Rotate) = 1 + r

}

class ExtendedBoundingBox extends BoundingBox with ExtendedShapeAlgebra[Location] {
  // methods for original shapes inherited at class level
  override def visitEllipse(e: Ellipse) = super.visitEllipse(e)

  override def visitRectangle(r: Rectangle) = super.visitRectangle(r)

  override def visitLocation(b: Location, l: Location) = super.visitLocation(b, l)

  override def visitGroup(rs: Seq[Location], g: Group) = super.visitGroup(rs, g)
  // TODO: methods for the other additional (extended) shapes
  override def visitStroke(r: Location, s: Stroke) = r
  // TODO: reduce Circle to Ellipse (avoid code duplication)
  // etc.
  override def visitCircle(c: Circle) = visitEllipse(new Ellipse(c.radius, c.radius))

 // override def visitPoint(p: Point) = visitEllipse(new Ellipse(0, 0))

  override def visitPolygon(p: Polygon) = {

    val x: List[Int] = p.points.map(p => p.x).toList
    val y: List[Int] = p.points.map(p => p.y).toList

    //    val x: List[Int] = p.shapes.map(p => p.asInstanceOf[Point].x).toList
    //    val y: List[Int] = p.shapes.map(p => p.asInstanceOf[Point].y).toList

    new Location(x.min, y.min, new Rectangle(x.max - x.min, y.max - y.min))
  }

  override def visitFill(r: Location, f: Fill) = visitLocation(r, new Location(0, 0, f.shape))
  override def visitOutline(r: Location, o: Outline) = visitLocation(r, new Location(0, 0, o.shape))
  override def visitRotate(r: Location, t: Rotate) = {

    def calculateX(x0: Double, y0: Double, x: Double, y: Double, r: Double): Int =
      ((x - x0) * math.cos(r) - (y - y0) * math.sin(r) + x0).toInt

    def calculateY(x0: Double, y0: Double, x: Double, y: Double, r: Double): Int =
      ((x - x0) * math.sin(r) + (y - y0) * math.cos(r) + y0).toInt

    //default is rotate by (0,0)
    val x: Int = List(
      calculateX(0, 0, r.x, r.y, math.toRadians(t.r)),
      calculateX(0, 0, r.x, r.y + r.shape.asInstanceOf[Rectangle].height, math.toRadians(t.r)),
      calculateX(0, 0, r.x + r.shape.asInstanceOf[Rectangle].width, r.y, math.toRadians(t.r)),
      calculateX(0, 0, r.x + r.shape.asInstanceOf[Rectangle].width, r.y + r.shape.asInstanceOf[Rectangle].height, math.toRadians(t.r))).min

    val y: Int = List(
      calculateY(0, 0, r.x, r.y, math.toRadians(t.r)),
      calculateY(0, 0, r.x, r.y + r.shape.asInstanceOf[Rectangle].height, math.toRadians(t.r)),
      calculateY(0, 0, r.x + r.shape.asInstanceOf[Rectangle].width, r.y, math.toRadians(t.r)),
      calculateY(0, 0, r.x + r.shape.asInstanceOf[Rectangle].width, r.y + r.shape.asInstanceOf[Rectangle].height, math.toRadians(t.r))).min

    val w: Double = (math.abs(r.shape.asInstanceOf[Rectangle].width * math.cos(math.toRadians(t.r)))
      + math.abs(r.shape.asInstanceOf[Rectangle].height * math.sin(math.toRadians(t.r))))

    val h: Double = (math.abs(r.shape.asInstanceOf[Rectangle].height * math.cos(math.toRadians(t.r)))
      + math.abs(r.shape.asInstanceOf[Rectangle].width * math.sin(math.toRadians(t.r))))

    new Location(x, y,
      new Rectangle(w.toInt, h.toInt))
  }

}

object ExtendedBoundingBox extends ExtendedBoundingBox



