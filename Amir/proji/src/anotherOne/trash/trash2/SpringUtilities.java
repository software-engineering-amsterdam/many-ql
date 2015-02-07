// SpringUtilities.java


/*
SLIM Plotter application and curve fitting library for
combined spectral lifetime visualization and analysis.
Copyright (C) 2006-@year@ Curtis Rueden and Eric Kjellman.
9	
10	This program is free software; you can redistribute it and/or modify
11	it under the terms of the GNU General Public License as published by
12	the Free Software Foundation; either version 2 of the License, or
13	(at your option) any later version.
14	
15	This program is distributed in the hope that it will be useful,
16	but WITHOUT ANY WARRANTY; without even the implied warranty of
17	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
18	GNU General Public License for more details.
19	
20	You should have received a copy of the GNU General Public License
21	along with this program; if not, write to the Free Software
22	Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
23	*/

/*
26	 * Copyright (c) 1995 - 2008 Sun Microsystems, Inc.  All rights reserved.
27	 *
28	 * Redistribution and use in source and binary forms, with or without
29	 * modification, are permitted provided that the following conditions
30	 * are met:
31	 *
32	 *   - Redistributions of source code must retain the above copyright
33	 *   notice, this list of conditions and the following disclaimer.
34	 *
35	 *   - Redistributions in binary form must reproduce the above copyright
36	 *   notice, this list of conditions and the following disclaimer in the
37	 *   documentation and/or other materials provided with the distribution.
38	 *
39	 *   - Neither the name of Sun Microsystems nor the names of its
40	 *   contributors may be used to endorse or promote products derived
41	 *   from this software without specific prior written permission.
42	 *
43	 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
44	 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
45	 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
46	 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
47	 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
48	 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
49	 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
50	 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
51	 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
52	 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
53	 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
54	 */

package anotherOne.main.trash;

import java.awt.Component;
import java.awt.Container;

import javax.swing.Spring;
import javax.swing.SpringLayout;


/**
65	 * A 1.4 file that provides utility methods for
66	 * creating form- or grid-style layouts with SpringLayout.
67	 * These utilities are used by several programs, such as
68	 * SpringBox and SpringCompactGrid.
69	 *
70	 * <dl><dt><b>Source code:</b></dt>
71	 * <dd><a href="http://dev.loci.wisc.edu/trac/software/browser/trunk/projects/slim-plugin/src/main/java/loci/slim/ui/SpringUtilities.java">Trac</a>,
72	 * <a href="http://dev.loci.wisc.edu/svn/software/trunk/projects/slim-plugin/src/main/java/loci/slim/ui/SpringUtilities.java">SVN</a></dd></dl>
73	 */

//public class Test {


