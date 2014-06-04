package mapDiscovery;

import lejos.nxt.LCD;

public class DMap {
    private char[][] mapData;
    private int xDim, yDim;
    private int unknown;
    

    /*_ - pole nieznane,
    - – pole bia³e,
    X – czerwone pole.*/
    
    public DMap() {
        this(5, 5);
    }
    
    public DMap(int x, int y) {
        xDim = x;
        yDim = y;
        mapData = new char[x][y];
        for (int i = 0; i < xDim; i++) {
            for (int j = 0; j < yDim; j++) {
                mapData[i][j] = '_';    // nil value
            }
        }
        unknown = xDim * yDim;
    }

    private void whiteAll() {
        for (int i = 0; i < xDim; i++) {
            for (int j = 0; j < yDim; j++) {
                if (mapData[i][j] == '_')
                    mapData[i][j] = '-';
            }
        }
        unknown = 0;
    }
    
    public void setField(int xPos, int yPos, char value) {
        if ((xPos < xDim) && (yPos < yDim)) {
            mapData[xPos][yPos] = value;
            unknown--;
        }
    }
    
    public void printOnDisplay() {
        LCD.clear();
        for (int i = 0; i < xDim; i++) {
            for (int j = 0; j < yDim; j++) {
                LCD.drawString("" + mapData[i][j], i, yDim - j - 1);
            }
        }
    }

    public boolean isUnknown(int pos_x, int pos_y) {
        return mapData[pos_x][pos_y] == '_';
    }

    public int unknownCount() {
        return unknown;
    }
    
    public int knownCount() {
        return xDim * yDim - unknown;
    }

    public String findAWay(int pos_x, int pos_y, int orient) {
        switch (orient) {
            case 0: if (pos_y == yDim - 1) {
                        return "lf";
                    } else {
                        return "f";
                    }
            case 1: return "rr";
            case 2: if (pos_y == 0) {
                        return "rf";
                    } else {
                        return "f";
                    }
            case 3: if (pos_y == yDim - 1) {
                        return "lf";
                    } else {
                        return "rf";
                    }
        };
        return "";
    }
    
    public Double[] getDoubleTab() {
        Double[] ret_val = new Double[yDim * xDim];
        int iter = 0;
        for (int i = yDim - 1; i >= 0; i--) {
            for (int j = 0; j < xDim; j++) {
                if (mapData[i][j] == '-') {
                    ret_val[iter] = 0.0d;
                } else {
                    ret_val[iter] = 1.0d;
                }
                iter++;
            }
        }
        return ret_val;
    }

	public void printOnDisplayD() {
        LCD.clear();
        for (int i = 0; i < xDim; i++) {
            for (int j = 0; j < yDim; j++) {
            	int next;
            	if (mapData[i][j] == '-')
            	    next = 0;
            	else next = 1;
                LCD.drawInt(next, i, yDim - j - 1);
            }
        }
	}
}
