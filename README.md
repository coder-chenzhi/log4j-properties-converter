# What is this?

Quite simply, "log4j-properties-converter" converts the Log4J Properties file format to the corresponding Log4J XML format.

# How do I run it?

YOu have a couple of options when it comes to converting your properties files...

## The really easy way
By far the easiest way to is to use the Log4J to Properties web application at http://log4jprops2xml.royals.net.au. Paste your config into this web app,
and it gives you back your file in XML format. Too easy!


## The less easy way
You can also download the command-line interface version of the tool. This is useful if you don't trust the website version,
or you have a lot of files to convert and you want to script it up.

Get the binary distribution from the "Releases" page on Github. https://github.com/jroyals/log4j-properties-converter/releases

In order to run log4j-converter command-line interface you need

- Java version 1.6 or better

- Java must be on the path, or JAVA_HOME environment variable must be set

Once you have downloaded the distribution, unzip it. Then, run...

`log4j-convert -f <path to log4j.properties>`

When it has finished, the .properties file will stil be there but it will be joned by an equivalent XML file.


# License

Copyright (C) 2010 Jason Royals <log4j-converter@fragstealers.com>

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.
