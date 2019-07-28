package Main;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Player extends Drawable {

    //STATS FOR PLAYER	
    private int hp = 3;
    private int moveLength, dropSpeed;
    private boolean jumping; //SO PERSON CANT JUMP MORE THAN 1 TIME WHILE IN AIR

    public Player(int x, int y, int h, int w, Color c) {   
        super(x, y, h, w, c);
        moveLength = 10; //FOR TESTING
        dropSpeed = 2;
        jumping = false;        
    }

    /////////////MOVE METHODE
    public void move(String direction) //
    {
        if (direction == "LEFT") {
            posX -= moveLength;
            System.out.println("MOVEMENTSYSTEM UEBERPRUEFUNG: " + "LEFT");
        }
        if (direction == "RIGHT") {
            posX += moveLength;
            System.out.println("MOVEMENTSYSTEM UEBERPRUEFUNG: " + "RIGHT");
        }
    }

    public void jump() {
       if (!jumping)
       {
           Jump jump = new Jump();
           jump.start();
       }
    }

    public void crouch() {
        System.out.println("MOVEMENTSYSTEM UEBERPRUEFUNG: " + "CROUCH");
    }
    public void fallDown(){
        posY += dropSpeed;
    }

    public int getMoveLength() {
        return moveLength;
    }

    public boolean isJumping() {
        return jumping;
    }

    public Boolean checkTouch(Rectangle other) {   
        return (this.getRectangle().intersects(other));     
    }
  

    //INNER CLASS WITH THREAD TO HANDLE JUMPING
    private class Jump extends Thread {

        private boolean hochpunktErreicht = false;
        private boolean fertig = false;
        private int sprungHoehe;
        private int anfangY;

        public boolean heldUeberHindernis;
        private int zwischenY;

        public Jump() {
            jumping = true;
            anfangY = posY;
            sprungHoehe = 180;
                    //+ (anfangY - posY);
            System.out.println("MOVEMENTSYSTEM UEBERPRUEFUNG: " + "SPRING");
            
        }

        public void run() {

            int delay = 4;
            fertig = false;
          //  posY -= 2;
            while (fertig != true) {

                //  if (derHeld.direktUeberHindernis() == true) {
                //      fertig = true;
                //  } else {
                springen();
                //   }

                try {
                    Thread.sleep(delay);
                } catch (Exception e) {

                }
            }

            hochpunktErreicht = false;
            
            jumping = false;
        }

        private void springen() {

         //   if (derHeld.direktUnterHindernis() == true) {
         //       positionY++;
         //       hochpunktErreicht = true;
          //  }
            if (hochpunktErreicht == false) {
                
                posY -= dropSpeed;
            }
            if (posY == (anfangY - sprungHoehe)) {
                hochpunktErreicht = true;
            }
            if (hochpunktErreicht == true && posY <= anfangY) {
                
                posY += dropSpeed;
                if (posY == anfangY) {

                    fertig = true;

                }
            }
        }
    }   
}

