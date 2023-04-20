"# lab-6-exception-and-file-handling" 
# ARXMLdude

This is a Java program that reads an Autosar XML file (.arxml), sorts the container elements according to their short names in ascending order, and writes the result to a new file with the same name as the original file but with "_mod" added before the file extension.

## Requirements

To run this program, you need to have Java installed on your system.

## Usage

You can run the program from the command line by executing the following command:

bash
java ARXMLdude <filename.arxml>


Where `<filename.arxml>` is the name of the Autosar XML file you want to process.

After running the program, a new file with the same name as the original file but with "_mod" added before the file extension will be created in the same directory as the original file. The sorted container elements will be written to this new file.

## Exceptions

The program can throw two exceptions:

### EmptyAutosarFileException

This exception is thrown when the input file is empty.

### NotVaildAutosarFileException

This exception is thrown when the input file does not have the ".arxml" extension.

## Class container

This class represents a container element in the Autosar XML file. It has three attributes: `uuid`, `shortname`, and `longname`. It implements the Comparable interface so that container elements can be sorted by their short names in ascending order. It also has a `wstring` method that writes the container element to a PrintWriter object.

## Author

This program was created by Mohamed Ayman.
