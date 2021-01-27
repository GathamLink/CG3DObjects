package GraphicsObjects;



public class Vector4f {

	public float x=0;
	public float y=0;
	public float z=0;
	public float a=0;
	
	public Vector4f() 
	{  
		x = 0.0f;
		y = 0.0f;
		z = 0.0f;
		a = 0.0f;
	}
	 
	public Vector4f(float x, float y, float z,float a) 
	{ 
		this.x = x;
		this.y = y;
		this.z = z;
		this.a = a;
	}
	
	/**
	 * this method lets x,y,z,a value of a vector plus these values of an additional vector respectively to get a new vector.
	 * @param Additonal a new vector for calculation
	 * @return a vector as the result of a vector plus another vector
	 */
	public Vector4f PlusVector(Vector4f Additonal) 
	{ 
		
		this.x = this.x + Additonal.x;
		this.y = this.y + Additonal.y;
		this.z = this.z + Additonal.z;
		this.a = this.a + Additonal.a;
		
		return this;
		 
	} 
	
	/**
	 * this method lets x,y,z,a value of a vector minus these values of an additional vector respectively to get a new vector.
	 * @param Minus a vector for calculation
	 * @return a vector as the result of a vector minus another vector
	 */
	public Vector4f MinusVector(Vector4f Minus) 
	{ 
		 
		this.x = this.x - Minus.x;
		this.y = this.y - Minus.y;
		this.z = this.z - Minus.z;
		this.a = this.a - Minus.a;
		
		return this;
		
	}
	
	/**
	 * this method lets x,y,z,a value of a vector plus these values of an additional point respectively to get a new point.
	 * @param Additonal a point for calculation
	 * @return a point as the result of a vector plus a point 
	 */
	public Point4f PlusPoint(Point4f Additonal) 
	{ 
		
		return new Point4f(this.x + Additonal.x, this.y + Additonal.y, this.z + Additonal.z, this.a + Additonal.a);
	 
	} 
	//Do not implement Vector minus a Point as it is undefined 
	
	/**
	 * this method lets x,y,z,a value of a vector multiply scale number respectively to get a new vector
	 * @param scale a constant number as a scale to be multiplied by vector
	 * @return a new vector after previous vector multiply the scale number
	 */
	public Vector4f byScalar(float scale )
	{
		 
		this.x = this.x * scale;
		this.y = this.y * scale;
		this.z = this.z * scale;
		this.a = this.a * scale;
		
		return this;
		
	}
	
	/**
	 * this method lets x,y,z,a value of a vector become negative
	 * @return a direction negative vector for original vector
	 */
	public Vector4f  NegateVector()
	{
		
		this.x = - this.x;
		this.y = - this.y;
		this.z = - this.z;
		this.a = - this.a;
		
		return this;
		
	}
	
	/**
	 * the method calculate the length fo a vector
	 * @return the length of a vector
	 */
	public float length()
	{
		
		float length = (float) Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z + this.a * this.a);
		return length;
		
	}
	
	/**
	 * the method is to get the normal vector for a vector
	 * @return the normal length vector for a vector
	 */
	public Vector4f Normal()
	{
	 
		this.x = this.x / length();
		this.y = this.y / length();
		this.z = this.z / length();
		this.a = this.a / length();
		
		return this;
		
	} 
	
	/**
	 * the method is used to calculate the result of two vectors dot multiply.
	 * @param v another vector used to be calculate
	 * @return a result number of two vector dot multiply.
	 */
	public float dot(Vector4f v)
	{ 
		return ( this.x*v.x + this.y*v.y + this.z*v.z+ this.a*v.a);
	}
	
	// Implemented this for you to avoid confusion 
	// as we will not normally  be using 4 float vector  
	public Vector4f cross(Vector4f v)  
	{ 
    float u0 = (this.y*v.z - z*v.y);
    float u1 = (z*v.x - x*v.z);
    float u2 = (x*v.y - y*v.x);
    float u3 = 0; //ignoring this for now  
    return new Vector4f(u0,u1,u2,u3);
	}
 
}
	 
	   

/*

										MMMM                                        
										MMMMMM                                      
 										MM MMMM                                    
 										MMI  MMMM                                  
 										MMM    MMMM                                
 										MMM      MMMM                              
  										MM        MMMMM                           
  										MMM         MMMMM                         
  										MMM           OMMMM                       
   										MM             .MMMM                     
MMMMMMMMMMMMMMM                        MMM              .MMMM                   
MM   IMMMMMMMMMMMMMMMMMMMMMMMM         MMM                 MMMM                 
MM                  ~MMMMMMMMMMMMMMMMMMMMM                   MMMM               
MM                                  OMMMMM                     MMMMM            
MM                                                               MMMMM          
MM                                                                 MMMMM        
MM                                                                   ~MMMM      
MM                                                                     =MMMM    
MM                                                                        MMMM  
MM                                4 D                                      MMMMMM 
MM                                                                     MMMMMMMM 
MM                                                                  :MMMMMMMM   
MM                                                                MMMMMMMMM     
MM                                                              MMMMMMMMM       
MM                             ,MMMMMMMMMM                    MMMMMMMMM         
MM              IMMMMMMMMMMMMMMMMMMMMMMMMM                  MMMMMMMM            
MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM               ZMMMMMMMM              
MMMMMMMMMMMMMMMMMMMMMMMMMMMMM          MM$             MMMMMMMMM                
MMMMMMMMMMMMMM                       MMM            MMMMMMMMM                  
  									MMM          MMMMMMMM                     
  									MM~       IMMMMMMMM                       
  									MM      DMMMMMMMM                         
 								MMM    MMMMMMMMM                           
 								MMD  MMMMMMMM                              
								MMM MMMMMMMM                                
								MMMMMMMMMM                                  
								MMMMMMMM                                    
  								MMMM                                      
  								MM                                        
                             GlassGiant.com */