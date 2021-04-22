# Array-Assorted-Complexities
New kind of Array implementation that keeps track of how many read and write operations have been performed on it.

This describes an object that can collect statistics about itself. After such object has been “in use” for a while, we can check how many read and write operations it has been asked to perform. We can also tell it to “forget” what has happened before and start counting both kinds of operations from zero again.

Class MeasurableArray extends simple array and also implements the Measurable interface at the same time.

Unit tests cases trigger various possible outcomes testing effectiveness.
