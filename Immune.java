package hihi;

public class Immune extends Sick 
{

    public Immune(int x, int y) 
    {
        super(x, y);
        time = 4;
    }

    public void transform(Field field) //трансформация в здоровую по истечении времени
    {
        if (time > 1)
        {
            time--;
            return;
        }
        field.set(x, y, new Healthy(x,y)); 
    }

    public void print()
    {
        System.out.print("+");
    }

}
