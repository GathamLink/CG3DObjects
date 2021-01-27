package objects3D;

import org.lwjgl.opengl.GL11;
import GraphicsObjects.Point4f;
import GraphicsObjects.Vector4f;

public class Cube {

	
	public Cube() {

	}
	
	// Implement using notes and examine Tetrahedron to aid in the coding  look at lecture  7 , 7b and 8 
	public void DrawCube() 
 {
		
		Point4f vertices[] = {
				new Point4f(-1.0f, -1.0f, -1.0f, 0.0f),
				new Point4f(-1.0f, -1.0f, 1.0f, 0.0f),
				new Point4f(-1.0f, 1.0f, -1.0f, 0.0f),
				new Point4f(-1.0f, 1.0f, 1.0f, 0.0f),
				new Point4f(1.0f, -1.0f, -1.0f, 0.0f),
				new Point4f(1.0f, -1.0f, 1.0f, 0.0f),
				new Point4f(1.0f, 1.0f, -1.0f, 0.0f),
				new Point4f(1.0f, 1.0f, 1.0f, 0.0f)
		};
		
		int[][]  triangles = {
				{0,1,3},
				{0,3,2},
				{1,0,4},
				{1,4,5},
				{0,2,4},
				{2,6,4},
				{5,4,6},
				{5,6,7},
				{1,5,7},
				{1,7,3},
				{2,3,7},
				{2,7,6}
		};

		/**
		 * 	Drawing principle:
		 * 			Before drawing, prepare the coordinates of vertices and the each triangle drawing coordinates.
		 * 			After that, firstly, calculate the normal vector for each face of cube that is able to achieve shadow on cube.
		 * 			Then, calculate each triangle on each face and draw each triangle.
		 * 			Finally, the cube has been created.
		 */
		GL11.glBegin(GL11.GL_TRIANGLES);	
		for (int face = 0; face < 12; face++) {
				Vector4f u = vertices[triangles[face][1]].MinusPoint(vertices[triangles[face][0]]);
				Vector4f v = vertices[triangles[face][2]].MinusPoint(vertices[triangles[face][0]]);
				//calculate the normal vector this plane
				Vector4f normal = u.cross(v).Normal();
				//the shadow of this plane
				GL11.glNormal3f(normal.x, normal.y, normal.z);
				
				//draw one triangle of this plane
				GL11.glVertex3f(vertices[triangles[face][0]].x, vertices[triangles[face][0]].y, vertices[triangles[face][0]].z);
				GL11.glVertex3f(vertices[triangles[face][1]].x, vertices[triangles[face][1]].y, vertices[triangles[face][1]].z);
				GL11.glVertex3f(vertices[triangles[face][2]].x, vertices[triangles[face][2]].y, vertices[triangles[face][2]].z);
			
			}
		
		GL11.glEnd();
	}
	
	
	
}
 
