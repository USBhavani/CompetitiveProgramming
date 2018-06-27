import java.lang.Math;

public class Intersect
{      
    public static void main(String[] args) 
    {
        Rectangle S = new Rectangle(1 ,1 , 6, 3);
        Rectangle T = new Rectangle(5, 2, 3, 6); 
        System.out.println(getIntersection(S, T)); 
    }
	
	static Rectangle getIntersection(Rectangle K, Rectangle L) 
    {
        Integer xA = K.ltX + K.w; 
        Integer xB = L.ltX + L.w;
        Integer yA = K.bmY + K.h; 
        Integer yB = L.bmY + L.h; 

        Integer lXi = Math.max(K.ltX, L.ltX); 
        Integer bYi = Math.max(K.bmY, L.bmY); 
        Integer wi = Math.min(xA, xB) - lXi; 
        Integer hi= Math.min(yA, yB) - bYi; 
        
        if (wi<0 || hi<0) 
            return new Rectangle(-1, -1, -1, -1);
        else 
            return new Rectangle(lXi, bYi, wi, hi); 
    }
}