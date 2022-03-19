import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PacmanWorld extends World
{

    private static final int WIDTH_WALL = 28;
    private static final int HEIGHT_WALL = 28;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public PacmanWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Wall wall = new Wall();

        for(int x = 50; x < 550; x+= WIDTH_WALL)
        {
            wall = new Wall();
            addObject(wall,x,30);
            wall = new Wall();
            addObject(wall,x,350);
        }

        for(int y = 58; y < 200; y+= HEIGHT_WALL)
        {
            wall = new Wall();
            addObject(wall,50,y);

            wall = new Wall();
            addObject(wall,526,y);
        }
        getBackground().setColor(greenfoot.Color.BLACK);
        getBackground().fill();
        SmallBall smallBall = new SmallBall();
        addObject(smallBall,265,165);
        Banana banana = new Banana();
        addObject(banana,113,281);
        Strawberry strawberry = new Strawberry();
        addObject(strawberry,286,93);
        Strawberry strawberry2 = new Strawberry();
        addObject(strawberry2,516,262);
        Cherry cherry = new Cherry();
        addObject(cherry,286,246);
        Cherry cherry2 = new Cherry();
        addObject(cherry2,410,119);
        Cherry cherry3 = new Cherry();
        addObject(cherry3,372,244);
        BigBall bigBall = new BigBall();
        addObject(bigBall,120,167);
        BigBall bigBall2 = new BigBall();
        addObject(bigBall2,374,77);
        BigBall bigBall3 = new BigBall();
        addObject(bigBall3,206,238);
        BigBall bigBall4 = new BigBall();
        addObject(bigBall4,375,170);
        BigBall bigBall5 = new BigBall();
        addObject(bigBall5,43,243);
        SmallBall smallBall2 = new SmallBall();
        addObject(smallBall2,200,98);
        SmallBall smallBall3 = new SmallBall();
        addObject(smallBall3,198,128);
        SmallBall smallBall4 = new SmallBall();
        addObject(smallBall4,196,165);
        SmallBall smallBall5 = new SmallBall();
        addObject(smallBall5,204,202);
        SmallBall smallBall6 = new SmallBall();
        addObject(smallBall6,250,207);
        SmallBall smallBall7 = new SmallBall();
        addObject(smallBall7,199,298);
        SmallBall smallBall8 = new SmallBall();
        addObject(smallBall8,465,211);
        SmallBall smallBall9 = new SmallBall();
        addObject(smallBall9,454,163);
        SmallBall smallBall10 = new SmallBall();
        addObject(smallBall10,408,280);
        SmallBall smallBall11 = new SmallBall();
        addObject(smallBall11,460,77);
        SmallBall smallBall12 = new SmallBall();
        addObject(smallBall12,308,312);
        SmallBall smallBall13 = new SmallBall();
        addObject(smallBall13,326,189);
        SmallBall smallBall14 = new SmallBall();
        addObject(smallBall14,339,123);

        Ballon ballon = new Ballon();
        addObject(ballon,414,196);

        PacmanHud hud = new PacmanHud();
        addObject(hud, 0, 0);

        Pacman pacman = new Pacman(hud);
        addObject(pacman, 110, 90);

    }
}
