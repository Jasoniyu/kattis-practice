import java.util.Scanner;

public class SquareDeal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int h1 = sc.nextInt();
		int w1 = sc.nextInt();
		int h2 = sc.nextInt();
		int w2 = sc.nextInt();
		int h3 = sc.nextInt();
		int w3 = sc.nextInt();
		
		int area = (h1*w1) + (h2*w2) + (h3*w3);
		if (!(Math.abs(Math.sqrt((double) area) - Math.round(Math.sqrt((double) area))) < 1e-5)) {
			System.out.println("NO");
			return;
		}
		int sideLength = (int) Math.round(Math.sqrt((double) area));
		
		boolean found = false;
		
		if (h1 == sideLength) {
			int newWidth = sideLength - w1;
			if (smallerRectangle(sideLength, newWidth, h2, w2, h3, w3)) {
				found = true;
			}
		} 
		if (w1 == sideLength) {
			int newHeight = sideLength - h1;
			if (smallerRectangle(newHeight, sideLength, h2, w2, h3, w3)) {
				found = true;
			}
		}
		
		if (h2 == sideLength) {
			int newWidth = sideLength - w2;
			if (smallerRectangle(sideLength, newWidth, h1, w1, h3, w3)) {
				found = true;
			}
		} 
		if (w2 == sideLength) {
			int newHeight = sideLength - h2;
			if (smallerRectangle(newHeight, sideLength, h1, w1, h3, w3)) {
				found = true;
			}
		}
		
		if (h3 == sideLength) {
			int newWidth = sideLength - w3;
			if (smallerRectangle(sideLength, newWidth, h1, w1, h2, w2)) {
				found = true;
			}
		} 
		if (w3 == sideLength) {
			int newHeight = sideLength - h3;
			if (smallerRectangle(newHeight, sideLength, h1, w1, h2, w2)) {
				found = true;
			}
		}
		if (found) System.out.println("YES");
		else System.out.println("NO");
	}
	
	public static boolean smallerRectangle(int height, int width, int h1, int w1, int h2, int w2) {
		boolean flag = false;
				
		if (h1 == height) {
			if (isSameRectangle(height, width-w1, h2, w2)) flag = true;
		}
		if (w1 == height) {
			if (isSameRectangle(height, width-h1, h2, w2)) flag = true;
		}
		
		if (h2 == height) {
			if (isSameRectangle(height, width-w2, h1, w1)) flag = true;
		}
		if (w2 == height) {
			if (isSameRectangle(height, width-h2, h1, w1)) flag = true;
		}
		
		if (h1 == width) {
			if (isSameRectangle(height-w1, width, h2, w2)) flag = true;
		} 
		if (w1 == width) {
			if (isSameRectangle(height-h1, width, h2, w2)) flag = true;
		}
		
		if (h2 == width) {
			if (isSameRectangle(height-w2, width, h1, w1)) flag = true;
		} 
		if (w2 == width) {
			if (isSameRectangle(height-h2, width, h1, w1)) flag = true;
		}

		return flag;
	}
	
	public static boolean isSameRectangle(int height, int width, int h1, int w1) {
		return (height == h1 && width == w1 || height == w1 && width == h1);
	}

}
