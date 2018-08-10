# BeginnersGuide
Currently I read the book [Java: A Beginner's Guide, Seventh Edition 7th Edition](https://www.amazon.com/Java-Beginners-Seventh-Herbert-Schildt/dp/1259589315) to enhance my Java skills. I use this repo to collect small applications and to play around.

## Packages
### UsingIO
The 10th chapter of the book deals with I/O in Java.

#### ByteConsoleInputAndOutput
Try out the classes System.in and System.out and the methods `int read()`, `int read(byte data[])`, `int read(byte data[], int start, int max)` and `void println(String x)`.

##### Methods
- readOneChar()
- readASequence()
- readASnippetOfTheSequence()
- buildStringOf()

#### ByteInput
Try out the class InputStream and the methods `int read()`, `int read(byte b[])` and `int available()`.

##### Methods
- getLengthOfInputStream()
- readOneByteOfInputStream()
- readAllBytesOfInputStream()
- readBytes()
- convertBytesToChars(byte allBytes[])
- display(byte[] allBytes, char[] allLetters)

#### ByteOutput
Try out the class OutputStream and the method `void write(int byteval)`.

##### Methods 
- replaceWithOneByte()
- replaceWith()

## How to set it up
Download or clone the repo. I use Eclipse, but other IDEs may work similar. Simply create a new project and import the repo in this project. Run the application with the functionality provided by the IDE.