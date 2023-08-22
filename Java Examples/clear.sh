#!/bin/bash

# Delete all .class files in the current directory
find . -name "*.class" -type f -delete

echo "All .class files in the current directory have been deleted."
