# Paint Applet Project

## Project Description

The **Paint Applet** is a simple Java application where users can draw shapes such as lines, rectangles, and ovals, with features like color selection, fill styles, and a clear screen function. The application demonstrates the use of Object-Oriented Programming (OOP) principles, including inheritance, polymorphism, and encapsulation, to create modular and reusable code.

## OOP Concepts Used

### **1. Inheritance**
The `Shape` class is the base class for all shapes. Specific shapes like `Line`, `Rectangle`, and `Oval` inherit from this class and implement their own `draw()` method.

### **2. Polymorphism**
The `Shape` class defines an abstract `draw()` method. Each subclass (`Line`, `Rectangle`, `Oval`) overrides this method to provide specific drawing behavior. This allows the program to treat all shapes uniformly while still respecting their individual drawing logic.

### **3. Encapsulation**
Each shape class encapsulates its properties (color, position, size) and behavior (how it is drawn). This hides the implementation details from other parts of the program and allows for better organization and maintenance.

# Paint Applet Project

This is a simple paint application implemented in Java as an Applet. It allows users to draw different shapes (Line, Rectangle, and Oval) with various colors and fill styles (Solid and Dotted). The user can also clear the canvas with a button click.

## Features

- **Draw Shapes**: Users can choose between different shapes: 
  - Line
  - Rectangle
  - Oval

- **Choose Colors**: 
  - Red
  - Black
  - Green
  - Blue

- **Shape Fill Styles**: 
  - Solid Fill
  - Dotted Fill

- **Clear Screen**: The user can clear the entire canvas with a button click.

## Installation

To run this applet on your local machine, follow these steps:

1. Ensure you have the latest version of Java installed. You can download it from the [official Java website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
2. Save the `Paint.java` file in your working directory.
3. Compile the Java file using the following command:
   ```bash
   javac Paint.java
   appletviewer Paint.html


