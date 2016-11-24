##Triangle assignment

>A program that will determine the type of a triangle. It should take the lengths of the triangle's three sides as input, and return whether the triangle is equilateral, isosceles or scalene.

***

###Define a triangle:

>Simple enough - A polygon that has 3 sides.

***

###Identify the properties of the triangle:

>A triangle has 3 sides which can be identified by the lengths of the sides.
>No sides length can be 0.
>A triangle is uniquely identified by its lengths. Its shape and size and other properties remain constant if the lengths don’t change. So the lengths of a triangle are sufficient to fully qualify a triangle

***

###Classification of triangles (for the purposes of this assignment)

1. **Equilateral triangle**: An equilateral triangle is one that has all sides equal
2. **Isosceles triangle**: An isosceles triangle is one in which two sides equal. (Here, one side remains UNEQUAL and so we WON'T maintain that an equilateral triangle is a special case of isosceles).
3. **Scalene triangle**: A scalene triangle is one in which all sides are uniquely different
Each of the above types are exclusive

***

### Design Considerations

> We won’t differentiate triangles based not the ORDER of the sides. So in our world a triangle that has lengths 3,4,5 is the same as the triangle that has 4,3,5 - which would make one look like the mirror image of the other in the same plane and will be equal.
> We will let triangle sides have negative values 
> The lengths can be decimal pointed numbers as they will be parsed to double values

***

###How to run the example?

>Download the git project. 
>After building the code with `mvn clean install`. Run the class `Runner.java` and follow instructions on the standard output

***

>Author: Chris Sekaran - Makes no claims to the geometric validity of the assumptions laid out above and is only making out assumptions for specific project related purposes.