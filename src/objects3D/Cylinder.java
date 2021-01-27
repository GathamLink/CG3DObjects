package objects3D;

import org.lwjgl.opengl.GL11;
import GraphicsObjects.Point4f;
import GraphicsObjects.Vector4f;
import java.math.*;

public class
Cylinder {

	
	public Cylinder() { 
	}
	
	// remember to use Math.PI isntead PI 
	// Implement using notes and examine Tetrahedron to aid in the coding  look at lecture  7 , 7b and 8 
	public void DrawCylinder(float radius, float height, int nSegments ) 
	{
		 
		//nSegments = 5000;
		float x1, y1, z1, x2, y2, z2;
		float unit = (float) ((2.0f * Math.PI) / nSegments);
		float distance = radius / nSegments;
		
		/**
		 * 	Drawing Principle:
		 * 			divide the surface into pieces of triangles.
		 * 			Then draw each triangle follow the increasing of angle that each small triangle occupies.
		 * 			Finally, the cylinder is created successfully.
		 */
		GL11.glBegin(GL11.GL_TRIANGLES);
		for (float i = 0; i < (2 * Math.PI); i += unit) {
			
			x1 = (float) (Math.cos(i) * radius);
			y1 = (float) (Math.sin(i) * radius);
			z1 = height / 2;
			x2 = (float) (Math.cos(i + unit) * radius);
			y2 = (float) (Math.sin(i + unit) * radius);
			z2 = - (height / 2);
			
			//Draw one triangle
			GL11.glNormal3f(x1, y1, 0);
			GL11.glVertex3f(x1, y1, z1);
			GL11.glNormal3f(x2, y2, 0);
			GL11.glVertex3f(x2, y2, z2);
			GL11.glNormal3f(x1, y1, 0);
			GL11.glVertex3f(x1, y1, z2);
			
			GL11.glNormal3f(x2, y2, 0);
			GL11.glVertex3f(x2, y2, z2);
			GL11.glNormal3f(x1, y1, 0);
			GL11.glVertex3f(x1, y1, z1);
			GL11.glNormal3f(x2, y2, 0);
			GL11.glVertex3f(x2, y2, z1);
			
		}
		GL11.glEnd();
		GL11.glBegin(GL11.GL_TRIANGLES);
		for (float phi = 0; phi <= (2 * Math.PI); phi += unit) {
			
			x1 = (float) (Math.cos(phi) * radius);
			y1 = (float) (Math.sin(phi) * radius);
			z1 = height / 2;
			x2 = (float) (Math.cos(phi + unit) * radius);
			y2 = (float) (Math.sin(phi + unit) * radius);
			z2 = - (height / 2);
			
			GL11.glNormal3f(0, 0, z1);
			GL11.glVertex3f(x1, y1, z1);
			GL11.glNormal3f(0, 0, z1);
			GL11.glVertex3f(x2, y2, z1);
			GL11.glNormal3f(0, 0, z1);
			GL11.glVertex3f(0, 0, z1);
			
			GL11.glNormal3f(0, 0, z2);
			GL11.glVertex3f(x1, y1, z2);
			GL11.glNormal3f(0, 0, z2);
			GL11.glVertex3f(x2, y2, z2);
			GL11.glNormal3f(0, 0, z2);
			GL11.glVertex3f(0, 0, z2);
		}
		GL11.glEnd();
	}
}
