package edu.luc.cs.laufer.cs473.shapealgebra

import java.awt.Color

/*
 * Some additional shape classes added later.
 */

// TODO: your job (avoid inheritance among case classes)

case class Point(x: Int, y: Int) extends Shape

case class Circle(radius: Int) extends Shape {
  require(radius > 0)
}

case class Polygon(points: Point*) extends Shape {
  require(points != null)
  require(points.size > 0)
  require(!points.contains(null))
}

case class Stroke(color: Color, shape: Shape) extends Shape {
  require(color != null)
  require(shape != null)
}

case class Fill(shape: Shape) extends Shape {
  require(shape != null)
}

case class Outline(shape: Shape) extends Shape {
  require(shape != null)
}

case class Rotate(r: Double, shape: Shape) extends Shape {
  require(shape != null)
}