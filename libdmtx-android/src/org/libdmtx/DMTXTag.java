/*
Java wrapper for libdmtx

Copyright (C) 2009 Pete Calvert

Copyright (C) 2009 Dikran Seropian

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA

Contact: mike@dragonflylogic.com
*/

package org.libdmtx;

public class DMTXTag {
  /**
   * String value for the tag contents
   */
  public String id;

  /**
   * Corners are numbered from bottom left in an anti-clockwise fashion
   */
  public DMTXPoint corner1;
  public DMTXPoint corner2;
  public DMTXPoint corner3;
  public DMTXPoint corner4;

  public DMTXTag(final String aID, final DMTXPoint aCorner1, final DMTXPoint aCorner2, final DMTXPoint aCorner3, final DMTXPoint aCorner4) {
    id = aID;
    corner1 = aCorner1;
    corner2 = aCorner2;
    corner3 = aCorner3;
    corner4 = aCorner4;
  }
}
