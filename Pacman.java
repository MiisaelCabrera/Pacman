import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Pacman extends Actor
{
    private static final int OFFSET = 5;
    private static final int MAX_COUNTER_MOUTH = 10;
    private static final int MAX_COUNTER_MOVEMENT = 4;

    private static final int UP = 0;
    private static final int DOWN = 1;
    private static final int LEFT = 2;
    private static final int RIGHT = 3;

    private GreenfootImage []images;
    private GreenfootImage []images1;
    private GreenfootImage []images2;
    private GreenfootImage []images3;
    private int currentImage;
    private int counterMouth;
    private int counterMovement;
    private int offsetX = 0;
    private int offsetY = 0;
    private int direction=RIGHT;
    private int score;
    private PacmanHud pacmanHud;

    public Pacman(PacmanHud pacmanHud){
        images = new GreenfootImage[2];
        images[0] = new GreenfootImage("images/pacman-close.png");
        images[1] = new GreenfootImage("images/pacman-open.png");
        images1 = new GreenfootImage[2];
        images1[0] = new GreenfootImage("images/pacman-close-l.png");
        images1[1] = new GreenfootImage("images/pacman-open-l.png");
        images2 = new GreenfootImage[2];
        images2[0] = new GreenfootImage("images/pacman-close-u.png");
        images2[1] = new GreenfootImage("images/pacman-open-u.png");
        images3 = new GreenfootImage[2];
        images3[0] = new GreenfootImage("images/pacman-close-d.png");
        images3[1] = new GreenfootImage("images/pacman-open-d.png");
        this.pacmanHud = pacmanHud;
    }

    public void act()
    {

        openCloseMouth();

        movePacman();

        checkColissions();

    }

    private void checkColissions(){
        Item item = (Item)getOneIntersectingObject(Item.class);

        if(item != null){
            getWorld().removeObject(item);
            score += item.getScore();
            pacmanHud.setScore(score);
            
            if(getWorld().getObjects(Item.class).isEmpty()){
                offsetX = 0;
                offsetY = 0;
                getWorld().showText("You WIN!!", 300, 200);
            }
        }

    }

    private void openCloseMouth(){
        counterMouth++;

        if(counterMouth == MAX_COUNTER_MOUTH){
            counterMouth = 0;
            switch(direction)
            {
                case RIGHT: 
                    setImage(images[currentImage]);
                    setImage(images[currentImage]);
                break;
                case LEFT: 
                    setImage(images1[currentImage]);
                    setImage(images1[currentImage]);
                break;
                case UP: 
                    setImage(images2[currentImage]);
                    setImage(images2[currentImage]);
                break;
                case DOWN: 
                    setImage(images3[currentImage]);
                    setImage(images3[currentImage]);
                break;
            }
            currentImage = (currentImage + 1) % images.length;
        }
    }

    private void movePacman(){

        counterMovement++;

        if(counterMovement < MAX_COUNTER_MOVEMENT){
            return;
        }

        int currentX = getX();
        int currentY = getY();

        counterMovement = 0;

        handleDirection();

        Actor wall = getWallOnTheWay();

        if(wall == null){
            setLocation(currentX + offsetX, currentY + offsetY);
        }

    }
    private void handleDirection()
    {
        if(Greenfoot.isKeyDown("UP")){
            offsetX = 0;
            offsetY = -OFFSET;
            direction = UP;
        } else if(Greenfoot.isKeyDown("DOWN")){
            offsetX = 0;
            offsetY = OFFSET;
            direction = DOWN;
        } else if(Greenfoot.isKeyDown("RIGHT")){
            offsetY = 0;
            offsetX = OFFSET;
            direction = RIGHT;
        } else if(Greenfoot.isKeyDown("LEFT")){
            offsetY = 0;
            offsetX = -OFFSET;
            direction = LEFT;
        }
    }

    private Wall getWallOnTheWay(){

        switch(direction){
            case UP:
                return (Wall)getOneObjectAtOffset​(0, -30, Wall.class);
            case DOWN:
                return (Wall)getOneObjectAtOffset​(0, 30, Wall.class);
            case RIGHT:
                return (Wall)getOneObjectAtOffset​(30, 0, Wall.class);
            case LEFT:
                return (Wall)getOneObjectAtOffset​(-30, 0, Wall.class);
        }

        return null;
    }
}