public class SpringUtilities {

	
/**
77	   * A debugging utility that prints to stdout the component's
78	   * minimum, preferred, and maximum sizes.
79	   */
public static void printSizes(Component c) {
System.out.println("minimumSize = " + c.getMinimumSize());
System.out.println("preferredSize = " + c.getPreferredSize());
System.out.println("maximumSize = " + c.getMaximumSize());
}

/**
87	   * Aligns the first <code>rows</code> * <code>cols</code>
88	   * components of <code>parent</code> in
89	   * a grid. Each component is as big as the maximum
90	   * preferred width and height of the components.
91	   * The parent is made just big enough to fit them all.
92	   *
93	   * @param rows number of rows
94	   * @param cols number of columns
95	   * @param initialX x location to start the grid at
96	   * @param initialY y location to start the grid at
97	   * @param xPad x padding between cells
98	   * @param yPad y padding between cells
99	   */
public static void makeGrid(Container parent,
int rows, int cols, int initialX, int initialY, int xPad, int yPad)
{
SpringLayout layout;
try {
layout = (SpringLayout) parent.getLayout();
}
catch (ClassCastException exc) {
System.err.println(
"The first argument to makeGrid must use SpringLayout.");
return;
}

Spring xPadSpring = Spring.constant(xPad);
Spring yPadSpring = Spring.constant(yPad);
Spring initialXSpring = Spring.constant(initialX);
Spring initialYSpring = Spring.constant(initialY);
int max = rows * cols;

//Calculate Springs that are the max of the width/height so that all
//cells have the same size.
Spring maxWidthSpring =
layout.getConstraints(parent.getComponent(0)).getWidth();
Spring maxHeightSpring =
layout.getConstraints(parent.getComponent(0)).getWidth();
for (int i = 1; i < max; i++) {
SpringLayout.Constraints cons =
layout.getConstraints(parent.getComponent(i));

maxWidthSpring = Spring.max(maxWidthSpring, cons.getWidth());
maxHeightSpring = Spring.max(maxHeightSpring, cons.getHeight());
}

//Apply the new width/height Spring. This forces all the
//components to have the same size.
for (int i = 0; i < max; i++) {
SpringLayout.Constraints cons =
layout.getConstraints(parent.getComponent(i));

cons.setWidth(maxWidthSpring);
cons.setHeight(maxHeightSpring);
}

//Then adjust the x/y constraints of all the cells so that they
//are aligned in a grid.
SpringLayout.Constraints lastCons = null;
SpringLayout.Constraints lastRowCons = null;
for (int i = 0; i < max; i++) {
SpringLayout.Constraints cons =
layout.getConstraints(parent.getComponent(i));
if (i % cols == 0) { //start of new row
lastRowCons = lastCons;
cons.setX(initialXSpring);
}
else { //x position depends on previous component
cons.setX(Spring.sum(lastCons.getConstraint(SpringLayout.EAST),
xPadSpring));
}

if (i / cols == 0) { //first row
cons.setY(initialYSpring);
}
else { //y position depends on previous row
cons.setY(Spring.sum(lastRowCons.getConstraint(SpringLayout.SOUTH),
yPadSpring));
}
lastCons = cons;
}

//Set the parent's size.
SpringLayout.Constraints pCons = layout.getConstraints(parent);
pCons.setConstraint(SpringLayout.SOUTH, Spring.sum(Spring.constant(yPad),
lastCons.getConstraint(SpringLayout.SOUTH)));
pCons.setConstraint(SpringLayout.EAST, Spring.sum(Spring.constant(xPad),
lastCons.getConstraint(SpringLayout.EAST)));
}

/* Used by makeCompactGrid. */
private static SpringLayout.Constraints getConstraintsForCell(
int row, int col, Container parent, int cols)
{
SpringLayout layout = (SpringLayout) parent.getLayout();
Component c = parent.getComponent(row * cols + col);
return layout.getConstraints(c);
}

/**
* Aligns the first <code>rows</code> * <code>cols</code>
188	   * components of <code>parent</code> in
189	   * a grid. Each component in a column is as wide as the maximum
190	   * preferred width of the components in that column;
191	   * height is similarly determined for each row.
192	   * The parent is made just big enough to fit them all.
193	   *
194	   * @param rows number of rows
195	   * @param cols number of columns
196	   * @param initialX x location to start the grid at
197	   * @param initialY y location to start the grid at
198	   * @param xPad x padding between cells
199	   * @param yPad y padding between cells
200	   */
public static void makeCompactGrid(Container parent,
int rows, int cols, int initialX, int initialY, int xPad, int yPad)
{
SpringLayout layout;
try {
layout = (SpringLayout)parent.getLayout();
}
catch (ClassCastException exc) {
System.err.println(
"The first argument to makeCompactGrid must use SpringLayout.");
return;
}

//Align all cells in each column and make them the same width.
Spring x = Spring.constant(initialX);
for (int c = 0; c < cols; c++) {
Spring width = Spring.constant(0);
for (int r = 0; r < rows; r++) {
width = Spring.max(width,
getConstraintsForCell(r, c, parent, cols).getWidth());
}
for (int r = 0; r < rows; r++) {
SpringLayout.Constraints constraints =
getConstraintsForCell(r, c, parent, cols);
constraints.setX(x);
constraints.setWidth(width);
}
x = Spring.sum(x, Spring.sum(width, Spring.constant(xPad)));
}

//Align all cells in each row and make them the same height.
Spring y = Spring.constant(initialY);
for (int r = 0; r < rows; r++) {
Spring height = Spring.constant(0);
for (int c = 0; c < cols; c++) {
height = Spring.max(height,
getConstraintsForCell(r, c, parent, cols).getHeight());
}
for (int c = 0; c < cols; c++) {
SpringLayout.Constraints constraints =
getConstraintsForCell(r, c, parent, cols);
constraints.setY(y);
constraints.setHeight(height);
}
y = Spring.sum(y, Spring.sum(height, Spring.constant(yPad)));
}

//Set the parent's size.
SpringLayout.Constraints pCons = layout.getConstraints(parent);
pCons.setConstraint(SpringLayout.SOUTH, y);
pCons.setConstraint(SpringLayout.EAST, x);
}

}