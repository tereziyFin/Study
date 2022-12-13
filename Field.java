package hihi;

public class Field 
{
    private Healthy mas1[][]; //нынешнее состояние
    private Healthy mas2[][]; //переходное состояние дабы избежать трансформации только что зараженной клетки
    
    int n = 21;
    
    public Field() 
    {
        mas1 = new Healthy[n][n];
        mas2 = new Healthy[n][n];

        for (int i = 0; i < n; i++) 
            for (int j = 0; j < n; j++) 
            {
                mas1[i][j] = new Healthy(i,j);
                mas2[i][j] = new Healthy(i,j);
            }
        this.Init();
    }

    private void Init() 
    {
        mas1[n/2][n/2] = new Sick(n/2, n/2);
        mas2[n/2][n/2] = new Sick(n/2, n/2);
    }

    public void update()
    {
        for (int i = 0; i < n; i++) 
            for (int j = 0; j < n; j++) 
                  mas1[i][j].transform(this);
        this.copy();
    }
    private void copy()
    {
    	for (int i = 0; i < n; i++)
    		for (int j = 0; j < n; j++)
    			mas1[i][j] = mas2[i][j];
    }
    public Healthy get (int x, int y)
    {
    	return mas1[x][y];
    }

    public void set(int x, int y, Healthy cell) 
    {
        this.mas2[x][y] = cell;
    }


    public void print()
    {
        for (int i = 0 ; i < n; i++) 
        {
            for (int j = 0; j < n; j++) 
                mas1[i][j].print();
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }
}
