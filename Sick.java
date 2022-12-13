package hihi;

import java.util.Random;


public class Sick extends Healthy 
{
	int time;
    Random random = new Random();

    public Sick(int x, int y)
    {
        super(x,y);
        time = 6;
    }

    public void transform(Field field) //траснформация в здоровую по истечении времени, а до этого заражение соседних
    {
        if (time>1)
        {
            time--;
            infect(field);
            return;
        }
        field.set(x, y, new Immune(x,y));
    }
    public void infect(Field field) //заражение соседней клетки на поле
    {  
    	if (random.nextBoolean())
    	{
    		if (x-1>=0 && !(field.get(x-1,y) instanceof Sick))
    		{
    			field.set(x-1, y, new Sick(x-1,y));
    			return;
    		}
    		if (this.x+1<field.n && !(field.get(x+1,y) instanceof Sick))
    		{
    			field.set(x+1, y,new Sick(x+1,y));
    			return;
    		}
    		if (y-1>=0 && !(field.get(x,y-1) instanceof Sick))
    		{
    			field.set(x, y-1,new Sick(x,y-1));
    			return;
    		}
    		if (this.y+1<field.n && !(field.get(x,y+1) instanceof Sick))
    		{
    			field.set(x, y+1,new Sick(x,y+1));
    			return;
    		}
    		if (this.y+1<field.n && this.x+1<field.n && !(field.get(x+1,y+1) instanceof Sick))
    		{
    			field.set(x+1, y+1,new Sick(x+1,y+1));
    			return;
    		}
    		if (this.y-1>=0 && this.x+1<field.n && !(field.get(x+1,y-1) instanceof Sick))
    		{
    			field.set(x+1, y-1,new Sick(x+1,y-1));
    			return;
    		}
    		if (this.y+1<field.n && this.x-1>=0 && !(field.get(x-1,y+1) instanceof Sick))
    		{
    			field.set(x-1, y+1,new Sick(x-1,y+1));
    			return;
    		}
    		if (this.y-1>=0 && this.x-1>=0 && !(field.get(x-1,y-1) instanceof Sick))
    		{
    			field.set(x-1, y-1, new Sick(x-1,y-1));
    			return;
    		}
    	}
    }

    public void print() 
    {
        System.out.print("-");
    }
}
