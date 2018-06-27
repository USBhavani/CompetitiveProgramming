class Rectangle 
{

    Integer ltX;
    Integer bmY;

    Integer w;
    Integer h;

    public Rectangle(Integer ltX, Integer bmY, Integer w, Integer h) 
    {
        this.ltX = ltX;
        this.bmY = bmY;
        this.w  = w;
        this.h = h;
    }

    public String toString() 
    {
        return String.format("(%d, %d, %d, %d)", ltX, bmY, w, h);
    }
}