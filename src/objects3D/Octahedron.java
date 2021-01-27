package objects3D;


import org.lwjgl.opengl.GL11;
import GraphicsObjects.Point4f;
import GraphicsObjects.Vector4f;

public class Octahedron {

	
	public Octahedron()
	{
		
	}
	
	
	// Implement using notes and examine Tetrahedron to aid in the coding  look at lecture  7 , 7b and 8 
	public void DrawOctahedron(){
		
		Point4f vertices[] = {
				new Point4f(0.0f, 0.0f, 1.0f, 0.0f),//0
				new Point4f(-1.0f, 0.0f, 0.0f, 0.0f),//1
				new Point4f(0.0f, 1.0f, 0.0f, 0.0f),//2
				new Point4f(0.0f, -1.0f, 0.0f, 0.0f),//3
				new Point4f(0.0f, 0.0f, -1.0f, 0.0f),//4
				new Point4f(1.0f, 0.0f, 0.0f, 0.0f),//5
		};
		
		int faces[][] = {
				{0, 2, 1},//face1
				{1, 0, 3},//face2
				{0, 3, 5},//face3
				{4, 2, 1},//face4
				{5, 2, 4},//face5
				{3, 5, 4},//face6
				{3, 4, 1},//face7
				{0, 5, 2},//face8
		};
		
		/**
		 * 	Drawing Principle;
		 * 			It is the same as Cube drawing principle.
		 */
		GL11.glBegin(GL11.GL_TRIANGLES);	
		for (int face = 0; face < faces.length; face++) {
				Vector4f u = vertices[faces[face][1]].MinusPoint(vertices[faces[face][0]]);
				Vector4f v = vertices[faces[face][2]].MinusPoint(vertices[faces[face][0]]);
				//calculate the normal vector this plane
				Vector4f normal = u.cross(v).Normal();
				//the shadow of this plane
				GL11.glNormal3f(normal.x, normal.y, normal.z);
				
				//draw one triangle of this plane
				GL11.glVertex3f(vertices[faces[face][0]].x, vertices[faces[face][0]].y, vertices[faces[face][0]].z);
				GL11.glVertex3f(vertices[faces[face][1]].x, vertices[faces[face][1]].y, vertices[faces[face][1]].z);
				GL11.glVertex3f(vertices[faces[face][2]].x, vertices[faces[face][2]].y, vertices[faces[face][2]].z);
			
			}
		
		GL11.glEnd();
		
	}
}
 