/*
    libdmtx-mobile - libdmtx port to Android and iOS

    Copyright (C) 2023 Freeletics

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
*/

package org.libdmtx;

/**
 *  java.awt.Point equivalent but for Android
 */
public class DMTXPoint {
    public int x;

    public int y;

    public DMTXPoint() {
        this(0, 0);
    }

    public DMTXPoint(DMTXPoint p) {
        this(p.x, p.y);
    }

    public DMTXPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public DMTXPoint getLocation() {
        return new DMTXPoint(x, y);
    }

    public void setLocation(DMTXPoint p) {
        setLocation(p.x, p.y);
    }

    public void setLocation(int x, int y) {
        move(x, y);
    }

    public void setLocation(double x, double y) {
        this.x = (int) Math.floor(x + 0.5);
        this.y = (int) Math.floor(y + 0.5);
    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void translate(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
}
