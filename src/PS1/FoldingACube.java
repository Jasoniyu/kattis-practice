package PS1;

import java.util.Arrays;
import java.util.Scanner;

public class FoldingACube {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line1 = sc.nextLine();
		String line2 = sc.nextLine();
		String line3 = sc.nextLine();
		String line4 = sc.nextLine();
		String line5 = sc.nextLine();
		String line6 = sc.nextLine();
		int leftMost = Integer.MAX_VALUE;
		int rightMost = Integer.MIN_VALUE;
		for (int i = 0; i < 6; i++) {
			if (line1.charAt(i) == '#') {
				leftMost = Math.min(leftMost, i);
				rightMost = Math.max(rightMost, i);
			}
			if (line2.charAt(i) == '#') {
				leftMost = Math.min(leftMost, i);
				rightMost = Math.max(rightMost, i);
			}
			if (line3.charAt(i) == '#') {
				leftMost = Math.min(leftMost, i);
				rightMost = Math.max(rightMost, i);
			}
			if (line4.charAt(i) == '#') {
				leftMost = Math.min(leftMost, i);
				rightMost = Math.max(rightMost, i);
			}
			if (line5.charAt(i) == '#') {
				leftMost = Math.min(leftMost, i);
				rightMost = Math.max(rightMost, i);
			}
			if (line6.charAt(i) == '#') {
				leftMost = Math.min(leftMost, i);
				rightMost = Math.max(rightMost, i);
			}
		}
		int topMost;
		int bottomMost;
		if (line1.contains("#")) {
			topMost = 0;
		} else if (line2.contains("#")) {
			topMost = 1;
		} else if (line3.contains("#")) {
			topMost = 2;
		} else if (line4.contains("#")) {
			topMost = 3;
		} else if (line5.contains("#")) {
			topMost = 4;
		} else {
			topMost = 5;
		}
		if (line6.contains("#")) {
			bottomMost = 5;
		} else if (line5.contains("#")) {
			bottomMost = 4;
		} else if (line4.contains("#")) {
			bottomMost = 3;
		} else if (line3.contains("#")) {
			bottomMost = 2;
		} else if (line2.contains("#")) {
			bottomMost = 1;
		} else {
			bottomMost = 0;
		}
		int height = bottomMost-topMost+1;
		int width = rightMost-leftMost+1;
		String[] rows = {line1, line2, line3, line4, line5, line6};
		char[][] smaller = new char[height][width];
		for (int i = topMost; i <= bottomMost; i++) {
			for (int j = leftMost; j <= rightMost; j++) {
				smaller[i-topMost][j-leftMost] = rows[i].charAt(j);
			}
		}
		if (height == 6 || width == 6) {
			System.out.println("cannot fold");
			return;
		} else {
			char[][][] nets = {
					{{'#', '#', '#'}, {'.', '#', '.'}, {'.', '#', '.'}, {'.', '#', '.'}},
					{{'#', '#', '.'}, {'.', '#', '#'}, {'.', '#', '.'}, {'.', '#', '.'}},
					{{'#', '#', '.'}, {'.', '#', '.'}, {'.', '#', '#'}, {'.', '#', '.'}},
					{{'#', '#', '.'}, {'.', '#', '.'}, {'.', '#', '.'}, {'.', '#', '#'}},
					{{'#', '.', '.'}, {'#', '#', '#'}, {'.', '#', '.'}, {'.', '#', '.'}},
					{{'#', '.', '.'}, {'#', '#', '.'}, {'.', '#', '#'}, {'.', '#', '.'}},
					{{'#', '.', '.'}, {'#', '#', '.'}, {'.', '#', '.'}, {'.', '#', '#'}},
					{{'#', '.', '.'}, {'#', '#', '.'}, {'.', '#', '#'}, {'.', '.', '#'}},
					{{'.', '#', '.'}, {'#', '#', '#'}, {'.', '#', '.'}, {'.', '#', '.'}},
					{{'.', '#', '.'}, {'#', '#', '.'}, {'.', '#', '#'}, {'.', '#', '.'}},
					{{'#', '.'}, {'#', '.'}, {'#', '#'}, {'.', '#'}, {'.', '#'}}};
			for (char[][] net : nets) {
				if (areIsomorphisms(smaller, net)) {
					System.out.println("can fold");
					return;
				}
			}
		}
		System.out.println("cannot fold");
	}
	
	public static boolean areIsomorphisms(char[][] input, char[][] net) {
		char[][] orientation1 = net;
		char[][] orientation2 = rotateCW(orientation1);
		char[][] orientation3 = rotateCW(orientation2);
		char[][] orientation4 = rotateCW(orientation3);
		char[][] orientation5 = reverse(net);
		char[][] orientation6 = rotateCW(orientation5);
		char[][] orientation7 = rotateCW(orientation6);
		char[][] orientation8 = rotateCW(orientation7);
		return (Arrays.deepEquals(input, orientation1) || Arrays.deepEquals(input, orientation2) ||
				Arrays.deepEquals(input, orientation3) || Arrays.deepEquals(input, orientation4) ||
				Arrays.deepEquals(input, orientation5) || Arrays.deepEquals(input, orientation6) ||
				Arrays.deepEquals(input, orientation7) || Arrays.deepEquals(input, orientation8));
	}
	
	public static char[][] rotateCW(char[][] mat) {
	    final int M = mat.length;
	    final int N = mat[0].length;
	    char[][] ret = new char[N][M];
	    for (int r = 0; r < M; r++) {
	        for (int c = 0; c < N; c++) {
	            ret[c][M-1-r] = mat[r][c];
	        }
	    }
	    return ret;
	}
	
	public static char[][] reverse(char[][] mat) {
		char[][] ret = new char[mat.length][mat[0].length];
		for(int i = 0; i < mat.length; i++)
			  for(int j = 0; j < mat[i].length; j++)
			    ret[i][j] = mat[i][j];
		for(int j = 0; j < ret.length; j++) {
		    for(int i = 0; i < ret[j].length / 2; i++) {
		        char temp = ret[j][i];
		        ret[j][i] = ret[j][ret[j].length - i - 1];
		        ret[j][ret[j].length - i - 1] = temp;
		    }
		}
		return ret;
	}
}
