package shapes;

import java.util.Scanner;

public class ShapeMaker {
	private Shape[] shapes;

	public ShapeMaker(){
		getShapes();
	}
	
	private void getShapes(){
		Scanner in = new Scanner(System.in);
		
	   	System.out.print("How many shapes? ");
		int numShapes = in.nextInt();

		shapes = new Shape[numShapes];
		
		for( int i = 0; i < numShapes; i++ ){
			System.out.print("What shape? ");
			String nextShape = in.next();
			
			if( nextShape.equals("rectangle") ){
				shapes[i] = new Rectangle(2, 10);
			}else if( nextShape.equals("square") ){
				shapes[i] = new Square(2);
			}else{
				shapes[i] = new Shape(nextShape);
			}
		}
	}
	
	public void printShapes(){
		for( int i = 0; i < shapes.length; i++ ){
			System.out.println(shapes[i]);
		}
	}
	
	public static void main(String[] args){
		ShapeMaker maker = new ShapeMaker();
		maker.printShapes();
	}
}