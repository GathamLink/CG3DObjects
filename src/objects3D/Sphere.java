package objects3D;

import org.lwjgl.opengl.GL11;

public class Sphere {

	
	public Sphere() {

	}
	// Implement using notes and examine Tetrahedron to aid in the coding  look at lecture  7 , 7b and 8 
	// 7b should be your primary source, we will cover more about circles in later lectures to understand why the code works 
	public void DrawSphere(float radius,float nSlices,float nSegments) {
	 
		float inctheta = (float) (2.0f * Math.PI / nSlices);
		float incphi = (float) (Math.PI / nSegments);
		
		/**
		 * 	Draw Principle:
		 * 			This principle is like drawing Cylinder.
		 * 			To draw a sphere, I draw the surface by dividing it into pieces of small squares.
		 * 			When drawing the sphere, I just draw a small square around a point each time.
		 * 			After repeating drawing many times, small squares have covered the surface of the sphere and a sphere has been created successfully.  	
		 */
		GL11.glBegin(GL11.GL_QUADS);
		for (float theta = (float) - Math.PI; theta < Math.PI; theta += inctheta) {
			for (float phi = (float) (- (Math.PI) / 2); phi < Math.PI / 2; phi += incphi) {
				
				//first point of square
				float x = (float) ((Math.cos(phi) * radius) * Math.cos(theta));
				float y = (float) ((Math.cos(phi) * radius) * Math.sin(theta));
				float z = (float) (Math.sin(phi) * radius);
				GL11.glNormal3f(x, y, z);
				GL11.glVertex3f(x, y, z);
				
				//second point of sqaure
				x = (float) ((Math.cos(phi + incphi) * radius) * Math.cos(theta));
				y = (float) ((Math.cos(phi + incphi) * radius) * Math.sin(theta));
				z = (float) (Math.sin(phi + incphi) * radius);
				GL11.glNormal3f(x, y, z);
				GL11.glVertex3f(x, y, z);
				
				//third point of square
				x = (float) ((Math.cos(phi + incphi) * radius) * Math.cos(theta + inctheta));
				y = (float) ((Math.cos(phi + incphi) * radius) * Math.sin(theta + inctheta));
				z = (float) (Math.sin(phi + incphi) * radius);
				GL11.glNormal3f(x, y, z);
				GL11.glVertex3f(x, y, z);
				
				//forth point of square
				x = (float) ((Math.cos(phi) * radius) * Math.cos(theta + inctheta));
				y = (float) ((Math.cos(phi) * radius) * Math.sin(theta + inctheta));
				z = (float) (Math.sin(phi) * radius);
				GL11.glNormal3f(x, y, z);
				GL11.glVertex3f(x, y, z);
				
			}
		}
		GL11.glEnd();
		
	}
}

 